package Service;

import Data.DataBase;
import Model.Service;

import java.util.stream.Collectors;

public class ServiceService {

    public void addService(Service service) {
        DataBase.services.add(service);

    }

    public void deleteService(int Id) {
        DataBase.services = DataBase.services.stream().filter(s -> s.getServiceID() != Id).collect(Collectors.toList());
    }

    public void updateService(int Id, double price) {
        for(Service service : DataBase.services){
            if(service.getServiceID() == Id){
                service.setPrice(price);
            }
        }
    }
}
