package com.dev.finance.models;

public abstract class Transaction 
{
    protected int id;
    protected double amount;
    protected String date;
    protected String description;
    
    // contructor
    Transaction(int id, double amount, String date, String description)
    {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    // to display the finance information you have
    public abstract void displayDetails();

    // getters
    public int getId() {return id;}
    public double getAmount() {return amount;}
    public String getDate() {return date;}
    public String getDescription() {return description;}
}
