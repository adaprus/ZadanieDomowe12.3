public class Computer {
    private Processor processor;
    private Ram ram;
    private HardDrive hardDrive;

    public Computer(Processor processor, Ram ram, HardDrive hardDrive) {
        setProcessor(processor);
        setRam(ram);
        setHardDrive(hardDrive);
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        if (processor == null) {
            throw new NullPointerException("Komputer musi mieć przypisany procesor");
        }
        this.processor = processor;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        if (ram == null) {
            throw new NullPointerException("Komputer musi mieć przypisaną pamięć RAM");
        }
        this.ram = ram;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(HardDrive hardDrive) {
        if (hardDrive == null) {
            throw new NullPointerException("Komputer musi mieć przypisany dysk twardy");
        }
        this.hardDrive = hardDrive;
    }
}
