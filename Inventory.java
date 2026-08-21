package Assignment1;
import java.util.Scanner;
public class Inventory {
     public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
    	 int[] a = new int[3];
         int[] b = new int[3];

         System.out.println("Enter Section A:");
         for (int i = 0; i < 3; i++) {
             a[i] = sc.nextInt();
         }

         System.out.println("Enter Section B:");
         for (int i = 0; i < 3; i++) {
             b[i] = sc.nextInt();
         }

         int sumA = 0;
         int sumB = 0;

         for (int i = 0; i < 3; i++) {
             sumA = sumA + a[i];
             sumB = sumB + b[i];
         }

         System.out.println("Section A Total: " + sumA);
         System.out.println("Section B Total: " + sumB);
         if (sumA == sumB)
             System.out.println("Balanced");
         else
             System.out.println("Not Balanced");

         int max = a[0];

         for (int i = 0; i < 3; i++) {
             if (a[i] > max)
                 max = a[i];

             if (b[i] > max)
                 max = b[i];
         }

         System.out.println("Highest Quantity: " + max);
     }
}
         
