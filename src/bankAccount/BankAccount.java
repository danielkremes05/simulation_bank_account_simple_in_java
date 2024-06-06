package bankAccount;

/*
*
    Atribute	    Type			Example
    Numero			Integer			1021
    Agency			Text			067-8
    Name Client 	Text			MARIO ANDRADE
    Balance			Decimal			237.48

     Result end expected
    "Hello [Name Client], thank you for creation an account at our bank, your brach is [Agency],
    Account [Numero], your currently [Balance]".
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankAccount {

    private String name = null;
    private int branchCode = 0;
    private int accountNumber = 0;
    private double initialBalance = 0.0;


    private final List<BankAccount> bankAccountList = new ArrayList<>();

    public BankAccount() {

    }

    public BankAccount(String name, int accountNumber, int branchCode, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.branchCode = branchCode;
        this.initialBalance = balance;
    }


    public void creationBankAccont() {

        boolean makeDeposit = false;

        String name;

        do {
            name = JOptionPane.showInputDialog("Enter the client name (letters and spaces only): ");
            if (!name.isEmpty() && !name.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(null, "Client name cannot contain numbers or symbols.");
            }
        } while (!name.isEmpty() && !name.matches("[a-zA-Z ]+"));

        try {
            accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter account number: "));
            branchCode = Integer.parseInt(JOptionPane.showInputDialog("Enter branch code: "));

            String depositAnswer = JOptionPane.showInputDialog("Do you want to make a deposit now (y/n)?");
            makeDeposit = depositAnswer.toLowerCase().equals("y");

            if (makeDeposit) {
                initialBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter initial deposit amount: "));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number entered. Please try again.");
            // You can choose to return here or prompt the user to re-enter the information

        }
        bankAccountList.add(new BankAccount(name, accountNumber, branchCode, initialBalance));
    }

    public void showClient() {
        for (BankAccount bankAccount : bankAccountList) {
            if (!(bankAccount.name == null || bankAccount.accountNumber == 0 || bankAccount.branchCode == 0)) {
                System.out.println("Hello : " + bankAccount.name + ", " +
                        "thank you for creating an account at our bank, your your branch is: " + bankAccount.branchCode +
                        ", account " + bankAccount.accountNumber + ", your currently balance is " + bankAccount.initialBalance);
            } else {
                String message = " " +
                        "Sorry " + bankAccount.name +
                        ",We don't creation your account: " +
                        "Please verify, " +
                        "Your number branch " + bankAccount.branchCode +
                        " or your numberAccount " + bankAccount.accountNumber;
                System.out.println(message);
            }
        }
    }

    /*In studie*/
//    public void showClient() {
//        Iterator<BankAccount> iterator = bankAccountList.iterator();
//        while (iterator.hasNext()) {
//            BankAccount bankAccount = iterator.next();
//            if (bankAccount.name == null || bankAccount.accountNumber == 0 || bankAccount.branchCode == 0) {
//                String message = "Sorry " + bankAccount.name +
//                        ", We don't create your account: " +
//                        "Please verify, " +
//                        "Your branch number " + bankAccount.branchCode +
//                        " or your account number " + bankAccount.accountNumber;
//                System.out.println(message);
//                iterator.remove(); // Remove the invalid account using the iterator
//                System.out.println(bankAccountList);
//            } else {
//                System.out.printf("Hello %s, thank you for creating an account at our bank, your branch is: %d, account %d, your current balance is %.2f\n",
//                        bankAccount.name, bankAccount.branchCode, bankAccount.accountNumber, bankAccount.initialBalance);
//            }
//        }
//    }


}
