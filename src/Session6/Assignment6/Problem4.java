package Session6.Assignment6;

public class Problem4 {

    static class HallTicket {
        String studentName;
        int seatNumber;

        HallTicket(String studentName, int seatNumber) {
            this.studentName = studentName;
            this.seatNumber = seatNumber;
        }
    }

    public static void main(String[] args) {

        HallTicket priya = new HallTicket("Priya", 0);

        // Both variables refer to the same object
        HallTicket copy = priya;

        // Change the seat number using copy
        copy.seatNumber = 45;

        System.out.println("Priya's seatNumber (via first variable):");
        System.out.println(priya.seatNumber);

        System.out.println("copy == priya: " + (copy == priya));

        // Create a separate object with the same details
        HallTicket separate = new HallTicket("Priya", 45);

        System.out.println("separate == priya: " + (separate == priya));
    }
}
