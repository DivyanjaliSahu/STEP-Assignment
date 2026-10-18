package Session5.Assignment5;

public class Problem3 {
    static String findMinMaxSpread(int[] scores) {
        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }

            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;

        return "Min: " + min + ", Max: " + max + ", Spread: " + spread;
    }

    public static void main(String[] args) {
        int[] scores = {45, 80, 62, 95, 30, 70};

        System.out.println(findMinMaxSpread(scores));
    }
}
