package Session7.PracticeProblem7;

public class Problem2 {

    static class Scorecard {
        private final boolean[] results;
        private int answersRecorded;

        public Scorecard(int questionCount) {
            if (questionCount < 0) {
                throw new IllegalArgumentException(
                    "Question count cannot be negative."
                );
            }

            results = new boolean[questionCount];
            answersRecorded = 0;
        }

        public void recordAnswer(boolean correct) {
            if (answersRecorded >= results.length) {
                System.out.println(
                    "Cannot record answer: all questions are completed."
                );
                return;
            }

            results[answersRecorded] = correct;
            answersRecorded++;
        }

        public int getScore() {
            int score = 0;

            for (int i = 0; i < answersRecorded; i++) {
                if (results[i]) {
                    score++;
                }
            }

            return score;
        }
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Quiz score: " + sc.getScore());

        // This extra answer will be rejected.
        sc.recordAnswer(true);
        System.out.println("Final score: " + sc.getScore());
    }
}
