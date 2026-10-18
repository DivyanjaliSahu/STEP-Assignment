
package Session9.Assignment9;

import java.util.*;

public class Problem1 {

    static abstract class Ticket {
        private static final double CONVENIENCE_FEE = 20.0;

        abstract double getPrice();

        public double calculateAmount(int count) {
            return (getPrice() + CONVENIENCE_FEE) * count;
        }
    }

    static class Regular extends Ticket {
        double getPrice() {
            return 150;
        }
    }

    static class Premium extends Ticket {
        double getPrice() {
            return 250;
        }
    }

    static class Recliner extends Ticket {
        double getPrice() {
            return 400;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Ticket> tickets = new HashMap<>();

        tickets.put("REGULAR", new Regular());
        tickets.put("PREMIUM", new Premium());
        tickets.put("RECLINER", new Recliner());

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int count = sc.nextInt();

            double amount = tickets.get(type).calculateAmount(count);
            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

