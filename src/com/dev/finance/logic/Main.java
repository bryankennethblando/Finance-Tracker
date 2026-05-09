package com.dev.finance.logic;

import java.util.*;
import com.dev.finance.models.*;

public class Main
{
    public static void main(String args[])
    {
        // scanner for user input
        Scanner scanner = new Scanner(System.in);

        // the object and varibles that will be used
        FinanceManager manager = new FinanceManager();
        int choice = 0;

        // for menus
        String[] menus = {
            "Add Income", 
            "Add Expense", 
            "View Current Balance", 
            "View Current Transaction History",
            "Exit"
        };

        while(true)
        {
            // for printing the menus
            for (int i = 0; i < menus.length; i++)
            {
                System.out.println(( i + 1) + ". " + menus[i]);
            }

            // for input validation
            try 
            {
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();
            } 
            catch (Exception e) 
            {
                System.out.println("Inpunt the number only.");
                scanner.nextLine();
                continue;
            }

            // for indentifying the input option choice
            switch (choice) 
            {
                case 1:
                    System.out.println("----Adding Income----");

                    // for random id generated per transaction
                    int incomeID = (int) (Math.random() * 1000);

                    // amount
                    System.out.print("Enter Amount: ");
                    double incomeAmount = scanner.nextDouble();
                    scanner.nextLine();

                    // date
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String incomeDate = scanner.nextLine();

                    // description
                    System.out.print("Description: ");
                    String incomeDescription = scanner.nextLine();

                    // source of income
                    System.out.print("Source of Income: ");
                    String incomeSource = scanner.nextLine();

                    // creating an Income object
                    Income newIncome = new Income(incomeID, incomeAmount, incomeDate, incomeDescription, incomeSource);

                    // passing the object to the main-FinanceManage that is stored in a arraylist
                    manager.addTransactions(newIncome);

                    break;
                
                case 2:
                    System.out.println("----Subtracting Expense----");

                    // for random id generated per transaction
                    int expenseID = (int) (Math.random() * 1000);

                    // amount
                    System.out.print("Enter Amount: ");
                    double expenseAmount = scanner.nextDouble();
                    scanner.nextLine();

                    // date
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String expenceDate = scanner.nextLine();

                    // description
                    System.out.print("Description: ");
                    String expenseDescription = scanner.nextLine();

                    // source of income
                    System.out.print("Expense: ");
                    String expenseType = scanner.nextLine();

                    // creating an expense object
                    Expense newExpense = new Expense(expenseID, expenseAmount, expenceDate, expenseDescription, expenseType);

                    // passing the object to the main-FinanceManage that is stored in a arraylist
                    manager.addTransactions(newExpense);

                    break;

                case 3:

                    //viewing the current balance
                    System.out.println("----View Current Balance----");
                    System.out.println("------------------------------");
                    System.out.println("Current Cash Balance: " + manager.calculateBalance());
                    System.out.println("------------------------------");

                    break;
                
                case 4:

                    // viewing the transaction history
                    System.out.println("----View Current Transaction History----");

                    System.out.print("Want to filter out by category or show all the trasaction history (y/n)? ");
                    char option = scanner.next().charAt(0);
                    scanner.nextLine();

                    // per category filtering
                    if (option == 'y')
                    {
                        System.out.print("Enter Category (e.g., Salary or Bills): ");
                        String category = scanner.nextLine();

                        manager.filterByCategory(category);
                    }
                    else
                    {
                        manager.viewHistory();
                    }

                    break;
                
                case 5:

                    // exiting the system 
                    System.out.println("Thank you for using Finance Tracker. Goodbye...");
                    System.exit(0);

                default:
                    System.out.println("Invalid option choice. Try again.");
                    break;
            }
        }
    }
}