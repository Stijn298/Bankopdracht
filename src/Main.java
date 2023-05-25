public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();

        // Nieuwe rekeningen aanmaken

        bank.createAccount("NL01ABCD1234567890", 1000.0);

        bank.createAccount("NL02EFGH1234567890", 500.0);

        // Geld storten

        bank.deposit("NL01ABCD1234567890", 250.0);

        // Geld opnemen

        bank.withdraw("NL02EFGH1234567890", 200.0);

        // Saldo controleren

        System.out.println(bank.getAccount("NL01ABCD1234567890").getBalance());
        System.out.println(bank.getAccount("NL02EFGH1234567890").getBalance());

        // Withdraw controleren

        bank.withdraw("NL02EFGH1234567890", 900.0);
        System.out.println(bank.getAccount("NL02EFGH1234567890").getBalance());
        System.out.println(bank.getAccount("NL02EFGH1234567890"));

        // Transaction controleren

        bank.transaction("NL01ABCD1234567890", 50, "NL02EFGH1234567890");
        System.out.println(bank.getAccount("NL01ABCD1234567890").getBalance());
        System.out.println(bank.getAccount("NL02EFGH1234567890").getBalance());

        // Exchange controleren

        bank.currencyExchange("NL01ABCD1234567890");
        System.out.println(bank.getAccount("NL01ABCD1234567890"));
        bank.currencyExchange("NL01ABCD1234567890");
        System.out.println(bank.getAccount("NL01ABCD1234567890"));

        // Log controleren

        System.out.println("Printing log");
        bank.getAccount("NL01ABCD1234567890").printLog();
        System.out.println("Printing second log");
        bank.getAccount("NL02EFGH1234567890").printLog();

    }
}

/*
Als je hiermee klaar bent denk dan aan extra functies, bijvoorbeeld:

Overboekingen tussen rekeningen: Breid de functionaliteit uit zodat gebruikers geld kunnen overboeken tussen verschillende bankrekeningen.
Voeg een methode toe aan de Bank-klasse om een overboeking uit te voeren, waarbij je het bedrag en de bron- en doelrekeningen specificeert.

Valutawissel: Implementeer een functie waarmee je valutawissel kunt simuleren.
Je kunt een methode toevoegen aan de Bank-klasse waarmee je het saldo van een rekening in een andere valuta kunt weergeven.
Je kunt bijvoorbeeld een wisselkoersattribuut gebruiken om de conversie uit te voeren.

Transactiegeschiedenis: Implementeer een functionaliteit waarmee je de transactiegeschiedenis van een bankrekening kunt bijhouden.
Je kunt bijvoorbeeld een lijst of een logboek van transacties maken waarin elke storting of opname wordt geregistreerd.
Voeg vervolgens een methode toe aan de BankAccount-klasse om de transactiegeschiedenis op te vragen en te tonen.

Wees creatief, en bedenk zelf handige functies die je mist
*/