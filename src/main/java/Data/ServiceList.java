package Data;

import Model.Service;
import lombok.Data;

import java.util.ArrayList;
@Data
public class ServiceList {
    static public ArrayList<Service> Services = new ArrayList<>();

    static {
        Services.add(new Service("Air Conditioning", 150));
        Services.add(new Service("All inclusive", 350));
        Services.add(new Service("Ironing Services", 200));
        Services.add(new Service("Laundry Services", 200));
        Services.add(new Service("Dry Cleaning", 250));
    }
}
