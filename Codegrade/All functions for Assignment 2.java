String actualMessage = facade.createEmployee(employeeID, employeeName, grossSalary);

String actualPrint = facade.printEmployee(employeeID);

double netSalary = facade.getNetSalary(employeeID);

String actualMessage = facade.removeEmployee(empID);

assertEquals(expectedPrint, facade.printAllEmployees());

assertEquals(expectedTotal, facade.getTotalNetSalary());

assertEquals(expectedPrint, facade.printSortedEmployees());

assertEquals("Employee Emp6 was updated successfully", facade.updateEmployeeName("Emp6", "Candy Ferocity"));

assertEquals("Employee Emp6 was updated successfully", facade.updateInternGPA("Emp6", 10));

assertEquals("Employee Emp1 was updated successfully", facade.updateManagerDegree("Emp1", "PhD"));

assertEquals("Employee Emp1 was updated successfully", facade.updateDirectorDept("Emp1", "Technical"));

assertEquals("Employee Emp3 was updated successfully", facade.updateGrossSalary("Emp3", 28000.99));

Map<String, Integer> actualMap = facade.mapEachDegree();

assertEquals(expectedMessage , facade.promoteToManager(damonID, "PhD"));

assertEquals(expectedMessage , facade.promoteToDirector(rickyID, "PhD", "Human Resources"));

assertEquals(expectedMessage , facade.promoteToIntern(damonID, 1));