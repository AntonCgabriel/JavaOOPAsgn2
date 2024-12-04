public class Main {
    public static void main(String[] args) {
        Company myCompany = new Company();
        myCompany.createEmployee("asb123","GregEmployee", 10000.00);
        myCompany.createEmployee("asb124","BosseManager", 10000.00, "PhD");
        myCompany.createEmployee("asb125","HasseDirector", 10000.00, "PhD", "Human Resources");
        myCompany.createEmployee("asb126","FilipIntern", 10000.00, 1);
        myCompany.printEmployee("asb123");
        myCompany.printEmployee("asb124");
        myCompany.printEmployee("asb125");
        myCompany.printEmployee("asb126");
    }
}