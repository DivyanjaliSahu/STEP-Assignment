package PracticeProblem4;

public class Stock {

	public static void main(String[] args) {
		 int[] price = {7, 1, 5, 3, 6, 4};

	        int min = price[0];
	        int profit = 0;

	        for (int i = 1; i < price.length; i++) {

	            if (price[i] < min) {
	                min = price[i];
	            }

	            int p = price[i] - min;

	            if (p > profit) {
	                profit = p;
	            }
	        }

	        System.out.println("Maximum Profit: " + profit);

	}

}
