package Service;

import Data.DataBase;
import Model.Employee;
import Model.Guest;
import Model.Room;
import Model.Service;

import java.time.LocalDate;
import java.util.List;

public class EmployeeService {

    private static int count = 0;

    //id incriminted in main
    public static void addEmp(Employee employee) {
        DataBase.employees.add(employee);
    }

    public void deleteEmp(int Id) {
        DataBase.employees.removeIf(emp -> emp.getEmpId() == Id);
    }

    public void updateEmpSalary(int id, double newSalary) {
        for (Employee employee : DataBase.employees) {
            if (employee.getEmpId() == id) {
                employee.setSalary(newSalary);
            }
        }
    }

    public void assignGuestRoom(int guestId, int roomNo) {
        for (Guest guest : DataBase.guests) {
            for (Room room : DataBase.rooms) {
                if (room.getRoomNo() == roomNo) {
                    if (guest.getGuestId() == guestId) {
                        guest.setRoom(room);
                    }
                }
            }
        }
    }

    public void assignGuestServices(int guestId, List<Service> services) {
        for (Guest guest : DataBase.guests) {
            if (guest.getGuestId() == guestId) {
                guest.setServices(services);
                for (Service service : services) {
                    service.setGuestsSubscribed(++count);
                }
            }
        }
    }

    //after 2 days within 2 days

    public void viewNearCheckouts() {
        System.out.println("Checkouts within TWO days: " + "\n");
        for (Guest guest : DataBase.guests) {
            if ((guest.getCheckout().minusDays(2).equals(LocalDate.now()))) {
                System.out.println(guest.toString());
            }
        }
    }

    public void viewTodayCheckouts() {
        for (Guest guest : DataBase.guests) {
            if ((guest.getCheckout()).equals(LocalDate.now())) {
                System.out.println(guest.toString());
            }
        }
    }

    public boolean doesEmpExist(int id) {
        boolean state = false;
        int flag = 0;
        for (Employee employee : DataBase.employees) {
            if (employee.getEmpId() == id) {
                state = true;
                break;
            }
        }
        return state;
    }

    public List<Employee> viewAllEmployees() {
        return DataBase.employees;
    }
}
