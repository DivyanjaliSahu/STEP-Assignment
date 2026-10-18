
package Session9.Assignment9;

import java.util.*;

public class Problem2 {

    interface Insurable {
        double calculateInsurance(double declaredValue);
    }

    static abstract class Parcel {
        protected double weight;

        Parcel(double weight) {
            this.weight = weight;
        }

        abstract double calculateCharge();

        public double calculateInsurance(double value) {
            return 0;
        }

        public double calculateTotal(double value) {
            return calculateCharge() + calculateInsurance(value);
        }
    }

    static class Standard extends Parcel {
        Standard(double weight) {
            super(weight);
        }

        double calculateCharge() {
            return 40 + 10 * weight;
        }
    }

    static class Express extends Parcel implements Insurable {
        Express(double weight) {
            super(weight);
        }

        double calculateCharge() {
            return 80 + 15 * weight;
        }

        public double calculateInsurance(double value) {
            return value * 0.02;
        }
    }

    static class Fragile extends Parcel implements Insurable {
        Fragile(double weight) {
            super(weight);
        }

        double calculateCharge() {
            return 40 + 10 * weight + 50;
        }

        public double calculateInsurance(double value) {
            return value * 0.02;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new Standard(weight);
                    break;
                case "EXPRESS":
                    parcel = new Express(weight);
                    break;
                case "FRAGILE":
                    parcel = new Fragile(weight);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown parcel type");
            }

            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance(value);
            double total = parcel.calculateTotal(value);

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}

