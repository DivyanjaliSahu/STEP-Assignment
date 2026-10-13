package PracticeProblem2;
import java.util.Scanner;
public class PhoneMask {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter phone number: ");
	        String phone = sc.nextLine();

	        if (phone.length() != 10) {
	            System.out.println("Invalid phone number");
	        }
	        else {

	            boolean valid = true;

	            for (int i = 0; i < phone.length(); i++) {

	                if (!Character.isDigit(phone.charAt(i))) {
	                    valid = false;
	                }
	            }

	            if (valid) {

	                String last4 = phone.substring(6);

	                StringBuilder result = new StringBuilder("XXXXXX");
	                result.append("-");
	                result.append(last4);
	                System.out.println(result);
	            }
	            else {
	                System.out.println("Invalid phone number");
	            }
	        }

	}

}
