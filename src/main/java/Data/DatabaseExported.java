package Data;

import Model.Employee;
import Util.ExcelUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseExported {

    public static final String filePath = "E:\\Computer Engineering\\OOP\\OOP PROJECTS\\The_Continental_Hotel\\src\\main\\java\\Files\\Employees.xlsx";

    public static List<Employee> getAllEmployees() throws IOException {
        List<Employee> employees = new ArrayList<>();
        Employee employee;
        ExcelUtils.setExcelFile(filePath, 0);
        for (int i = 1; i < ExcelUtils.getNumberOfRows() + 1; i++) {
            employee = new Employee();
            employee.setEmpId(Integer.parseInt(getCellData(i, 0)));
            employee.setName(getCellData(i, 1));
            employee.setSalary(Double.parseDouble(getCellData(i, 2)));

            employees.add(employee);
        }
        return employees;

    }

    private static String getCellData(int row, int col) {
        try {
            return ExcelUtils.getCellData(row, col).toString().trim();
        } catch (Exception e) {
            return "";
        }
    }
}
