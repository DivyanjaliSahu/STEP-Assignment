package PracticeProblem2;
import java.util.Scanner;
public class StudentRecord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter record: ");
        String data = sc.nextLine();

        String[] a = data.split(",");

        if (a.length != 3) {
            System.out.println("Invalid Record");
        }
        else {
            System.out.println("Name: " + a[0]);
            System.out.println("Roll No: " + a[1]);
            System.out.println("Dept: " + a[2]);
        }
    }
}

	
