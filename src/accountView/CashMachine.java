package accountView;

import java.util.Scanner;

public class CashMachine {

    Scanner in = new Scanner(System.in);
    String user = "Lobster";
    int pin = 1900;
    int userBalance = 2000;
    int numberOfPinAttempts, numberOfUsernameAttempts;

    private void login() {
        userIsEntered();
        pinIsEntered();
    }

    private String userIsEntered() {
        System.out.println("User: ");
        String username = in.next();
        checkUsernameIsCorrect(username);
        return username;
    }

    private int pinIsEntered() {
        System.out.println("Pin: ");
        int pinNumber = in.nextInt();
        checkPinIsCorrect(pinNumber);
        return pinNumber;
    }

    private String checkUsernameIsCorrect(String username) {

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

    private void checkPinIsCorrect(int pinNumber) {
        if (pinNumber == pin) {
            cashMachineMenu();
        } else {
            numberOfPinAttempts = numberOfPinAttempts + 1;
            if (numberOfPinAttempts <= 2) {
                System.out.println("checking...\nAttempt no: " + numberOfPinAttempts);
                pinIsEntered();
            } else {
                System.out.println("Attempt no: " + numberOfPinAttempts + "\nToo many attempts failed.");
                System.exit(0);
            }
//
//        if (pinNumber != pin) {
//            System.out.println("Pin number does not match.\n");
//        } else if (username.equals(user) && pinNumber == pin) {
//            cashMachineMenu();
//        }
        }
    }

    private void cashMachineMenu() {
        System.out.println("\nCASH MACHINE\n------------------\n1. Current Account\n2. Savings Account\nEnter option: ");
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


    private void currentAccount() {
        System.out.println("Current Account Info\n");
        System.out.println("\n------------------\n1. Check Balance\n2. Withdrawal\n3. Transfer\n4. Deposit\n");
        int option = in.nextInt();
        switch (option) {
            case 1:
                checkBalance(userBalance);
                break;
            case 2:
                withdraw(userBalance);
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

    private int withdraw(int userBalance) {
        System.out.println("Current Account\n------------------\nWithdraw: £");
        int withdrawalAmount = in.nextInt();
        int newBalance = 0;
        if (userBalance >= withdrawalAmount) {
            //withdraw money from selected account
            newBalance = userBalance - withdrawalAmount;
            userBalance = newBalance;
            System.out.println(userBalance + "\nDo you want to perform another transaction?\nYes\nNo");
            doAnotherAccountAction();
        } else {
            System.out.println("Not enough monies available.");
            System.exit(0);
        }
        return userBalance;
    }

    private void checkBalance(int userBalance) {
        System.out.println("Current Account\n------------------\nBalance: £" + userBalance + "\nDo you want to perform another transaction?\nYes\nNo");
        doAnotherAccountAction();
    }

    private void doAnotherAccountAction() {
        String option = in.next();
        if (option.contains("Y")) {
            currentAccount();
        } else {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        CashMachine newCM = new CashMachine();
        newCM.login();

    }
}
