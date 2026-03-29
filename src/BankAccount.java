public class BankAccount {
        int accNo;
        String name;
        double balance;

        BankAccount(int accNo, String name, double balance){
            this.accNo = accNo;
            this.name = name;
            this.balance = balance;
        }

        void deposit(double amount){
            balance += amount;
        }

        void withdraw(double amount){
            if(amount <= balance){
                balance -= amount;
            } else {
                throw new ArithmeticException("Not enough balance");
            }
        }

        double getBalance(){
            return balance;
        }
    }

