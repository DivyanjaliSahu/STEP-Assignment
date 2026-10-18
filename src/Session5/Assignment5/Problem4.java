package Session5.Assignment5;

public class Problem4 {

    private static double rowAverage(int[] row) {
        int total = 0;

        for (int runs : row) {
            total += runs;
        }

        return (double) total / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        int highScoringMatches = 0;
        int lowScoringMatches = 0;

        for (int[] match : runsPerOver) {
            double average = rowAverage(match);

            if (average >= threshold) {
                highScoringMatches++;
            } else {
                lowScoringMatches++;
            }
        }

        return "High scoring matches: " + highScoringMatches
                + ", Low scoring matches: " + lowScoringMatches;
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
            {8, 10, 7, 12},
            {3, 4, 5, 2},
            {9, 8, 11, 10}
        };

        int threshold = 7;

        System.out.println(classifyMatches(runsPerOver, threshold));
    }
}
