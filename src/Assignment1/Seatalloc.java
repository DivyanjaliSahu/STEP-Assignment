package Assignment1;
import java.util.Scanner;
public class Seatalloc {
      public static void main(String[] args) {
    	  Scanner sc = new Scanner(System.in);
          System.out.print("Enter number of seats: ");
          int n = sc.nextInt();
          int[] seats = new int[n];
          System.out.println("Enter seat numbers:");
          for (int i = 0; i < n; i++) {
              seats[i] = sc.nextInt();}

          boolean found = false;

          for (int i = 0; i < n; i++) {

              for (int j = i + 1; j < n; j++) {

                  if (seats[i] == seats[j]) {
                      System.out.println("Duplicate Seat Number: " + seats[i]);
                      found = true;
                  }
                }
            }
          if (found == false) {
              System.out.println("No Duplicate Seats Found");
          }

	}
  }
