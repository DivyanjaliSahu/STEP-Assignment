package PracticeProblem2;
import java.util.Scanner;
public class FileValidator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String file = sc.nextLine();

        int dot = file.lastIndexOf(".");

        if (dot == -1) {
            System.out.println("Rejected - invalid file type");
        }
        else {

            String extension = file.substring(dot + 1);

            if (extension.equalsIgnoreCase("pdf") ||
                extension.equalsIgnoreCase("docx") ||
                extension.equalsIgnoreCase("zip")) {

                System.out.println("Accepted");
            }
            else {
                System.out.println("Rejected - invalid file type");
            }

	}
	}
}
