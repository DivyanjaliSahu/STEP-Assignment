package Session8.Assignment8;

import java.util.*;

public class Problem3 {

    interface Room {
        double calculateBill();
    }

    static class SingleRoom implements Room {
        private final int units;

        SingleRoom(int units) {
            this.units = units;
        }

        public double calculateBill() {
            return units * 8.0;
        }
    }

    static class SharedRoom implements Room {
        private final int units;
        private final int occupants;

        SharedRoom(int units, int occupants) {
            this.units = units;
            this.occupants = occupants;
        }

        public double calculateBill() {
            return (units * 6.0) / occupants;
        }
    }

    static class ACRoom implements Room {
        private final int units;

        ACRoom(int units) {
            this.units = units;
        }

        public double calculateBill() {
            return units * 10.0 + 200;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, java.util.function.IntFunction<Room>> roomTypes =
                new HashMap<>();

        roomTypes.put("SINGLE", units -> new SingleRoom(units));
        roomTypes.put("AC", units -> new ACRoom(units));

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();

            Room room;

            if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                room = new SharedRoom(units, occupants);
            } else {
                room = roomTypes.get(type).apply(units);
            }

            double bill = room.calculateBill();

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

