public class Computer {
    private Processor processor;
    private Ram ram;
    private HardDrive hardDrive;

    public Computer(Processor processor, Ram ram, HardDrive hardDrive) {
        setProcessor(processor);
        setRam(ram);
        setHardDrive(hardDrive);
    }

    private void computerProcessorPreconditions(Processor processor) {
        if (processor == null) {
            throw new NullPointerException("Komputer musi mieć przypisany procesor");
        }
    }

    private void computerRamPreconditions(Ram ram) {
        if (ram == null) {
            throw new NullPointerException("Komputer musi mieć przypisaną pamięć RAM");
        }
    }

    private void computerHardDrivePreconditions(HardDrive hardDrive) {
        if (hardDrive == null) {
            throw new NullPointerException("Komputer musi mieć przypisany dysk twardy");
        }
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        computerProcessorPreconditions(processor);
        this.processor = processor;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        computerRamPreconditions(ram);
        this.ram = ram;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(HardDrive hardDrive) {
        computerHardDrivePreconditions(hardDrive);
        this.hardDrive = hardDrive;
    }
}
