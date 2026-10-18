package Session8.Assignment8;

import java.util.*;

public class Problem4 {

    interface Employee {
        String getName();
        double calculateBonus();
    }

    static class FullTime implements Employee {
        private final String name;
        private final double salary;

        FullTime(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double calculateBonus() {
            return salary * 0.10;
        }
    }

    static class PartTime implements Employee {
        private final String name;
        private final double salary;

        PartTime(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double calculateBonus() {
            return salary * 0.05;
        }
    }

    static class Intern implements Employee {
        private final String name;
        private final double salary;

        Intern(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double calculateBonus() {
            return 2000.0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, java.util.function.BiFunction<String, Double, Employee>>
                employeeTypes = new HashMap<>();

        employeeTypes.put("FULLTIME", FullTime::new);
        employeeTypes.put("PARTTIME", PartTime::new);
        employeeTypes.put("INTERN", Intern::new);

        int n = sc.nextInt();
        double totalBonus = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee =
                    employeeTypes.get(type).apply(name, salary);

            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n",
                    employee.getName(), bonus);

            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);
        sc.close();
    }
}

