
package Session6.Assignment6;

public class Problem5 {

    static class Employee {
        String empName;
        double salary;

        static String companyName = "BridgeLabz";
        static int employeeCount = 0;

        Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println("Company Name: " + companyName);
            System.out.println("Total Employees: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Divya", 30000);
        Employee e2 = new Employee("Arjun", 35000);
        Employee e3 = new Employee("Priya", 40000);

        Employee.printCompanyInfo();
    }
}


