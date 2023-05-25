import java.util.ArrayList;
import java.util.Objects;

public class Bank {
    static ArrayList<BankAccount> accountList; // hasmap gebruiken misschien?
    static double exchangeRate = 0.80;

    public Bank() {
        accountList = new ArrayList<>();
    }

    public void createAccount(String accountNumber, double startBalance) {
        for (BankAccount account : accountList) {
            if (Objects.equals(accountNumber, account.getAccountNumber())) {
                System.out.println("Error: account already exists");
                return;
            }
        }
        BankAccount newAccount = new BankAccount(accountNumber, startBalance);
        accountList.add(newAccount);
    }

    public BankAccount getAccount(String accountNumber) {
//        getAccount: neemt een rekeningnummer als parameter en geeft het bijbehorende BankAccount-object terug.
        for (BankAccount account : accountList) {
            if (Objects.equals(accountNumber, account.getAccountNumber())) {
                return account;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double depositAmount) {
//        deposit: neemt een rekeningnummer en een bedrag als parameters en stort dat bedrag op de bijbehorende rekening.
        for (BankAccount account : accountList) {
            if (Objects.equals(accountNumber, account.getAccountNumber())) {
                account.deposit(depositAmount);
                break;
            }
        }
    }

    public void withdraw(String accountNumber, double withdrawAmount) {
//        withdraw: neemt een rekeningnummer en een bedrag als parameters en neemt dat bedrag op van de bijbehorende rekening.
        for (BankAccount account : accountList) {
            if (Objects.equals(accountNumber, account.getAccountNumber())) {
                account.withdraw(withdrawAmount);
                break;
            }
        }
    }

    public void transaction(String sourceAccount, double amount, String targetAccount) {
//        Voeg een methode toe aan de Bank-klasse om een overboeking uit te voeren, waarbij je het bedrag en de bron- en doelrekeningen specificeert.
//        Roept de transaction methode van BankAccount twee keer, 1 keer voor de recipient en 1 keer voor de sender
        if (amount <= 0) {
            System.out.println("Transaction failed: negative number");
            return;
        }
        for (BankAccount account : accountList) {
            if (Objects.equals(sourceAccount, account.getAccountNumber())) {
                if (account.balance >= amount) {
                    account.transaction(false, amount, targetAccount);
                } else {
                    System.out.println("Transaction failed: insufficient funds");
                    return;
                }
                break;
            }
        }
        for (BankAccount account : accountList) {
            if (Objects.equals(targetAccount, account.getAccountNumber())) {
                account.transaction(true, amount, sourceAccount);
                break;
            }
        }
    }

    public void currencyExchange(String accountNumber) {
//        Je kunt een methode toevoegen aan de Bank-klasse waarmee je het saldo van een rekening in een andere valuta kunt weergeven.
//        Je kunt bijvoorbeeld een wisselkoersattribuut gebruiken om de conversie uit te voeren.
        for (BankAccount account : accountList) {
            if (Objects.equals(accountNumber, account.getAccountNumber())) {
                if (Objects.equals(account.currency, "currencyOne")) {
                    account.balance = account.getBalance() * exchangeRate;
                    account.currency = "currencyTwo";
                    System.out.println("The exchange rate is, and forever will be, 0.8");
                } else {
                    account.balance = account.getBalance() / exchangeRate;
                    account.currency = "currencyOne";
                    System.out.println("The exchange rate is, and forever will be, 0.8");
                }
                break;
            }
        }
    }
}

/*
Maak een Bank-klasse waarin je een lijst van BankAccount-objecten kunt bijhouden. Voeg de volgende methoden toe aan de Bank-klasse:

createAccount: neemt een rekeningnummer en een beginsaldo als parameters en maakt een nieuw BankAccount-object aan. Voeg dit object toe aan de lijst van rekeningen.
getAccount: neemt een rekeningnummer als parameter en geeft het bijbehorende BankAccount-object terug.
deposit: neemt een rekeningnummer en een bedrag als parameters en stort dat bedrag op de bijbehorende rekening.
withdraw: neemt een rekeningnummer en een bedrag als parameters en neemt dat bedrag op van de bijbehorende rekening.
Zorg ervoor dat je controleert of er voldoende saldo is voordat je een opname uitvoert.
*/