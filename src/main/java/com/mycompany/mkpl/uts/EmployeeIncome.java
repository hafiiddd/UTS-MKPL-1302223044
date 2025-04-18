/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mkpl.uts;

/**
 *
 * @author hafid
 */
public class EmployeeIncome {

    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    public EmployeeIncome(int monthlySalary, int otherMonthlyIncome, int annualDeductible) {
        this.monthlySalary = monthlySalary;
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.annualDeductible = annualDeductible;
    }

    public int getMonthlySalary() {

        return monthlySalary;
    }

    public void setMonthlySalary(int grade, boolean isForeigner) {
        int baseSalary = getBaseSalaryByGrade(grade);
        if (isForeigner) {
            baseSalary *= 1.5;
        }
        this.monthlySalary = baseSalary;
    }

    private int getBaseSalaryByGrade(int grade) {
        switch (grade) {
            case 1:
                return 3000000;
            case 2:
                return 5000000;
            case 3:
                return 7000000;
            default:
                return 0;
        }
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public void setOtherMonthlyIncome(int otherMonthlyIncome) {
        this.otherMonthlyIncome = otherMonthlyIncome;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }

    public void setAnnualDeductible(int annualDeductible) {
        this.annualDeductible = annualDeductible;
    }

}
