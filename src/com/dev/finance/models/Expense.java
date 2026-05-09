package com.dev.finance.models;

public class Expense extends Transaction
{
    private String expenseType;
 
    public Expense(int id, double amount, String date, String description, String expenseType)
    {
        super(id, amount, date, description);
        
        this.expenseType = expenseType;
    }   

    public String getCategory() {return expenseType;}

    @Override
    public void displayDetails() 
    {
        System.out.println("----Expense Details----");
        System.out.println("UserId: " + id +
            "\nDate: " + date +
            "\nIncome: " + expenseType + "-" + amount +
            "\n-------------------------------------" +
            "\nDescription: " + description +
            "\n-------------------------------------"
        );
    } 
}
