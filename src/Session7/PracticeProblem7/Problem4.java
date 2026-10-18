package Session7.PracticeProblem7;

public class Problem4 {

    static class Locker {
        private final int lockerNumber;
        private String combinationCode;

        public Locker(int lockerNumber, String combinationCode) {
            this.lockerNumber = lockerNumber;
            this.combinationCode = combinationCode;
        }

        public boolean changeCode(
                String currentCode, String newCode) {

            if (combinationCode.equals(currentCode)) {
                combinationCode = newCode;
                System.out.println("Code changed successfully.");
                return true;
            } else {
                System.out.println("Code change rejected.");
                return false;
            }
        }

        public int getLockerNumber() {
            return lockerNumber;
        }
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        System.out.println(
            "Locker number: " + l.getLockerNumber()
        );

        l.changeCode("1234", "5678");

        // Incorrect current code: this change is rejected.
        l.changeCode("0000", "9999");

        // There is intentionally no getter for the code.
    }
}

