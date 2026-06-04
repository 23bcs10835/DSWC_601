package day2;
interface PaymentStrategy {
    boolean processPayment(double amount);
}

class CreditCardStrategy implements PaymentStrategy {

    public boolean processPayment(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount);
        return true;
    }
}

class CryptoStrategy implements PaymentStrategy {
    public boolean processPayment(double amount) {
        System.out.println("Processing Cryptocurrency payment of $" + amount);
        return true;
    }
}

class TransactionProcessor {

    private PaymentStrategy strategy;

    public TransactionProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeTransaction(double amount) {
        if (strategy != null) {
            boolean success = strategy.processPayment(amount);
            System.out.println("Transaction Status: " + (success ? "Success" : "Failed"));
        } else {
            System.out.println("No payment strategy selected.");
        }
    }
}

class Main {
    public static void main(String[] args) {

        TransactionProcessor processor =
                new TransactionProcessor(new CreditCardStrategy());

        processor.executeTransaction(1000.00);

        processor.setPaymentStrategy(new CryptoStrategy());

        processor.executeTransaction(5000.00);
    }
}
