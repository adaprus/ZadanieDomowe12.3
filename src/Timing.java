class Timing implements TimingChangeable {
    private int timing;
    private int normalTemperature;
    private int criticalTemperature;
    private int maxTiming;

    public void raiseTiming(int value) {
        if (timing + value > maxTiming) {
            throw new IllegalArgumentException("Za wysoka wartość taktowania");
        }
        timing += value;
    }

    public Timing(int timing, int normalTemperature, int criticalTemperature, int maxTiming) {
        checkTimingPreconditions(timing, normalTemperature, criticalTemperature, maxTiming);
        this.timing = timing;
        this.normalTemperature = normalTemperature;
        this.criticalTemperature = criticalTemperature;
        this.maxTiming = maxTiming;
    }

    private void checkTimingPreconditions(int timing, int normalTemperature, int criticalTemperature, int maxTiming) {
        if (timing < 0) {
            throw new IllegalArgumentException("Taktowanie musi być dodatnie");
        } else if (normalTemperature < 0) {
            throw new IllegalArgumentException("Temperatura pracy musi być dodatnia");
        } else if (criticalTemperature < normalTemperature) {
            throw new IllegalArgumentException("Temperatura krytyczna nie może być mniejsza od temperatury pracy normalnej");
        } else if (maxTiming < normalTemperature) {
            throw new IllegalArgumentException("Taktowanie maksymalne musi mieć wartość wyższą od normalnego taktowania");
        }
    }

    public Timing() {
    }

    public int getTiming() {
        return timing;
    }

    public void setTiming(int timing) {
        this.timing = timing;
    }

    public int getNormalTemperature() {
        return normalTemperature;
    }

    public void setNormalTemperature(int normalTemperature) {
        this.normalTemperature = normalTemperature;
    }

    public int getCriticalTemperature() {
        return criticalTemperature;
    }

    public void setCriticalTemperature(int criticalTemperature) {
        this.criticalTemperature = criticalTemperature;
    }

    public int getMaxTiming() {
        return maxTiming;
    }

    public void setMaxTiming(int maxTiming) {
        this.maxTiming = maxTiming;
    }
}

