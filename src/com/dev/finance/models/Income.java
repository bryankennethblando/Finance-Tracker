package com.dev.finance.models;

public class Income extends Transaction
{
    private String sourceOfIncome;
 
    public Income(int id, double amount, String date, String description, String sourceOfIncome)
    {
        super(id, amount, date, description);

        this.sourceOfIncome = sourceOfIncome;
    }

    public String getCategory() {return sourceOfIncome;}
    
    @Override
    public void displayDetails() 
    {   
        System.out.println("\n-------------------------------------" +
            "\n             Income Details" +
            "\n-------------------------------------"
        );
        System.out.println("UserId: " + id +
            "\nDate: " + date +
            "\nIncome: " + sourceOfIncome + " - " + amount + "PHP" +
            "\n-------------------------------------" +
            "\nDescription: " + description +
            "\n-------------------------------------"
        );
    }
}
