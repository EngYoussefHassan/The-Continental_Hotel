package Service;

import Data.DataBase;
import Model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class EmployeeService {

    private static int count = 0;

    public static void addEmp(Employee employee) {
        DataBase.employees.add(employee);
    }

    public static void deleteEmp(int Id) {
        DataBase.employees.removeIf(emp -> emp.getEmpId() == Id);
    }

    public static void updateEmpSalary(int id, double newSalary) {
        for (Employee employee : DataBase.employees) {
            if (employee.getEmpId() == id) {
                employee.setSalary(newSalary);
            }
        }
    }

    public static void assignGuestRoom(int guestId, int roomNo) {
        for (Guest guest : DataBase.guests) {
            for (Room room : DataBase.rooms) {
                if (Objects.equals(RoomService.doesRoomExist(roomNo), true)) {
                    if (room.getRoomNo() == roomNo) {
                        if (guest.getGuestId() == guestId) {
                            guest.setRoom(room);
                            room.setOccupied(true);
                        }
                    }
                } else JOptionPane.showMessageDialog(null, "Room Not Found!");
            }
        }
    }

    public static void assignGuestServices(int guestId, List<Service> services) {
        for (Guest guest : DataBase.guests) {
            if (guest.getGuestId() == guestId) {
                guest.setServices(services);
                for (Service service : services) {
                    service.setGuestsSubscribed(++count);
                }
            }
        }
    }

    public static boolean doesEmpExist(int id) {
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
}
