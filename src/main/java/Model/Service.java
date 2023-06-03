package Model;

import lombok.*;

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

    @Override
    public String toString() {
        return "Service{" +
                "serviceID=" + serviceID +
                ", serviceName='" + serviceName + '\'' +
                ", price=" + price +
                ", guestsSubscribed=" + guestsSubscribed +
                '}' + "\n";
    }
}
