package Assignment4;
import java.util.HashMap;
public class ArraySum {

	public static void main(String[] args) {
		 int[] a = {1, 1, 1};
	        int k = 2;

	        HashMap<Integer, Integer> map = new HashMap<>();

	        map.put(0, 1);

	        int sum = 0;
	        int count = 0;

	        for (int i = 0; i < a.length; i++) {

	            sum = sum + a[i];

	            if (map.containsKey(sum - k)) {
	                count = count + map.get(sum - k);
	            }

	            map.put(sum, map.getOrDefault(sum, 0) + 1);
	        }

	        System.out.println("Count: " + count);

	}

}
