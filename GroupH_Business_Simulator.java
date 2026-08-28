public class GroupH_Business_Simulator {

    static class Product {
        private final String name;
        private final double price;
        private final int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getDiscountAmount() {
            double subtotal = price * quantity;
            return calculateDiscount(subtotal, quantity, name);
        }

        public double getSubtotal() {
            double subtotal = price * quantity;
            return subtotal - calculateDiscount(subtotal, quantity, name);
        }

        public boolean hasDiscount() {
            return getDiscountAmount() > 0;
        }

        private static double calculateDiscount(double subtotal, int quantity, String productName) {
            if ("Phone".equalsIgnoreCase(productName) && quantity >= 2) {
                return subtotal * 0.05;
            }

            if ("Earphones".equalsIgnoreCase(productName) && quantity >= 4) {
                return 3000;
            }

            if ("Power Bank".equalsIgnoreCase(productName) && quantity >= 3) {
                return subtotal * 0.10;
            }

            return 0;
        }
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("Phone", 450000, 1),
            new Product("Charger", 15000, 2),
            new Product("Earphones", 20000, 3),
            new Product("Power Bank", 60000, 3)
        };

        System.out.println("===== BYTE ELECTRONICS =====");
        for (Product product : products) {
            System.out.println(product.getName() + " - UGX " + product.getPrice());
        }

        double grandTotal = 0;
        for (Product product : products) {
            grandTotal += product.getSubtotal();
        }

        printReceipt(products, grandTotal);
    }

    public static void printReceipt(Product[] products, double grandTotal) {
        System.out.println();
        System.out.println("========== RECEIPT ==========");

        for (Product product : products) {
            if (product.hasDiscount()) {
                System.out.println(product.getName() + " | Qty: " + product.getQuantity() + " | Subtotal: UGX " + product.getSubtotal() + " | Discount Applied");
            } else {
                System.out.println(product.getName() + " | Qty: " + product.getQuantity() + " | Subtotal: UGX " + product.getSubtotal() + " | No Discount");
            }
        }

        System.out.println("=============================");
        System.out.println("GRAND TOTAL: UGX " + grandTotal);
    }
}