import java.util.Scanner;

public class ATMMachine {

    private static double balance = 1000.0; // Initial balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    private static void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.printf("$%.2f has been deposited. Your new balance is: $%.2f%n", amount, balance);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.printf("$%.2f has been withdrawn. Your new balance is: $%.2f%n", amount, balance);
            } else {
                System.out.println("Insufficient funds. Please enter a smaller amount.");
            }
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }
}