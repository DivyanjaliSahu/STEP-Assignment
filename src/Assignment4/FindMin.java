package Assignment4;

public class FindMin {
	 public static void main(String[] args) {

	        int[] a = {3, 4, 5, 1, 2};

	        int left = 0;
	        int right = a.length - 1;

	        while (left < right) {

	            int mid = (left + right) / 2;

	            if (a[mid] > a[right]) {
	                left = mid + 1;
	            }
	            else {
	                right = mid;
	            }
	        }

	        System.out.println("Minimum: " + a[left]);
    }
  }