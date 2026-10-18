
package Session8.PracticeProblem8;

import java.util.*;

public class Problem1 {
    interface Payment {
        double finalAmount(double amount);
    }

    static class Card implements Payment {
        public double finalAmount(double amount) {
            return amount * 1.02;
        }
    }

    static class Wallet implements Payment {
        public double finalAmount(double amount) {
            return amount * 1.01;
        }
    }

    static class BankTransfer implements Payment {
        public double finalAmount(double amount) {
            return amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Payment> methods = new HashMap<>();
        methods.put("CARD", new Card());
        methods.put("WALLET", new Wallet());
        methods.put("BANKTRANSFER", new BankTransfer());

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();
            double adjusted = methods.get(type).finalAmount(amount);

            System.out.printf("%s: %.2f%n", type, adjusted);
            total += adjusted;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
