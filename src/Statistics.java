public class Statistics {
    // Magic num. defines # of quizzes per kid
    public static final int NUM_OF_QUIZZES = 5;
    public static final int MAX_SCORE = 100;

    /* I am assuming the intent is to gather highest, lowest, and avg for
    * EACH quiz across all students */

    private int[] lowScores = new int[NUM_OF_QUIZZES];
    private int[] highScores = new int[NUM_OF_QUIZZES];
    private float[] avgScores = new float[NUM_OF_QUIZZES];

    public Statistics() {
        // Does nothing
    }

    // If you want to create an instance w/ user-input values, sure
    public Statistics(int[] lowScores, int[] highScores, float[] avgScores) {
        this.lowScores = lowScores;
        this.highScores = highScores;
        this.avgScores = avgScores;
    }

    public void findLow(Student[] sArray) {
        // Flexible size: method peeks at length of scores[] array in the
        // ... first Student object

        // Outer: analysis of each quiz #
        // Inner: grab that quiz # score from each Student
        for (int i = 0; i < sArray[0].scores().length; i++) {
            int low = MAX_SCORE; // can be dynamic, i think

            for (Student s : sArray) {
                // Also not a great fix. sArray is 40 elements long, but
                // ... there are only 15 students in the given test file
                if (s == null) break;
                low = s.scores()[i] < low ? s.scores()[i] : low;
                // Can be Math.min call
            }
            // Assign lowest found score to array position
            // Each position corresponds to a certain quiz #
            this.lowScores[i] = low;
        }
    }
    public void findHigh(Student[] sArray) {
        for (int i = 0; i < sArray[0].scores().length; i++) {
            int high = 0;

            for (Student s : sArray) {
                if (s == null) break;
                high = s.scores()[i] > high ? s.scores()[i] : high;
            }
            this.highScores[i] = high;
        }
    }
    public void findAvg(Student[] sArray) {
        for (int i = 0; i < sArray[0].scores().length; i++) {
            int avg = 0;

            for (Student s : sArray) {
                if (s == null) break;
                avg += s.scores()[i];
            }
            // Cast int avg to float, then divide by # of students
            avgScores[i] = (float) avg / sArray.length;
        }
    }

    /* Notes for print –
    * print() is designed as a switch statement. Each case makes a call to
    * separately-defined methods that each output low, high, and avg scores
    * This is so case 4 can call all 3 print "sub-methods" without massively
    * repeating code */

    public void print(int option) {
        // 1. low; 2. high; 3. avg; 4. all
        switch (option) {
            case 1:
                printLow();
                break;
            case 2:
                printHigh();
                break;
            case 3:
                printAvg();
                break;
            case 4:
                printLow();
                printHigh();
                printAvg();
                break;
        }
    }

    public void printLow() {
        System.out.printf("\nLowest:   ");
        for (int i = 0; i < lowScores.length; i++) {
            System.out.printf(" " + lowScores[i]);
        }
    }

    public void printHigh() {
        System.out.printf("\nHighest:  ");
        for (int i = 0; i < highScores.length; i++) {
            System.out.printf(" " + highScores[i]);
        }
    }

    public void printAvg() {
        System.out.printf("\nAverage:  ");
        for (int i = 0; i < avgScores.length; i++) {
            System.out.printf(" %.1f", avgScores[i]);
        }
    }
}
