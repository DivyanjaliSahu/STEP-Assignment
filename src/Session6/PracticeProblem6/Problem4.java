package Session6.PracticeProblem6;

public class Problem4 {

    static class IdCard {
        String name;
        int booksIssued;

        // Constructor
        IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {

        // Create Ravi's library card
        IdCard ravi = new IdCard("Ravi", 0);

        // Both variables refer to the same object
        IdCard duplicate = ravi;

        // Change booksIssued through duplicate
        duplicate.booksIssued = 3;

        // Print the value through the first variable
        System.out.println(
                "Ravi's booksIssued (via first variable): "
                + ravi.booksIssued);

        // Check whether both variables refer to the same object
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        IdCard separate = new IdCard("Ravi", 3);

        System.out.println("separate == ravi: " + (separate == ravi));
    }
}

