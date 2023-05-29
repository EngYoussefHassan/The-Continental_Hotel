package Service;

import Data.DataBase;
import Model.Employee;
import Model.Service;

import java.time.LocalDate;
import java.util.List;

public class ServiceService {

    private static int count = 0;
    public void addService(String serviceName ,double price) {
        Service service = new Service(++count,serviceName,price,0);
        DataBase.services.add(service);
    }

    public void deleteService(int Id) {
        DataBase.services.removeIf(service -> service.getServiceID() == Id);
    }

    public void updateService(int Id, double price) {
        for(Service service : DataBase.services){
            if(service.getServiceID() == Id){
                service.setPrice(price);
                service.setGuestsSubscribed(++count);
            }
        }
    }
    public boolean doesServiceExist(int id) {
        boolean state = false;
        int flag = 0;
        for (Service service:DataBase.services) {
            if (service.getServiceID() == id) {
                state = true;
                break;
            }
        }
        return state;
    }
    public List<Service> getStatisticalReport(){
        return DataBase.services;
    }
}
