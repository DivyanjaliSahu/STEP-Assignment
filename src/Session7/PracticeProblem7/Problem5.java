package Session7.PracticeProblem7;

public class Problem5 {

    static class AttendanceSheet {
        private final String[] presentStudents;
        private int presentCount;

        public AttendanceSheet(int capacity) {
            if (capacity < 0) {
                throw new IllegalArgumentException(
                    "Capacity cannot be negative."
                );
            }

            presentStudents = new String[capacity];
            presentCount = 0;
        }

        public void markPresent(String name) {
            // Do not count a student twice.
            if (isPresent(name)) {
                System.out.println(name + " is already marked present.");
                return;
            }

            // Do not exceed the fixed capacity.
            if (presentCount >= presentStudents.length) {
                System.out.println("Attendance sheet is full.");
                return;
            }

            presentStudents[presentCount] = name;
            presentCount++;
        }

        public int getPresentCount() {
            return presentCount;
        }

        public boolean isPresent(String name) {
            for (int i = 0; i < presentCount; i++) {
                if (presentStudents[i].equals(name)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println(
            "Present count: " + sheet.getPresentCount()
        );

        System.out.println(
            "Is Ben present? " + sheet.isPresent("Ben")
        );

        System.out.println(
            "Is Chen present? " + sheet.isPresent("Chen")
        );
    }
}

    
    
