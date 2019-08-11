public class Test {
    public static void main(String[] args) {

        try {
            Timing timing = new Timing(1066, 70, 95, 3100);
            Timing timing1 = new Timing(1066, 70, 80, 1300);
            Processor processor = new Processor("Procesor", "Intel", "6789676", timing);
            Ram ram = new Ram("Pamięć RAM", "ABM", "hndk900", timing1, 456);
            HardDrive drive = new HardDrive("Dysk twardy", "ABM", "679303NMN", 6789);
            Computer computer = new Computer(processor, ram, drive);

            ram.raiseTiming(300);
            processor.raiseTiming(60);

        } catch (NullPointerException | IllegalArgumentException | PartNameUndefinedExeptions |
                PartProducerUndefinedExeptions | PartSerialNumberUndefinedExceptions e) {
            System.out.println(e.getMessage());
        }
    }
}
