
package Session9.Assignment9;

import java.util.*;

public class Problem4 {

    interface NightService {
        double NIGHT_MULTIPLIER = 1.20;
    }

    static abstract class Cab {
        abstract double getRate();

        public double calculateFare(double km) {
            return Math.max(100, km * getRate());
        }
    }

    static class Mini extends Cab {
        double getRate() {
            return 10;
        }
    }

    static class Sedan extends Cab implements NightService {
        double getRate() {
            return 14;
        }

        public double calculateNightFare(double km) {
            return calculateFare(km) * NIGHT_MULTIPLIER;
        }
    }

    static class SUV extends Cab implements NightService {
        double getRate() {
            return 18;
        }

        public double calculateNightFare(double km) {
            return calculateFare(km) * NIGHT_MULTIPLIER;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Cab> cabs = new HashMap<>();

        cabs.put("MINI", new Mini());
        cabs.put("SEDAN", new Sedan());
        cabs.put("SUV", new SUV());

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab = cabs.get(type);

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare;

            if (time.equals("NIGHT")) {
                if (cab instanceof Sedan) {
                    fare = ((Sedan) cab).calculateNightFare(km);
                } else {
                    fare = ((SUV) cab).calculateNightFare(km);
                }
            } else {
                fare = cab.calculateFare(km);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

