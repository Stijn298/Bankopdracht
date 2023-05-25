import java.util.ArrayList;
public class BankAccount {
    String accountNumber, currency;
    double balance;
    static ArrayList <String> log;


    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = "currencyOne";
        log = new ArrayList<>();
    }

    public String getAccountNumber() {
//        getAccountNumber: geeft het rekeningnummer terug.
        return accountNumber;
    }

    public double getBalance() {
//        getBalance: geeft het saldo van de rekening terug.
        return balance;
    }

    public void deposit(double depositeAmount) {
//        deposit: neemt een bedrag als parameter en stort dat op de rekening.
        if (depositeAmount > 0) {
            balance = balance + depositeAmount;
            log.add("deposit " + depositeAmount);
        }
        else{
            System.out.println("Transaction failed: invalid deposit amount");
        }
    }

    public void withdraw(double withdrawAmount) {
//        withdraw: neemt een bedrag als parameter en neemt dat bedrag op van de rekening. Zorg ervoor dat je controleert of er voldoende saldo is voordat je een opname uitvoert.
        if ((balance - withdrawAmount) > 0) {
            balance = balance - withdrawAmount;
            log.add("withdraw " + withdrawAmount);
        }
        else{
            System.out.println("Transaction failed: insufficient balance");
        }
    }

    public String toString() {
//        toString: geeft een representatie van het bankrekeningobject als een string terug.
//        System.out.println("Accountnumber: " + accountNumber + "/nBalance: " + balance);
        return("Accountnumber: " + accountNumber + ". Balance: " + balance + ". Currency: " + currency);
    }

    public void printLog() {
        for (String entry : log) {
            System.out.println(entry);
        }
    }
}

/*
Maak een klasse genaamd BankAccount met de volgende attributen:

accountNumber (een String die het rekeningnummer vertegenwoordigt)
balance (een double die het saldo van de rekening voorstelt)

Voeg de volgende methoden toe aan de BankAccount-klasse:

getAccountNumber: geeft het rekeningnummer terug.
getBalance: geeft het saldo van de rekening terug.
deposit: neemt een bedrag als parameter en stort dat op de rekening.
withdraw: neemt een bedrag als parameter en neemt dat bedrag op van de rekening. Zorg ervoor dat je controleert of er voldoende saldo is voordat je een opname uitvoert.
toString: geeft een representatie van het bankrekeningobject als een string terug.
*/