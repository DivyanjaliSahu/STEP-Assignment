package Session6.PracticeProblem6;

public class Problem5 {

    static class Student {
        String name;
        int attendance;

        static String collegeName =
                "SRM Institute of Science and Technology";

        static int studentCount = 0;

        // Constructor
        Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        // Static method
        static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {

        Student s1 = new Student("Ravi", 90);
        Student s2 = new Student("Anitha", 85);

        // Call the static method using the class name
        Student.printCollegeInfo();
    }
}

