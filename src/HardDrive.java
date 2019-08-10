public class HardDrive extends Part {
    private int capacity;

    public HardDrive() {
    }

    public HardDrive(String name, String producer, String serialNumber, int capacity) throws PartUndefinedExeptions {
        super(name, producer, serialNumber);
        checkPartPreconditions(name, producer, serialNumber);
        checkCapacityPreconditions(capacity);
        this.capacity = capacity;
    }

    private void checkCapacityPreconditions(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Pojemność dysku twaredgo musi być większa od 0");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
