public abstract class Part {
    private String name;
    private String producer;
    private String serialNumber;

    public Part(String name, String producer, String serialNumber) throws PartSerialNumberUndefinedExceptions, PartNameUndefinedExeptions, PartProducerUndefinedExeptions {
        setName(name);
        setProducer(producer);
        setSerialNumber(serialNumber);
    }

    public void checkNamePartPreconditions(String name) throws PartNameUndefinedExeptions {
        if (name == null) {
            throw new NullPointerException("Podaj nazwę części");
        } else if (name.length() < 3) {
            throw new PartNameUndefinedExeptions();
        }
    }

    public void checkPartSerialNumberUndefinedPreconditions(String serialNumber) throws PartSerialNumberUndefinedExceptions {
        if (serialNumber == null) {
            throw new NullPointerException("Podaj numer seryjny");
        } else if (serialNumber.length() < 5) {
            throw new PartSerialNumberUndefinedExceptions();
        }
    }

    public void checkProducerPartPreconditions(String producer) throws PartProducerUndefinedExeptions {
        if (producer == null) {
            throw new NullPointerException("Podaj producenta");
        } else if (producer.length() < 3) {
            throw new PartProducerUndefinedExeptions();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws PartNameUndefinedExeptions {
        checkNamePartPreconditions(name);
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) throws PartProducerUndefinedExeptions {
        checkProducerPartPreconditions(producer);
        this.producer = producer;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) throws PartSerialNumberUndefinedExceptions {
        checkPartSerialNumberUndefinedPreconditions(serialNumber);
        this.serialNumber = serialNumber;
    }
}
