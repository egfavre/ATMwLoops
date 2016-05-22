package com.egfavre;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Set up utilities
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> accounts;

        //Declare variables
        String name;
        String openNewAccount;
        Double deposit;
        Integer transaction;
        Double balance;
        Double withdraw;
        Double newBalance;
        boolean run = true;


        //Instantiate Class Objects
        accounts = new HashMap<>();
        deposit = new Double(0.0);
        transaction = new Integer(0);
        balance = new Double(0.0);
        withdraw = new Double(0.0);
        newBalance = new Double(0.0);

        //create HashMap enteries
        accounts.put("Abigail", 575.12);
        accounts.put("Isabel", 12873.93);
        accounts.put("Doug", 25.32);

        while (run == true) {
            //Collect name
            System.out.println("Welcome.");
            System.out.println("Please enter your name.");
            name = scanner.nextLine();

            //name in Hashmap?
            while (accounts.containsKey(name) == false) {
                System.out.println("No account with that name exists.  Would you like to open a new account? [Y/N]");
                openNewAccount = scanner.nextLine();

                if (openNewAccount.equalsIgnoreCase("y")) {
                    System.out.println("What amount would you like to deposit today?");
                    deposit = scanner.nextDouble();

                    accounts.put(name, deposit);
                } else {
                    System.out.println("You have chosen not to open a new account.");
                    accounts.put(name, null);
                    transaction = 3;
                }
            }

            //select transaction
            while (transaction != 3 && transaction != 4) {
                System.out.println("Please enter the number of the transaction you wish to perform.");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw Funds");
                System.out.println("3.Close Account");
                System.out.println("4. Cancel");

                transaction = scanner.nextInt();

                if (transaction != 1 && transaction != 2 && transaction != 3) {
                    transaction = 4;
                }

                //set transaction cases
                switch (transaction) {
                    case 1:
                        balance = accounts.get(name);
                        System.out.println("Your balance is $" + balance);
                        break;
                    case 2:
                        balance = accounts.get(name);
                        System.out.println("What amount would you like to withdraw? [example 200.00");
                        withdraw = scanner.nextDouble();

                        while (withdraw > balance) {
                            System.out.println("That amount exceeds your balance.");
                            System.out.println("Your current balance is $" + balance);

                            System.out.println("What amount would you like to withdraw? [example 200.00");
                            withdraw = scanner.nextDouble();
                        }

                        newBalance = balance - withdraw;
                        accounts.replace(name, balance, newBalance);
                        balance = accounts.get(name);

                        System.out.println("You may take your money.");
                        System.out.println("Your new balance is $" + balance);
                        break;
                    case 3:
                        System.out.println("Your balance was $" + balance);
                        System.out.println("You may take your money now.");
                        System.out.println("No account in your name remains.");

                        accounts.remove(name);
                        transaction = 4;
                        break;
                    case 4:
                        System.out.println("Thank you and come again.");
                        name = "";
                        break;
                }
            }
        }
    }

}

