package Assignment1;
import java.util.Scanner;
public class TrafficSignal {
      public static void main(String[] args) {
    	  Scanner sc = new Scanner(System.in);
    	  System.out.print("Enter signal: ");
          String s = sc.nextLine();
          int count = 1;
          int max = 1;
          char result = s.charAt(0);

          for (int i = 1; i < s.length(); i++) {
              if (s.charAt(i) == s.charAt(i - 1)) {
                  count++;
              } else {
                  count = 1;  }
              if (count > max) {
                  max = count;
                  result = s.charAt(i);
              }
          }
          System.out.println(result + " repeated " + max + " times");
	}
}
