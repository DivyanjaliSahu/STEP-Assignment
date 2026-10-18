
package Session8.PracticeProblem8;

import java.util.*;

public class Problem5 {
    interface Transport {
        double calculateFare(double distance);
    }

    static class Bus implements Transport {
        public double calculateFare(double distance) {
            return Math.min(10, 2 + 0.10 * distance);
        }
    }

    static class Train implements Transport {
        public double calculateFare(double distance) {
            return 3 + 0.15 * distance;
        }
    }

    static class Metro implements Transport {
        private final double peakHourFactor;

        Metro(double peakHourFactor) {
            this.peakHourFactor = peakHourFactor;
        }

        public double calculateFare(double distance) {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            Transport transport;

            switch (type) {
                case "BUS":
                    transport = new Bus();
                    break;
                case "TRAIN":
                    transport = new Train();
                    break;
                case "METRO":
                    double factor = sc.nextDouble();
                    transport = new Metro(factor);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown transport type");
            }

            double fare = transport.calculateFare(distance);
            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
