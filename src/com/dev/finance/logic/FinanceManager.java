package com.dev.finance.logic;

import java.util.*;
import java.io.*;
import com.dev.finance.models.*;

public class FinanceManager
{
    ArrayList<Transaction> transactions = new ArrayList<>();

    // used for path where the transaction file is stored
    private final String path = "data/transaction.csv";

    // to add transaction: Income or Expense objects
    public void addTransactions(Transaction t) {transactions.add(t);}

    // to calculate the total balance you have
    public double calculateBalance()
    {
        double total = 0.0;

        for (Transaction t: transactions)
        {
            if (t instanceof Income) {total += t.getAmount();}
            else if (t instanceof Expense) {total -= t.getAmount();}
        }
        return total;
    }

    // to view the history of your expense or source of income
    public void viewHistory()
    {   
    
        if (transactions.isEmpty()) {System.out.println("There's no records found."); return;}

        for (Transaction t: transactions)
        {
            if (t instanceof Income) {t.displayDetails();}
            else if (t instanceof Expense) {t.displayDetails();}
        }
    }

    // want to filter the transaction per what type of Source of Income or Expense it is
    public void filterByCategory(String category)
    {
        for (Transaction t: transactions)
        {
            if (t instanceof Income)
            {
                Income income = (Income) t;

                if (income.getCategory().equalsIgnoreCase(category))
                {
                    income.displayDetails();
                }
            }
            else if (t instanceof Expense)
            {
                Expense expense = (Expense) t;

                if (expense.getCategory().equalsIgnoreCase(category))
                {
                    expense.displayDetails();;
                }
            }
        }
    }

    public void saveTransactionData()
    {   
        String transactionData = " ";

        // to write the data and saved it into a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) 
        {
            // to check if the transaction is an Income or Expense
            for (Transaction t : transactions)
            {
                if (t instanceof Income)
                {
                    Income i = (Income) t;
                    transactionData = "Income," + i.getId() + "," + i.getAmount() + "," + i.getDate() +
                                    "," + i.getDescription() + "," + i.getCategory();
                }
                else if (t instanceof Expense)
                {
                    Expense e = (Expense) t;
                    transactionData = "Expense," + e.getId() + "," + e.getAmount() + "," + e.getDate() +
                                    "," + e.getDescription() + "," + e.getCategory();
                }

                writer.write(transactionData);
                writer.newLine();
            }
            System.out.println("💾 Data saved successfully to data/transaction.csv");

        } catch (IOException e) 
        {
            System.out.println("❌ Error saving data: " + e.getMessage());
            e.getStackTrace();
        }
    }

    public void loadTransactionData()
    {
        // used for reading and retrievin the data
        String line;
        String[] data = new String[5];

        // checking if the file exist in this path
        File file = new File(path);
        if (!file.exists()) {return;}

        // to read the data and load it to view the past transactions
        try (BufferedReader read = new BufferedReader(new FileReader(path)))
        {
            
            while((line = read.readLine()) != null)
            {
                data = line.split(",");
            
                if (data[0].equalsIgnoreCase("Income"))
                {
                    Income retrievedData = new Income(Integer.parseInt(data[1]), Double.parseDouble(data[2]), data[3], data[4], data[5]);

                    addTransactions(retrievedData);
                }
                else if (data[0].equalsIgnoreCase("Expense"))
                {
                    Expense retrievedData = new Expense(Integer.parseInt(data[1]), Double.parseDouble(data[2]), data[3], data[4], data[5]);

                    addTransactions(retrievedData);
                }
                System.out.println("💾 Previous transaction is loaded and able to see on your Transaction History.");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("❌ Failed to load the data from the previous process...." + e.getMessage());
        }
    }

}
