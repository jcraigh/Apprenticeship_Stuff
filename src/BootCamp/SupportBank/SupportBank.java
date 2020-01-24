package BootCamp.SupportBank;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SupportBank {
    public static void main(String args[]) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/BootCamp/SupportBank/Transactions2014.csv"));

        ArrayList<Transaction> transactions = new ArrayList<>();
        ArrayList<Account> accounts = new ArrayList<>();

        for (int index = 1; index < lines.size(); index++) {
            String[] goo = lines.get(index).split(",");
            BigDecimal owe = new BigDecimal(goo[4]);

            Transaction transaction = new Transaction();
            transaction.nameFrom = goo[1];
            transaction.nameTo = goo[2];
            transaction.reason = goo[3];
            transaction.owed = owe;
            transactions.add(transaction);


        }

        for (Transaction transaction : transactions) {
            if (!accountExists(accounts, transaction.nameTo)) {
                Account account = new Account();
                account.name = transaction.nameTo;
                accounts.add(account);
            }

            if (!accountExists(accounts, transaction.nameFrom)) {
                Account account = new Account();
                account.name = transaction.nameFrom;
                accounts.add(account);
            }

            Account account = getAccount(accounts, transaction.nameTo);
            account.balance = account.balance.add(transaction.owed);

            Account fromAccount = getAccount(accounts, transaction.nameFrom);
            fromAccount.balance = fromAccount.balance.subtract(transaction.owed);


        }

    }

    private static boolean accountExists(ArrayList<Account> accounts, String accountName) {
        for (Account account : accounts) {
            if (account.name.equals(accountName)) {
                return true;

            }
        }
        return false;
    }

    private static Account getAccount(ArrayList<Account> accounts, String accountName) {
        for (Account account : accounts) {
            if (account.name.equals(accountName)) {
                return account;
            }
        }
        return null;
    }
}
