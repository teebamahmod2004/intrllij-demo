
import  java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        System.out.print("Enter account number: ");
        int num = input.nextInt();
        input.nextLine();

        System.out.print("Enter name: ");
        String name = input.nextLine();

        System.out.print("Enter initial balance: ");
        double bal = input.nextDouble();

        BankAccount acc = new BankAccount(num, name, bal);
        accounts.add(acc);

        int choice;

        do {
            System.out.println("\n1- Deposit");
            System.out.println("2- Withdraw");
            System.out.println("3- Show Balance");
            System.out.println("4- Exit");

            choice = input.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double d = input.nextDouble();
                        acc.deposit(d);
                        break;

                    case 2:
                        System.out.print("Enter withdraw amount: ");
                        double w = input.nextDouble();
                        acc.withdraw(w);
                        break;

                    case 3:
                        acc.showBalance();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (choice != 4);
    }
}