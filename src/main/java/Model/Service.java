package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@Data

public class Service {
    private int serviceID;
    private String serviceName;
    private double price;
    //private List<Guest> guests;
    private int guestsSubscribed;

    public Service(int serviceID, String serviceName, double price, int guestsSubscribed) {
        this.serviceName = serviceName;
        this.serviceID = serviceID;
        this.price = price;
        this.guestsSubscribed = guestsSubscribed;
    }

}
