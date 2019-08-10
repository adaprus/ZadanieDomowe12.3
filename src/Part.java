public abstract class Part {
    private String name;
    private String producer;
    private String serialNumber;

    public Part() {
    }

    public Part(String name, String producer, String serialNumber) throws PartUndefinedExeptions {
        checkPartPreconditions(name, producer, serialNumber);
        this.name = name;
        this.producer = producer;
        this.serialNumber = serialNumber;
    }

    public void checkPartPreconditions(String name, String producer, String serialNumber) throws PartUndefinedExeptions {
        if (name == null) {
            throw new NullPointerException("Podaj nazwę części");
        } else if (producer == null) {
            throw new NullPointerException("Podaj producenta");
        } else if (serialNumber == null) {
            throw new NullPointerException("Podaj numer seryjny");
        } else if (name.length() < 3) {
            throw new PartUndefinedExeptions();
        } else if (producer.length() < 3) {
            throw new PartUndefinedExeptions();
        } else if (serialNumber.length() < 5) {
            throw new PartUndefinedExeptions();
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
