import Data.DataBase;
import Model.*;
import Service.EmployeeService;
import Service.GuestService;
import Service.ServiceService;
import Service.RoomService;
import Service.GuestBillingService;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        ServiceService serviceService = new ServiceService();
        GuestService guestService = new GuestService();
        RoomService roomService = new RoomService();
        GuestBillingService guestBillingService = new GuestBillingService();

        Scanner scanner = new Scanner(System.in);
        int choice = 69;

        while (choice != 0) {
            System.out.println("Please enter the number indicating your choice: \n" +
                    "1. Employees Management.\n" +
                    "2. Guest Management.\n" +
                    "3. Room Management.\n" +
                    "4. Service Management.\n" +
                    "5. Guest Billing Management.\n" +
                    "6. Services Statistical Report. \n" +
                    "0. To exit.\n");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Please Choose Wisely: ");
                    System.out.println("1. Add employee\n" +
                            "2. Update employee\n" +
                            "3. Delete employee\n" +
                            "4. Assign guest room\n" +
                            "5. Assign guest services\n" +
                            "6. View near checkouts \n" +
                            "7. View today's checkouts\n" +
                            "8. View all employees\n");
                    int internalChoice = scanner.nextInt();
                    switch (internalChoice) {
                        case 1: {
                            String name;
                            double salary;
                            System.out.println("Enter Employee's Name: ");
                            name = scanner.next();
                            System.out.println("Enter Employee's Salary ");
                            salary = scanner.nextDouble();
                            Employee employee = new Employee(name, salary);
                            employeeService.addEmp(employee);
                            System.out.println("Employee Added Successfully!");
                            break;
                        }
                        case 2: {
                            int id;
                            double salary;
                            System.out.println("Enter Employee's ID: ");
                            id = scanner.nextInt();
                            System.out.println("Please enter updated salary: ");
                            salary = scanner.nextDouble();
                            employeeService.updateEmpSalary(id, salary);
                            System.out.println("Employee Updated Successfully!");
                            break;

                        }
                        case 3: {
                            int id;
                            System.out.println("Enter Employee's ID");
                            id = scanner.nextInt();
                            employeeService.deleteEmp(id);
                            System.out.println("Employee Deleted Successfully!");
                            break;
                        }
                        case 4: {
                            int id;
                            int roomNo;
                            System.out.println("Enter Guest's Id:");
                            id = scanner.nextInt();
                            System.out.println("Enter Room Number to be assigned to: ");
                            roomNo = scanner.nextInt();
                            employeeService.assignGuestRoom(id, roomNo);
                            System.out.println("Guest Assigned Successfully");
                            break;
                        }
                        case 5: {
                            int noOfServices;
                            int serviceId;
                            int id;
                            List<Service> services = new ArrayList<>();
                            System.out.println("Enter Guest ID: ");
                            id = scanner.nextInt();
                            System.out.println("How Many services Would you like to add?");
                            noOfServices = scanner.nextInt();
                            for (int i = 0; i < noOfServices; i++) {
                                System.out.println("Please enter Service Name:");
                                serviceId = scanner.nextInt();
                                for (Service service : DataBase.services) {
                                    if (service.getServiceID() == serviceId) {
                                        services.add(service);
                                    }
                                }
                            }
                            employeeService.assignGuestServices(id, services);
                            System.out.println("Services Assigned To Guest!");
                            break;
                        }
                        case 6: {
                            employeeService.viewNearCheckouts();
                        }
                        case 7: {
                            employeeService.viewTodayCheckouts();
                        }
                        case 8: {
                            System.out.println(employeeService.viewAllEmployees());
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Please Choose Wisely: ");
                    System.out.println("1. Add guest\n" +
                            "2. Update guest\n" +
                            "3. Delete guest\n" +
                            "4. view all guests\n"
                    );
                    int internalChoice = scanner.nextInt();
                    switch (internalChoice) {
                        case 1: {
                            String name;
                            String natID;
                            Room guestRoom = new Room();
                            int roomNum;

                            System.out.println("Enter Guest's Name: ");
                            name = scanner.next();
                            System.out.println("Enter Guest's NatID: ");
                            natID = scanner.next();
                            System.out.println("Enter Guest's room number: ");
                            roomNum = scanner.nextInt();
                            for (Room room : DataBase.rooms) {
                                if (room.getRoomNo() == roomNum) {
                                    guestRoom = room;
                                }
                            }
                            System.out.println("Enter Guest's checkout date: ");
                            LocalDate checkout = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                            Guest guest = new Guest(name, natID, guestRoom, checkout);
                            guestService.addGuest(guest);
                            System.out.println("Guest added successfully");
                            break;
                        }

                        case 2: {
                            int guestId;
                            int roomNo;
                            System.out.println("Enter Guest ID:");
                            guestId = scanner.nextInt();
                            System.out.println("Enter Room Number:");
                            roomNo = scanner.nextInt();
                            guestService.updateGuestRoom(guestId, roomNo);
                            System.out.println("Guest updated successfully!");
                            break;
                        }
                        case 3: {
                            int guestId;
                            System.out.println("Enter Room Number:");
                            guestId = scanner.nextInt();
                            guestService.deleteGuest(guestId);
                            System.out.println("Room deleted successfully!");
                        }
                        case 4: {
                            System.out.println(guestService.getAllGuests());
                        }
                    }

                }
                case 3: {
                    System.out.println("Please choose Wisely");
                    System.out.println("Room service\n" +
                            "1. Add room\n" +
                            "2. Update Availability room\n" +
                            "3. Delete room\n" +
                            "4. Filter free rooms\n" +
                            "5. Filter free rooms and it's type\n" +
                            "6. View all rooms.\n");
                    int internalChoice = scanner.nextInt();
                    switch (internalChoice) {
                        case 1: {
                            int roomNo;
                            String roomType;
                            System.out.println("Please enter room number");
                            roomNo = scanner.nextInt();
                            System.out.println("Please enter Room Type:");
                            roomType = scanner.next();
                            roomService.addRoom(roomNo, roomType);
                            System.out.println("Room Added Successfully!");
                            break;
                        }
                        case 2: {
                            int roomNo;
                            System.out.println("Enter Room number: ");
                            roomNo = scanner.nextInt();
                            roomService.updateRoomAvailability(roomNo);
                            System.out.println("Room " + roomNo + " is now Available!");
                            break;
                        }
                        case 3: {
                            int id;
                            System.out.println("Enter Room number:");
                            id = scanner.nextInt();
                            roomService.deleteRoom(id);
                            System.out.println("Room deleted successfully!");
                            break;
                        }
                        case 4: {
                            roomService.filterBusy(false);
                            break;
                        }
                        case 5: {
                            String roomType;
                            System.out.println("Enter RoomType:");
                            roomType = scanner.next();
                            roomService.filterBusyRoomType(false, roomType);
                            break;
                        }
                        case 6: {
                            System.out.println(roomService.getAllRooms());
                            break;
                        }

                    }
                    break;
                }
                case 4: {
                    System.out.println("Please choose wisely:");
                    System.out.println("1.Add service \n" +
                            "2.Delete service\n" + "3.Update service\n");
                    int internalChoice = scanner.nextInt();
                    switch (internalChoice) {
                        case 1: {
                            String name;
                            double price;
                            System.out.println("Enter name of service:");
                            name = scanner.next();
                            System.out.println("Enter price of service:");
                            price = scanner.nextDouble();
                            serviceService.addService(name, price);
                            System.out.println("Service Added Successfully!");
                            break;
                        }
                        case 2: {
                            int id;
                            System.out.println("Please enter ID:");
                            id = scanner.nextInt();
                            serviceService.deleteService(id);
                            System.out.println("Service Removed Successfully!");
                            break;

                        }
                        case 3: {
                            int id;
                            double price;
                            System.out.println("Please enter ID:");
                            id = scanner.nextInt();
                            System.out.println("Enter new price:");
                            price = scanner.nextDouble();
                            serviceService.updateService(id, price);
                            System.out.println("Service Updated Successfully!");
                            break;
                        }
                    }
                }
                case 5: {
                    System.out.println("Please choose wisely:");
                    System.out.println("1.View Reservation cost \n" +
                            "2.View Services cost\n" + "3.Total invoice\n");
                    int internalChoice = scanner.nextInt();
                    switch (internalChoice) {
                        case 1: {
                            int id;
                            System.out.println("Enter guest's ID:");
                            id = scanner.nextInt();
                            System.out.println(guestBillingService.calcReservationCost(id));
                            break;
                        }
                        case 2: {
                            int id;
                            System.out.println("Enter guest's ID");
                            id = scanner.nextInt();
                            System.out.println(guestBillingService.calcCostOfServices(id));
                            break;

                        }
                        case 3: {
                            int id;
                            System.out.println("Enter guest's ID:");
                            id = scanner.nextInt();
                            System.out.println(guestBillingService.calcGuestInvoice(id));
                            break;
                        }
                    }
                    break;
                }
                case 6: {
                    System.out.println(serviceService.getStatisticalReport());
                }
            }
        }
    }
}
