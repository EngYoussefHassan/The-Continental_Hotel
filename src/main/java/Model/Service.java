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
@AllArgsConstructor

public class Service {
    private int serviceID;
    private String serviceName;
    private double price;
    private static int count = 0;
    private int guestsSubscribed;

    public Service(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
        serviceID = ++count;
    }

}
