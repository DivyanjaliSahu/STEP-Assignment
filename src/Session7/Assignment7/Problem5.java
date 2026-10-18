package Session7.Assignment7;

public class Problem5 {

    static class Cart {
        private double[] prices;
        private int itemCount;
        private final String cartId;

        // Constructor
        public Cart(String cartId, int maxItems) {
            this.cartId = cartId;
            prices = new double[maxItems];
            itemCount = 0;
        }

        // Add an item price
        public void addItem(double price) {
            if (price <= 0) {
                System.out.println("Invalid price.");
            } else if (itemCount >= prices.length) {
                System.out.println("Cart is full.");
            } else {
                prices[itemCount] = price;
                itemCount++;
            }
        }

        // Calculate total whenever requested
        public double getTotal() {
            double total = 0;

            for (int i = 0; i < itemCount; i++) {
                total += prices[i];
            }

            return total;
        }

        // Return number of items
        public int getItemCount() {
            return itemCount;
        }

        // Read-only access to cart ID
        public String getCartId() {
            return cartId;
        }
    }

    public static void main(String[] args) {

        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}

