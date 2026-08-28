public class GroupH_Business_Simulator {


    public static void main(String[] args) {


        // Arrays storing the product names
        String[] items = {"Phone", "Charger", "Earphones", "Power Bank"};


        // Arrays storing the product prices
        double[] prices = {450000, 15000, 20000, 60000};


        // Quantities the customer is buying
        int[] quantities = {1, 2, 3, 3};


        // Display the price list
        System.out.println("===== BYTE ELECTRONICS =====");


        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i] + " - UGX " + prices[i]);
        }
        // Array for storing final subtotals
double[] subtotals = new double[4];

// Array for showing whether a discount was applied
boolean[] discounted = new boolean[4];

// Calculate each item's subtotal
for (int i = 0; i < items.length; i++) {

    subtotals[i] = calculateSubtotal(i, prices[i], quantities[i]);

    discounted[i] = hasDiscount(i, quantities[i]);
}

// Calculate grand total
double grandTotal = 0;

for (int i = 0; i < subtotals.length; i++) {
    grandTotal = grandTotal + subtotals[i];
}

// Print receipt
printReceipt(items, quantities, subtotals, discounted, grandTotal);
}

// Method 1: Calculates the subtotal and applies discounts
public static double calculateSubtotal(int itemNumber,
                                       double price,
                                       int quantity) {

    double subtotal = price * quantity;

    // Phone
    if (itemNumber == 0 && quantity >= 2) {

        subtotal = subtotal - (subtotal * 0.05);
    }

    // Charger has no discount

    // Earphones
    else if (itemNumber == 2 && quantity >= 4) {

        subtotal = subtotal - 3000;
    }

    // Power Bank
    else if (itemNumber == 3 && quantity >= 3) {

        subtotal = subtotal - (subtotal * 0.10);
    }

    return subtotal;
}
}

