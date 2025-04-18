/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mkpl.uts;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hafid
 */
public class Employee {

    private String employeeId;
    private FullName fullname;
    private String idNumber;
        private LocalDate joindDate; 
    private int monthWorkingInYear;
    private String address;
    private boolean isForeigner;
    private Gender gender;
    private Period period;
    private Spouse spouse;
    private EmployeeIncome employeeIncome;
    private List<Child> Children = new LinkedList<>();

    public Employee(String employeeId, String idNumber, String address) {
        this.employeeId = employeeId;
        this.idNumber = idNumber;
        this.address = address;
    }

    public List<Child> getChildren() {
        return Children;
    }

    public void setChildren(List<Child> Children) {
        this.Children = Children;
    }

    public EmployeeIncome getEmployeeIncome() {
        return employeeIncome;
    }

    public void setEmployeeIncome(EmployeeIncome employeeIncome) {
        this.employeeIncome = employeeIncome;
    }

    public FullName getFullname() {
        return fullname;
    }

    public void setFullname(FullName fullname) {
        this.fullname = fullname;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public void addChild(Child child) {
        Children.add(child);
    }

    public int getAnnualIncomeTax() {

        //Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
        LocalDate date = LocalDate.now();

        if (date.getYear() == getPeriod().getJoindDate().getYear()) {
            getPeriod().setMonthWorkingInYear(date.getMonthValue() - getPeriod().getJoindDate().getMonthValue());
        } else {
            getPeriod().setMonthWorkingInYear(12);
        }

        return TaxFunction.calculateTax(getEmployeeIncome().getMonthlySalary(), getEmployeeIncome().getOtherMonthlyIncome(), getPeriod().getMonthWorkingInYear(), getEmployeeIncome().getAnnualDeductible(), getSpouse().getSpouseIdNumber().equals(""), getChildren().size());
    }

}
