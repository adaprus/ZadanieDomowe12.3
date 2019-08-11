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
        setTiming(timing);
        setNormalTemperature(normalTemperature);
        setCriticalTemperature(criticalTemperature);
        setMaxTiming(maxTiming);
    }

    private void checkTimingPreconditions(int timing) {
        if (timing < 0) {
            throw new IllegalArgumentException("Taktowanie musi być dodatnie");
        }
    }

    private void checkNormalTemperaturePreconditions(int normalTemperature) {
        if (normalTemperature < 0) {
            throw new IllegalArgumentException("Temperatura pracy musi być dodatnia");
        }
    }

    private void checkCriticalTemperaturePreconditions(int criticalTemperature) {
        if (criticalTemperature < normalTemperature) {
            throw new IllegalArgumentException("Temperatura krytyczna nie może być mniejsza od temperatury pracy normalnej");
        }
    }

    private void checkMaxTimingPreconditions(int maxTiming) {
        if (maxTiming < timing) {
            throw new IllegalArgumentException("Taktowanie maksymalne musi mieć wartość wyższą od normalnego taktowania");
        }
    }

    public int getTiming() {
        return timing;
    }

    public void setTiming(int timing) {
        checkTimingPreconditions(timing);
        this.timing = timing;
    }

    public int getNormalTemperature() {
        return normalTemperature;
    }

    public void setNormalTemperature(int normalTemperature) {
        checkNormalTemperaturePreconditions(normalTemperature);
        this.normalTemperature = normalTemperature;
    }

    public int getCriticalTemperature() {
        return criticalTemperature;
    }

    public void setCriticalTemperature(int criticalTemperature) {
        checkCriticalTemperaturePreconditions(criticalTemperature);
        this.criticalTemperature = criticalTemperature;
    }

    public int getMaxTiming() {
        return maxTiming;
    }

    public void setMaxTiming(int maxTiming) {
        checkMaxTimingPreconditions(maxTiming);
        this.maxTiming = maxTiming;
    }
}

