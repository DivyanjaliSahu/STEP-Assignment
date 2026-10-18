package Session8.Assignment8;

import java.util.*;

public class Problem2 {

    interface Vehicle {
        double calculateCharge(int hours);
    }

    static class Bike implements Vehicle {
        public double calculateCharge(int hours) {
            return hours * 10.0;
        }
    }

    static class Car implements Vehicle {
        public double calculateCharge(int hours) {
            return 30 + (hours - 1) * 20.0;
        }
    }

    static class Truck implements Vehicle {
        public double calculateCharge(int hours) {
            return Math.max(100, hours * 50.0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new HashMap<>();
        vehicles.put("BIKE", new Bike());
        vehicles.put("CAR", new Car());
        vehicles.put("TRUCK", new Truck());

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int hours = sc.nextInt();

            Vehicle vehicle = vehicles.get(type);
            double charge = vehicle.calculateCharge(hours);

            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

