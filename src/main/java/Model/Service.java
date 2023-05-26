package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data

public class Service {
    private int serviceID;
    private String serviceName;
    private double price;
    private List<Guest> guests;
    private static int count = 0;

    public Service(int serviceID, String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
        this.serviceID = serviceID;
    }
}
