public class Main {
    public static void main(String[] args) {
        Company myCompany = new Company();
        myCompany.createEmployee("asb123","Greger", 10000.0);
        myCompany.createEmployee("asb124","Greg", 12000.0);
        myCompany.updateEmployeeName("asb124", "Gunnar");
    }
}