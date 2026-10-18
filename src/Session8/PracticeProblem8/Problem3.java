
package Session8.PracticeProblem8;

import java.util.*;

public class Problem3 {
    interface Delivery {
        double calculateFee(double weight, double distance);
    }

    static class Standard implements Delivery {
        public double calculateFee(double weight, double distance) {
            return 5 + 0.50 * weight + 0.10 * distance;
        }
    }

    static class Express implements Delivery {
        public double calculateFee(double weight, double distance) {
            return 15 + weight + 0.20 * distance;
        }
    }

    static class International implements Delivery {
        private final double customsFee;

        International(double customsFee) {
            this.customsFee = customsFee;
        }

        public double calculateFee(double weight, double distance) {
            return 25 + 2.0 * weight + 0.50 * distance + customsFee;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            Delivery delivery;

            switch (type) {
                case "STANDARD":
                    delivery = new Standard();
                    break;
                case "EXPRESS":
                    delivery = new Express();
                    break;
                case "INTERNATIONAL":
                    double customsFee = sc.nextDouble();
                    delivery = new International(customsFee);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown delivery type");
            }

            double fee = delivery.calculateFee(weight, distance);
            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

    
