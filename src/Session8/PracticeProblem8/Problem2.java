
package Session8.PracticeProblem8;

import java.util.*;
import java.time.LocalDate;

public class Problem2 {
    interface LibraryItem {
        int loanDays();
    }

    static class Book implements LibraryItem {
        public int loanDays() {
            return 14;
        }
    }

    static class DVD implements LibraryItem {
        public int loanDays() {
            return 7;
        }
    }

    static class Magazine implements LibraryItem {
        public int loanDays() {
            return 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, LibraryItem> items = new HashMap<>();
        items.put("BOOK", new Book());
        items.put("DVD", new DVD());
        items.put("MAGAZINE", new Magazine());

        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LocalDate dueDate = currentDate.plusDays(
                items.get(type).loanDays()
            );

            System.out.println(title + ": " + dueDate);
        }

        sc.close();
    }
}


