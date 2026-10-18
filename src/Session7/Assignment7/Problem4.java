package Session7.Assignment7;

public class Problem4 {

    static class TrafficLight {
        private String color;
        private final String id;

        // Constructor
        public TrafficLight(String id) {
            this.id = id;
            this.color = "RED";
        }

        // Move to the next color
        public void next() {
            if (color.equals("RED")) {
                color = "GREEN";
            } else if (color.equals("GREEN")) {
                color = "YELLOW";
            } else {
                color = "RED";
            }
        }

        // Read-only access to color
        public String getColor() {
            return color;
        }

        public String getId() {
            return id;
        }
    }

    public static void main(String[] args) {

        TrafficLight t = new TrafficLight("TL-9");

        System.out.println("ID: " + t.getId());
        System.out.println("Color: " + t.getColor());

        t.next();
        System.out.println("Color: " + t.getColor());

        t.next();
        System.out.println("Color: " + t.getColor());

        t.next();
        System.out.println("Color: " + t.getColor());

        t.next();
        System.out.println("Color: " + t.getColor());
    }
}

