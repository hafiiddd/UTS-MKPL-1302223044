/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mkpl.uts;

/**
 *
 * @author hafid
 */
public class TaxFunction {
     private static final int BASE_SALARY = 54000000;
    private static final int MARRIED_BONUS = 4500000;
        private static final int CHILD_BONUS = 4500000;
    private static final int MAX_CHILDREN = 3;

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {

        validateNumberOfMonth(numberOfMonthWorking);

        if (numberOfChildren > 3) {
            numberOfChildren = MAX_CHILDREN;
        }

        int monthSalary = calculateMonthSalary(monthlySalary, otherMonthlyIncome, numberOfMonthWorking);
        int calcuTax = calculateSalaryIncludeTax(isMarried, numberOfChildren);
        int salaryAfterTax = monthSalary - deductible - calcuTax;

        return salaryAfterTax;

    }

    public static void validateNumberOfMonth(int numberofWorking) {
        if (numberofWorking > 12) {
            System.err.println("More than 12 month working per year");
        }
    }

    public static int calculateMonthSalary(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking) {
        return (int) 0.5 * ((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking);
    }

    public static int calculateSalaryIncludeTax(boolean isMarried, int numberOfChildren) {
        int salary = BASE_SALARY;
        if (isMarried) {
            salary +=MARRIED_BONUS;
            if (numberOfChildren > 0) {
                salary += CHILD_BONUS * 3;
            }
        }

        return salary;
    }
}
