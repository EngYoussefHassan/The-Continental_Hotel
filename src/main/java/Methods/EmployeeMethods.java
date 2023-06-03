package Methods;

import Data.DataBase;
import Model.*;

import Service.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EmployeeMethods {
    public static class addEmployee implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = JOptionPane.showInputDialog(null, "Enter Employee's name: ");
            String input = JOptionPane.showInputDialog(null, "Enter Employee's salary: ");
            double salary = Double.parseDouble(input);
            Employee employee = new Employee(name, salary);
            EmployeeService.addEmp(employee);
            JOptionPane.showMessageDialog(null, "Employee added successfully");
        }

    }

    public static class updateEmployee implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String input2 = JOptionPane.showInputDialog(null, "Enter Employee's ID: ");
            int Id = Integer.parseInt(input2);
            if (Objects.equals(EmployeeService.doesEmpExist(Id), true)) {
                String input = JOptionPane.showInputDialog(null, "Enter Employee's salary: ");
                double salary = Double.parseDouble(input);
                EmployeeService.updateEmpSalary(Id, salary);
                JOptionPane.showMessageDialog(null, "Employee Updated successfully");
            } else JOptionPane.showMessageDialog(null, "Not found");
        }
    }

    public static class deleteEmployee implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input2 = JOptionPane.showInputDialog(null, "Enter Employee's ID: ");
            int Id = Integer.parseInt(input2);
            if (Objects.equals(EmployeeService.doesEmpExist(Id), true)) {
                EmployeeService.deleteEmp(Id);
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully!");
            } else JOptionPane.showMessageDialog(null, "Not found");
        }
    }

    public static class assignGuestRoom implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String input2 = JOptionPane.showInputDialog(null, "Enter Guest's ID: ");
            int Id = Integer.parseInt(input2);
            if (Objects.equals(GuestService.doesGuestExist(Id), true)) {
                String input = JOptionPane.showInputDialog(null, "Enter room no to be assigned to: ");
                int roomNo = Integer.parseInt(input);
                if (Objects.equals(RoomService.doesRoomExist(roomNo), true)) {
                    EmployeeService.assignGuestRoom(Id, roomNo);
                    JOptionPane.showMessageDialog(null, "Guest Assigned successfully!");
                } else JOptionPane.showMessageDialog(null, "Room Not found!");
            } else JOptionPane.showMessageDialog(null, "Guest not found!");

        }
    }

    public static class assignGuestServices implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<Service> services = new ArrayList<>();

            String input1 = JOptionPane.showInputDialog(null, "Enter Guest's ID: ");
            int Id = Integer.parseInt(input1);
            if (Objects.equals(GuestService.doesGuestExist(Id), true)) {
                String input = JOptionPane.showInputDialog(null, "How many Services to be added: ");
                int noOfServices = Integer.parseInt(input);
                for (int i = 0; i < noOfServices; i++) {
                    String input3 = JOptionPane.showInputDialog(null, "Service Id? ");
                    int serviceId = Integer.parseInt(input3);
                    if (Objects.equals(ServiceService.doesServiceExist(serviceId), true)) {
                        for (Service service : DataBase.services) {
                            if (service.getServiceID() == serviceId) {
                                services.add(service);
                            }
                        }
                        EmployeeService.assignGuestServices(Id, services);
                        JOptionPane.showMessageDialog(null, "Services Assigned Successfully!");
                    } else JOptionPane.showMessageDialog(null, "Service not found!");
                }
            } else JOptionPane.showMessageDialog(null, "Guest not found!");
        }
    }

    public static class viewNearCheckouts implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<Guest> guests = new ArrayList<>();
            for (Guest guest : DataBase.guests) {
                if ((guest.getCheckout().minusDays(2).equals(LocalDate.now()))) {
                    guests.add(guest);
                }
            }
            JOptionPane.showMessageDialog(null, guests.toString(), "Checkouts", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static class viewTodayCheckouts implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<Guest> guests = new ArrayList<>();
            for (Guest guest : DataBase.guests) {
                if ((guest.getCheckout()).equals(LocalDate.now())) {
                    guests.add(guest);
                }
            }
            JOptionPane.showMessageDialog(null, guests.toString(), "Checkouts", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static class viewAllEmployees implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<Employee> employees = new ArrayList<>();
            for (Employee employee:DataBase.employees) {
                boolean add = employees.add(employee);
            }
            JOptionPane.showMessageDialog(null, employees.toString(), "Employees", JOptionPane.PLAIN_MESSAGE);
        }
    }




}

