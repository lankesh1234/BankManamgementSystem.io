package Bank;

import java.util.*;

class BankAcc {
    double balance;
    double prevTrans;
    String name;
    long id;

    BankAcc(String name, long id) {
        this.name = name;
        this.id = id;
    }

    void deposit(double amount) {
        if (amount != 0) {
            balance += amount;
        }
    }

    void withdraw(double amt) {
        if (amt != 0 && balance >= amt) {
            balance -= amt;
            prevTrans = -amt;
        } else if (balance < amt) {
            System.out.println("Opps : Insufficienr Bank Balance");
        }
    }

    void getprevTrans() {
        if (prevTrans > 0) {
            System.out.println("Deposited : " + prevTrans);
        } else if (prevTrans < 0) {
            System.out.println("Withdrawn : " + Math.abs(prevTrans));
        } else {
            System.out.println("Sorry : No Transcation Found");
        }
    }

    void menu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n**************************");
        System.out.println("\nWelcome Mr/Ms : " + name);
        System.out.println("Your Id : " + id);
        System.out.println();
        System.out.println("What can we do for you ? Please give command so we can help you according to your.\n");
        System.out.println("a] Check Balance");
        System.out.println("b] Deposit Amount");
        System.out.println("c] Withdraw Amount");
        System.out.println("d] Previous Transcation");
        System.out.println("e] Exit");

        do {
            System.out.println("\n***************************");
            System.out.println("Choose an Option : ");
            option = sc.next().charAt(0);
            System.out.println();

            switch (option) {
                case 'a':
                    System.out.println("Your Balance : " + balance);
                    System.out.println();
                    break;

                case 'b':
                    System.out.println("Enter Amount To Deposit : ");
                    double amt = sc.nextDouble();
                    deposit(amt);
                    System.out.println();
                    break;

                case 'c':
                    System.out.println("Enter Amount To Withdraw : ");
                    double amtW = sc.nextDouble();
                    withdraw(amtW);
                    System.out.println();
                    break;

                case 'd':
                    System.out.println("Previous Transcation : ");
                    getprevTrans();
                    System.out.println();
                    break;

                case 'e':
                    System.out.println("***************************");
                    break;

                default:
                    System.out.println("You have entered Invalid Input");
                    System.out.println("Please Choose an Correct Option To Proceed");
                    break;
            }
        } while (option != 'e');

        System.out.println("Thank You For Using Bank Service");
        System.out.println("We are happy to help you. Anytime, Anywhere.");
    }
}

public class bankinfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer Name : ");
        String name = sc.nextLine();
        System.out.println("Enter Customer ID  : ");
        long id = sc.nextInt();
        BankAcc b = new BankAcc(name, id);
        b.menu();

    }
}

