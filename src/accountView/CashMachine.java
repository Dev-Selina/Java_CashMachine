package accountView;

import java.util.Scanner;

public class CashMachine {

    Scanner in = new Scanner(System.in);

    void login() {
        String user = "Lobster";
        int pin = 1900;

        System.out.println("User: ");
        String username = in.next();
        System.out.println("Pin: ");
        int pinNumber = in.nextInt();

        if (username.equals(user) && pinNumber == pin) {
            cashMachineMenu();
        }
    }

    void cashMachineMenu() {
        System.out.println("\nCASH MACHINE\n------------------\n1. Current Account\n2. Savings Account\n");
        int menuOption = in.nextInt();

        switch (menuOption) {
            case 1:
                currentAccount();
                break;
            case 2:
                System.out.println("Savings Account Info");
                break;
            default:
                System.out.println("Invalid option please try again.");
                cashMachineMenu();
        }
    }

    void currentAccount() {
        System.out.println("Current Account Info");
        System.out.println("\n------------------\n1. Check Balance\n2. Withdrawal\n3. Transfer\n4. Deposit\n");
        int option = in.nextInt();
        switch (option) {
            case 1:
                System.out.println("Current Account\nBalance: ");
                break;
            case 2:
                System.out.println("Current Account\nWithdrawal: ");
                break;
            case 3:
                System.out.println("Current Account\nTransfer: ");
                break;
            case 4:
                System.out.println("Current Account\nDeposit: ");
                break;
            default:
                System.out.println("Invalid option choice, please try again.");
                currentAccount();
        }
    }

    public static void main(String args[]) {
        CashMachine newCM = new CashMachine();
        newCM.login();

    }
}
