package accountView;

import java.util.Scanner;

public class CashMachine {

    Scanner in = new Scanner(System.in);
    String user = "Lobster";
    int pin = 1900;
    int numberOfPinAttempts, numberOfUsernameAttempts;

    void login() {
        System.out.println("User: ");
        String username = in.next();
        checkUsernameIsCorrect(username);
        pinIsEntered(username);
    }

    private int pinIsEntered(String username) {
        System.out.println("Pin: ");
        int pinNumber = in.nextInt();
        checkUserPinIsCorrect(pinNumber, username);
        return pinNumber;
    }


    String checkUsernameIsCorrect(String username) {

        if (!username.equals(user)) {
            numberOfUsernameAttempts = numberOfUsernameAttempts + 1;
            if (numberOfUsernameAttempts <= 2) {
                System.out.println("Try no: " + numberOfUsernameAttempts + "\nIncorrect username.\nPlease re-enter again.\n");
                login();
            } else {
                System.out.println("Try no: " + numberOfUsernameAttempts + "\nToo many failed attempts on entering username.");
                System.exit(0);
            }
        }
        return username;
    }

    void checkUserPinIsCorrect(int pinNumber, String username) {
        numberOfPinAttempts = numberOfPinAttempts + 1;

        if (numberOfPinAttempts <= 3) {
            //check complete
            System.out.println("checking...\nAttempt no: " + numberOfPinAttempts);
            checkUsernameIsCorrect(username);
        } else {
            System.out.println("Too many attempts failed.");
            System.exit(0);
        }

        if (pinNumber != pin) {
            System.out.println("Pin number does not match.\n");
        } else if (username.equals(user) && pinNumber == pin) {
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
                checkBalance();
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

    void checkBalance() {
        System.out.println("Current Account\nBalance: ");

    }

    public static void main(String args[]) {
        CashMachine newCM = new CashMachine();
        newCM.login();

    }
}
