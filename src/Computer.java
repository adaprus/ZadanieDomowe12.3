public class Computer {
    private Processor processor;
    private Ram ram;
    private HardDrive hardDrive;

    public Computer() {
    }

    public Computer(Processor processor, Ram ram, HardDrive hardDrive) {
        computerPreconditions(processor, ram, hardDrive);
        this.processor = processor;
        this.ram = ram;
        this.hardDrive = hardDrive;
    }

    private void computerPreconditions(Processor processor, Ram ram, HardDrive hardDrive) {
        if (processor == null) {
            throw new NullPointerException("Komputer musi mieć przypisany procesor");
        } else if (ram == null) {
            throw new NullPointerException("Komputer musi mieć przypisaną pamięć RAM");
        } else if (hardDrive == null) {
            throw new NullPointerException("Komputer musi mieć przypisany dysk twardy");
        }
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
    }
}
