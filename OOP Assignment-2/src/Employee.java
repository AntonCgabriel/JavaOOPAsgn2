// package assignment3;
import java.text.DecimalFormat;

public class Employee{
    protected DecimalFormat df = new DecimalFormat("#.00");
    protected String id = "";
    protected String name = "";
    protected double baseSalary = 0.0;
    protected double grossSalary = 0.0;
    protected double netSalary = 0.0;
    protected double bonusRatio = 0.0;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        calculateGross(baseSalary);
    }

    public double calculateGross(double baseSalary){
        this.baseSalary = truncate(baseSalary);
        grossSalary = this.baseSalary;
        this.netSalary = calculateNet(this.baseSalary);
        return grossSalary;
    }






    // Employee class Getters
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getGrossSalary(){
        return baseSalary;
    }

    public double getNetSalary(){
        return netSalary;
    }

    public String getEmployeeInfo(String id){
        String message = (name + "'s gross salary is " + df.format(grossSalary) + " SEK per month.");
        return message;
    }

    public String getEmployeeAddedMessage(){
        String message = "Employee "+ this.id + " was registered successfully.";
        return message;
    }

    public String getEmployeeRemovedMessage(){
        String message = "Employee "+ this.id + " was removed successfully.";
        return message;
    }

    // Employee class setters
    public void setName(String newName){
        name = newName;
    }

    public void setGrossSalary(Double newBaseSalary){
        baseSalary = newBaseSalary;
    }

    // Calculating Methods
    public double calculateNet(double grossSalary){
        return truncate(grossSalary - (grossSalary * 0.1));
    }

    protected double truncate(double value){
        double truncatedValue =  Math.floor(value * 100) / 100;
        return truncatedValue;
    }



}




