
package Session9.Assignment9;

import java.util.*;

public class Problem5 {

    interface SaverMode {
        double SAVER_FACTOR = 0.75;
    }

    static abstract class Appliance {
        abstract double getPower();

        public double calculateUnits(double hours) {
            return getPower() * hours / 1000.0;
        }

        public double calculateCost(double units) {
            return units * 8.0;
        }
    }

    static class Fridge extends Appliance {
        double getPower() {
            return 150;
        }
    }

    static class AC extends Appliance implements SaverMode {
        double getPower() {
            return 1500;
        }

        public double calculateSaverUnits(double hours) {
            return calculateUnits(hours) * SAVER_FACTOR;
        }
    }

    static class TV extends Appliance {
        double getPower() {
            return 100;
        }
    }

    static class Washer extends Appliance implements SaverMode {
        double getPower() {
            return 500;
        }

        public double calculateSaverUnits(double hours) {
            return calculateUnits(hours) * SAVER_FACTOR;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Appliance> appliances = new HashMap<>();

        appliances.put("FRIDGE", new Fridge());
        appliances.put("AC", new AC());
        appliances.put("TV", new TV());
        appliances.put("WASHER", new Washer());

        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0].toUpperCase();
            double hours = Double.parseDouble(input[1]);
            boolean saver = input.length > 2
                && input[2].equalsIgnoreCase("SAVER");

            Appliance appliance = appliances.get(type);

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units;

            if (saver) {
                if (appliance instanceof AC) {
                    units = ((AC) appliance).calculateSaverUnits(hours);
                } else {
                    units = ((Washer) appliance).calculateSaverUnits(hours);
                }
            } else {
                units = appliance.calculateUnits(hours);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}

