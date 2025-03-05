public class Student {
    // Magic num. defines # of quizzes per kid
    public static final int NUM_OF_QUIZZES = 5;

    private int SID;
    private int[] scores = new int[NUM_OF_QUIZZES];

    /* This constructor technically accepts a flexible array size. In this
    * implementation, line 3 specifies that each object shall have 5 scores.
    * This class will still work if it's changed, but caller-side code may
    * break if it uses magic numbers */

    public Student(int[] array) {
        // Input array contains SID at pos 0; 6 elements long
        // First value will be assumed SID
        this.SID = array[0];
        // Note manual array copy below
        // System.arraycopy(sArray, 1, this.scores, 1, sArray.length - 1);
        for (int i = 0; i < scores.length; i++) {
            this.scores[i] = array[i+1];
        }
        /* I recognize that this for-loop is a bit fragile & unclear due
        * to the use of i to access arrays of different sizes */
    }

    // scores() getter returns INT array of size 5
    public int SID() { return SID; }
    public int[] scores() { return scores; }

    // setScores MUST be given INT array of size 5. No input validation
    public void setScores(int[] scores) { this.scores = scores; }
    public void setSID(int SID) { this.SID = SID; }

    public void print() {
        System.out.printf("\nSID: %d\n", SID);
        System.out.printf("Scores: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf(" %d\n", scores[i]);
        }

    }
}
