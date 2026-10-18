
package Session8.PracticeProblem8;

import java.util.*;
import java.util.regex.*;

public class Problem4 {
    interface Question {
        double grade(String correct, String answer, double points);
    }

    static class MCQ implements Question {
        public double grade(String correct, String answer, double points) {
            return correct.equals(answer) ? points : 0;
        }
    }

    static class TF implements Question {
        public double grade(String correct, String answer, double points) {
            return correct.equals(answer) ? points : 0;
        }
    }

    static class Essay implements Question {
        public double grade(String correct, String answer, double points) {
            String[] keywords = correct.split(",");
            int matches = 0;
            String studentAnswer = answer.toLowerCase();

            for (String keyword : keywords) {
                if (studentAnswer.contains(keyword.trim().toLowerCase())) {
                    matches++;
                }
            }

            if (matches >= 2) {
                return points * 0.75;
            } else if (matches == 1) {
                return points * 0.50;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Question> questionTypes = new HashMap<>();
        questionTypes.put("MCQ", new MCQ());
        questionTypes.put("TF", new TF());
        questionTypes.put("ESSAY", new Essay());

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);
            List<String> fields = new ArrayList<>();

            while (matcher.find()) {
                fields.add(matcher.group(1) != null
                    ? matcher.group(1) : matcher.group(2));
            }

            String type = fields.get(0);
            // fields[1] is the question text
            String correct = fields.get(2);
            String answer = fields.get(3);
            double points = Double.parseDouble(fields.get(4));

            double score = questionTypes.get(type)
                .grade(correct, answer, points);

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}

