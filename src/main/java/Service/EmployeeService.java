package Service;

import Data.DataBase;
import Model.Employee;
import Model.Guest;
import Model.Room;
import Model.Service;

import java.time.LocalDate;
import java.util.List;

public class EmployeeService {

    public void AddEmp(Employee employee) {
        DataBase.employees.add(employee);
    }

    public void deleteEmp(int Id) {
        DataBase.employees.removeIf(emp -> emp.getEmpID() == Id);
    }

    public void updateEmpSalary(Employee emp, float newSalary) {
        emp.setSalary(newSalary);
    }

    public void assignGuestRoom(int guestId, Room room) {
        for (Guest guest : DataBase.guests) {
            if (guest.getGuestID() == guestId) {
                guest.setRoom(room);
            }
        }
    }

    public void assignGuestServices(int guestId, List<Service> services) {
        for (Guest guest : DataBase.guests) {
            if (guest.getGuestID() == guestId) {
                guest.setServices(services);
                for (Service service : services) {
                    service.getGuests().add(guest);
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

    public void todayCheckouts() {
        for (Guest guest : DataBase.guests) {
            if ((guest.getCheckout()).equals(LocalDate.now())) {
                System.out.println(guest.toString());
            }
        }

    }

    public List<Employee> getAllEmployees() {
        return DataBase.employees;
    }

}
