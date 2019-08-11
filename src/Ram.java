public class Ram extends Part implements TimingChangeable {
    private Timing timing;
    private int memory;
    private static final int TEMPERATURE_RAISE = 15;

    public Ram(String name, String producer, String serialNumber, Timing timing, int memory) throws PartSerialNumberUndefinedExceptions, PartProducerUndefinedExeptions, PartNameUndefinedExeptions {
        super(name, producer, serialNumber);
        setTiming(timing);
        setMemory(memory);
    }

    private void checkRamMemoryPreconditions(int memory) {
        if (memory < 0) {
            throw new IllegalArgumentException("Pamięć RAM musi mieć wartość większą niż 0");
        }
    }

    private void checkRamTiming(Timing timing) {
        if (timing == null) {
            throw new NullPointerException("Pamięć RAM musi mieć przypisane taktowanie");
        }
    }

    public Timing getTiming() {
        return timing;
    }

    public void setTiming(Timing timing) {
        checkRamTiming(timing);
        this.timing = timing;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        checkRamMemoryPreconditions(memory);
        this.memory = memory;
    }

    @Override
    public void raiseTiming(int value) {
        if (timing.getTiming() + value > timing.getMaxTiming()) {
            throw new IllegalArgumentException("Przekroczono maksymalne taktowanie pamięci RAM");
        } else if (timing.getNormalTemperature() + TEMPERATURE_RAISE * (value / 100) > timing.getCriticalTemperature()) {
            throw new IllegalArgumentException("Temperatura przekroczy poziom krytyczny");
        }
        timing.setTiming(timing.getTiming() + value);
    }
}
