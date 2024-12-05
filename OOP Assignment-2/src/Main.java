// package assignment3;

public class Main {
    public static void main(String[] args) {
        Company myCompany = new Company();
        //myCompany.createEmployee("Emp1", "Elektra", 35000.50, "Msc", "Business");       // G: 47000.60; N: 37600.48
        //myCompany.createEmployee("Emp2", "Blanca", 45000.00, "PhD", "Human Resources"); // G: 65750.00; N: 45450.00
        //myCompany.createEmployee("Emp3", "Pray Tell", 25000.25, "BSc");                 // G: 27500.27; N: 24750.24
        //myCompany.createEmployee("Emp4", "Lulu", 20000.00, 9);                          // G: 21000.00; N: 21000.00
        //myCompany.createEmployee("Emp5", "Angel", 28500.10, 7);                         // G: 28500.10; N: 28500.10
        //myCompany.createEmployee("Emp6", "Candy", 35000.50, 4);                         // G:     0.00; N:     0.00
        //myCompany.createEmployee("Emp7", "Ricky", 23500.00);                            // G: 23500.00; N: 21150.00
        //myCompany.createEmployee("Emp8", "Damon", 22100.00);
        myCompany.createEmployee("IDf", "Angela Martin", 15000.00, 9);                            // G: 22100.00; N: 19890.00
        myCompany.getNetSalary("IDf");
    }
}