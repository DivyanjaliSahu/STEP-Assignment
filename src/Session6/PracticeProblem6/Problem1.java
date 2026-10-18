package Session6.PracticeProblem6;

public class Problem1 {
    
    static class PlacementRecord {
        String studentName;
        String company;
        double packageLpa;

        // Constructor
        PlacementRecord(String studentName, String company, double packageLpa) {
            this.studentName = studentName;
            this.company = company;
            this.packageLpa = packageLpa;
        }

        // Print student placement details
        void printRecord() {
            System.out.println(studentName + " -> " + company
                    + " @ " + packageLpa + " LPA");
        }
    }

    public static void main(String[] args) {

        PlacementRecord[] records = {
            new PlacementRecord("Ravi", "TCS", 4.5),
            new PlacementRecord("Anitha", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        // Print each placement record
        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}
