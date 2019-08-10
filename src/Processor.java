public class Processor extends Part implements TimingChangeable {
    private Timing timing;
    private static final int TEMPERATURE_RAISE = 10;

    public Processor() {
    }

    public Processor(String name, String producer, String serialNumber, Timing timing) throws PartUndefinedExeptions {
        super(name, producer, serialNumber);
        checkPartPreconditions(name, producer, serialNumber);
        processorPreconditions(timing);
        this.timing = timing;
    }

    private void processorPreconditions(Timing timing) {
        if (timing == null) {
            throw new NullPointerException("Procesor musi mieć przypisane taktowanie");
        }
    }

    public Timing getTiming() {
        return timing;
    }

    public void setTiming(Timing timing) {
        this.timing = timing;
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
