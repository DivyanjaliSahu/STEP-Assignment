package PracticeProblem4;

public class Duplicate {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 1};

        boolean found = false;

        for (int i = 0; i < a.length; i++) {

            for (int j = i + 1; j < a.length; j++) {

                if (a[i] == a[j]) {
                    found = true;
                }
            }
        }

        System.out.println(found);

	}

}
