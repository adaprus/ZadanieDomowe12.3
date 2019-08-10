public class Ram extends Part implements TimingChangeable {
    private Timing timing;
    private int memory;
    private static final int TEMPERATURE_RAISE = 15;

    public Ram() {
    }

    public Ram(String name, String producer, String serialNumber, Timing timing, int memory) throws PartUndefinedExeptions {
        super(name, producer, serialNumber);
        checkPartPreconditions(name, producer, serialNumber);
        checkRamPreconditions(timing, memory);
        this.timing = timing;
        this.memory = memory;
    }

    private void checkRamPreconditions(Timing timing, int memory) {
        if (memory < 0) {
            throw new IllegalArgumentException("Pamięć RAM musi mieć wartość większą niż 0");
        } else if (timing == null) {
            throw new NullPointerException("Pamięć RAM musi mieć przypisane taktowanie");
        }
    }


    public Timing getTiming() {
        return timing;
    }

    public void setTiming(Timing timing) {
        this.timing = timing;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public void raiseTiming(int value) {
        if (timing.getTiming() + value > timing.getMaxTiming()) {
            throw new IllegalArgumentException("Przekroczono taktowanie maksymalne");
        } else if (timing.getNormalTemperature() + TEMPERATURE_RAISE * (value / 100) > timing.getCriticalTemperature()) {
            throw new IllegalArgumentException("Temperatura przekroczy poziom krytyczny");
        }
        timing.setTiming(timing.getTiming() + value);
    }
}
