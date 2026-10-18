
package Session9.Assignment9;

import java.util.*;

public class Problem3 {

    interface BusUser {
        double TRANSPORT_FEE = 12000.0;
    }

    static abstract class Student {
        protected String name;

        Student(String name) {
            this.name = name;
        }

        abstract double calculateTuition();

        public double calculateTotalFee() {
            double total = calculateTuition();

            if (this instanceof BusUser) {
                total += BusUser.TRANSPORT_FEE;
            }

            return total;
        }
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String name) {
            super(name);
        }

        double calculateTuition() {
            return 40000;
        }
    }

    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }

        double calculateTuition() {
            return 40000 + 60000;
        }
    }

    static class Scholar extends Student implements BusUser {
        Scholar(String name) {
            super(name);
        }

        double calculateTuition() {
            return 20000;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, java.util.function.Function<String, Student>> types =
            new HashMap<>();

        types.put("DAY_SCHOLAR", DayScholar::new);
        types.put("HOSTELLER", Hosteller::new);
        types.put("SCHOLAR", Scholar::new);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Student student = types.get(type).apply(name);
            double fee = student.calculateTotalFee();

            System.out.printf("%s: %.2f%n", name, fee);
            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
