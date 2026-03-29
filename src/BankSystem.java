import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BankSystem implements ActionListener {


    JFrame loginFrame;
    JTextField userField;
    JPasswordField passField;
    JButton loginBtn;

    JFrame mainFrame;
    JTextField amountField;
    JButton depositBtn, withdrawBtn, balanceBtn;

    ArrayList<BankAccount> accounts = new ArrayList<>();
    BankAccount current;

    BankSystem() {
        current = new BankAccount(1, "User", 1000);
        accounts.add(current);


        loginFrame = new JFrame("Login Page");

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30,50,100,30);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30,100,100,30);

        userField = new JTextField();
        userField.setBounds(130,50,150,30);

        passField = new JPasswordField();
        passField.setBounds(130,100,150,30);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(100,160,100,30);

        loginBtn.addActionListener(this);

        loginFrame.add(userLabel);
        loginFrame.add(passLabel);
        loginFrame.add(userField);
        loginFrame.add(passField);
        loginFrame.add(loginBtn);

        loginFrame.setSize(350,250);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);

        loginFrame.setSize(300, 300);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);
    }

    void openMain() {
        mainFrame = new JFrame("Bank System");

        amountField = new JTextField();
        amountField.setBounds(50, 50, 150, 30);

        depositBtn = new JButton("Deposit");
        depositBtn.setBounds(50, 100, 100, 30);

        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(50, 150, 100, 30);

        balanceBtn = new JButton("Balance");
        balanceBtn.setBounds(50, 200, 100, 30);

        depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        balanceBtn.addActionListener(this);

        mainFrame.add(amountField);
        mainFrame.add(depositBtn);
        mainFrame.add(withdrawBtn);
        mainFrame.add(balanceBtn);

        mainFrame.setSize(300, 300);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == loginBtn) {
            String user = userField.getText();
            String pass = passField.getText();

            if (user.equals("admin") && pass.equals("123")) {
                loginFrame.setVisible(false);
                openMain();
            } else {
                JOptionPane.showMessageDialog(null, "Wrong login");
            }
        }


        try {
            double amount = Double.parseDouble(amountField.getText());

            if (e.getSource() == depositBtn) {
                current.deposit(amount);
                JOptionPane.showMessageDialog(null, "Deposited");
            } else if (e.getSource() == withdrawBtn) {
                current.withdraw(amount);
                JOptionPane.showMessageDialog(null, "Withdrawn");
            } else if (e.getSource() == balanceBtn) {
                JOptionPane.showMessageDialog(null,
                        "Balance = " + current.getBalance());
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Enter valid number");
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
