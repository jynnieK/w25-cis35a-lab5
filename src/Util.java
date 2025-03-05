import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Util {
    private String fname;

    // Give filename when instantiating a Util obj
    public Util(String fname) {
        this.fname = fname;
    }

    // Give filename when calling readFile & an array of Student objects
    // Array MUST be >= # of students in file. There is no size validation
    // Does this need to be non-static? Driver main() is static and therefore
    // ... readFile() must be as well
    public static void readFile(String filename, Student[] stu) {
        try {
            // OK to instantiate FileReader within BufferedReader?
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String line = reader.readLine(); // move past header
            line = reader.readLine(); // move past 1st newline

            // "line" assigned inside while cond.
            // Outer loop operates on each line,
            // Inner loop operates on each item within line
            int index = 0; // I am NOT A FAN of this iterator approach but
            // ... not sure how else to insert into stu[]
            while ((line = reader.readLine()) != null) {
                // This is a terrible bugfix but I have 20 minutes to midnight
                if (line.length() < 2) { continue; }
                // The line skips between datapoints are doing me in

                // OK to instantiate new obj each loop iteration?
                StringTokenizer st = new StringTokenizer(line);

                int[] array = new int[6];
                // As good practice, I'd want some kind of input validation
                // For now just assuming the data is formatted correctly
                for (int i = 0; i < array.length; i++) {
                    array[i] = Integer.parseInt(st.nextToken());
                }
                stu[index] = new Student(array);
                index++;
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
    }
}
