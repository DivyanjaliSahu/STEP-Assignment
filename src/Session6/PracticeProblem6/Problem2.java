package Session6.PracticeProblem6;

public class Problem2 {

    static class MessWallet {
        private double balance;

        // Constructor
        public MessWallet(double balance) {
            if (balance < 0) {
                System.out.println("Warning: Negative opening balance. Starting at 0.");
                this.balance = 0;
            } else {
                this.balance = balance;
            }
        }

        // Add money to wallet
        public void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up rejected: Amount must be positive.");
            } else {
                balance += amount;
            }
        }

        // Deduct money from wallet
        public void deduct(double amount) {
            if (amount <= 0) {
                System.out.println("Deduction rejected: Amount must be positive.");
            } else if (amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
            } else {
                balance -= amount;
            }
        }

        // Read-only access to balance
        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);

        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance());

        wallet.deduct(1000);

        System.out.println("Final balance: " + wallet.getBalance());
    }
}
