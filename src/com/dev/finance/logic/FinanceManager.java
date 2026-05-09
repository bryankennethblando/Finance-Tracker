package com.dev.finance.logic;

import java.util.*;
import com.dev.finance.models.*;

public class FinanceManager
{
    ArrayList<Transaction> transactions = new ArrayList<>();

    public void addTransactions(Transaction t) {transactions.add(t);}

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

    public void viewHistory()
    {   
    
        if (transactions.isEmpty()) {System.out.println("There's no records found."); return;}

        for (Transaction t: transactions)
        {
            if (t instanceof Income) {t.displayDetails();}
            else if (t instanceof Expense) {t.displayDetails();}
        }
    }

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

}
