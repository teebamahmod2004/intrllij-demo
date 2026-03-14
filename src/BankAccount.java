import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    int accountNumber;
    String name;
    double balance;
     double deposit;
    BankAccount(int accountNumber,String name,double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }
    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }
    void  withdraw(double amount) throws  Exception{
        if(amount>balance) {
            throw new Exception("NOT ENOUGH BALANCE:");
        }
        balance=amount;
        System.out.println("withdrow sucessful.new balance:"+balance);
        }
        void  showBalance() {
            System.out.println("current blance:" + balance);
        }

    }



