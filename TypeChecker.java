package Assignment1;
import java.util.Scanner;
public class TypeChecker {
      public static void main(String[] args) {
    	  Scanner sc = new Scanner(System.in);
          System.out.print("Original: ");
          String a = sc.nextLine();

          System.out.print("Typed: ");
          String b = sc.nextLine();

          int count = 0;

          for (int i = 0; i < a.length(); i++) {
              if (a.charAt(i) == b.charAt(i)) {
                  count++;
              }
          }

          double accuracy = count * 100.0 / a.length();

          System.out.println("Matched: " + count);
          System.out.println("Accuracy: " + accuracy + "%");
	}

}
