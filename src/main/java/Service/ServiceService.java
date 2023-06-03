package Service;

import Data.DataBase;
import Model.Service;

import javax.swing.*;
import java.util.List;

public class ServiceService {

    private static int count = 0;
    public static void addService(String serviceName ,double price) {

        Service service = new Service(++count,serviceName,price,0);
        DataBase.services.add(service);
        JOptionPane.showMessageDialog(null,"Service added successfully");
    }

    public static void deleteService(int Id) {

        DataBase.services.removeIf(service -> service.getServiceID() == Id);
        JOptionPane.showMessageDialog(null,"Service deleted successfully");
    }

    public static void updateService(int Id, double price) {
        for(Service service : DataBase.services){
            if(service.getServiceID() == Id){
                service.setPrice(price);
                service.setGuestsSubscribed(++count);
            }
        }
        JOptionPane.showMessageDialog(null,"Service updated successfully");
    }
    public static boolean doesServiceExist(int id) {
        boolean state = false;
        for (Service service:DataBase.services) {
            if (service.getServiceID() == id) {
                state = true;
                break;
            }
        }
        return state;
    }
    public static List<Service> getStatisticalReport(){
        return DataBase.services;
    }
}
