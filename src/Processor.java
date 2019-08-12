public class Processor extends Part implements TimingChangeable {
    private Timing timing;
    private static final int TEMPERATURE_RAISE = 10;

    public Processor(String name, String producer, String serialNumber, Timing timing) throws PartSerialNumberUndefinedExceptions, PartProducerUndefinedExceptions, PartNameUndefinedExeptions {
        super(name, producer, serialNumber);
        setTiming(timing);
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
        processorPreconditions(timing);
        this.timing = timing;
    }

    @Override
    public void raiseTiming(int value) {
        if (timing.getTiming() + value > timing.getMaxTiming()) {
            throw new IllegalArgumentException("Przekroczono maksymalne taktowanie procesora");
        } else if (timing.getNormalTemperature() + TEMPERATURE_RAISE * (value / 100) > timing.getCriticalTemperature()) {
            throw new IllegalArgumentException("Temperatura procesora przekroczy poziom krytyczny");
        }
        timing.setTiming(timing.getTiming() + value);
    }
}
