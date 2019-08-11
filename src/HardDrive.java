public class HardDrive extends Part {
    private int capacity;

    public HardDrive(String name, String producer, String serialNumber, int capacity) throws PartSerialNumberUndefinedExceptions, PartProducerUndefinedExeptions, PartNameUndefinedExeptions {
        super(name, producer, serialNumber);
        setCapacity(capacity);
    }

    private void checkCapacityPreconditions(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Pojemność dysku twardego musi być większa od 0");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        checkCapacityPreconditions(capacity);
        this.capacity = capacity;
    }
}
