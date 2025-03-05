public class Driver {
    public static final String FILE_NAME = "testfile.txt";

    public static void main(String[] args) {
        // Provided code is C-style declaration?
        Student[] lab2 = new Student[40];

        // Provided code reads lab2 = Util.readFile("filename.txt", lab2); ?
        // readFile() is void. Assignment of Student[] array handled in-method

        Util.readFile(FILE_NAME, lab2);
        Statistics statlab2 = new Statistics();

        statlab2.findLow(lab2);
        statlab2.findHigh(lab2);
        statlab2.findAvg(lab2);

        // This main assumes the user wants to see all data; I am foregoing
        // ... user input prompts for brevity.
        statlab2.print(4);
    }
}
