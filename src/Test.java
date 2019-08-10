public class Test {
    public static void main(String[] args) {

        try {
            Timing timing = new Timing(2500, 70, 95, 3100);
            Timing timing1 = new Timing(1066, 70, 80, 1300);
            Processor processor = new Processor("Intel", "ABM", "6789NMH8", timing);
            Ram ram = new Ram("RAm", "ABM", "hndk900", timing1, 456);
            HardDrive drive = new HardDrive("hdjv", "ABM", "679303NMN", 6789);
            Computer computer = new Computer(processor, ram, drive);
            ram.raiseTiming(50);
            processor.raiseTiming(800);
        } catch (NullPointerException | IllegalArgumentException | PartUndefinedExeptions e) {
            System.out.println(e.getMessage());
        }
    }
}
