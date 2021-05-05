package BsnkAccount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String operation = tokens[0];
            switch (operation) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    int addId = bankAccount.getId();
                    bankAccounts.put(addId, bankAccount);
                    System.out.printf("Account ID%d created%n", addId);
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);

                    if (!bankAccounts.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        bankAccounts.get(id).deposit(amount);
                        System.out.printf("Deposited %d to ID%d%n", amount, id);
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int getID = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (!bankAccounts.containsKey(getID)) {
                        System.out.println("Account does not exist");
                    } else {
                        double getInterest = bankAccounts.get(getID).getInterestRate(years);
                        System.out.printf("%.2f", getInterest);
                        break;
                    }
            }
                    input = scanner.nextLine();
        }
    }}
