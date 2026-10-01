package ui;

public class ResidentPaymentData {

    private static final double TOTAL_FEE = 10000.00;

    private static double amountPaid = 8000.00;

    public static double getTotalFee() {
        return TOTAL_FEE;
    }

    public static double getAmountPaid() {
        return amountPaid;
    }

    public static double getRemainingAmount() {

        double remaining = TOTAL_FEE - amountPaid;

        if (remaining < 0) {
            return 0;
        }

        return remaining;
    }

    public static void addPayment(double amount) {

        if (amount <= 0) {
            return;
        }

        amountPaid += amount;

        if (amountPaid > TOTAL_FEE) {
            amountPaid = TOTAL_FEE;
        }
    }

    public static String getPaymentStatus() {

        if (getRemainingAmount() <= 0) {
            return "PAID";
        }

        if (amountPaid <= 0) {
            return "PENDING";
        }

        return "PARTIAL";
    }

    public static void resetPayment() {
        amountPaid = 8000.00;
    }
}