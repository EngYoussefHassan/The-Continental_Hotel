import Model.Guest;
import Service.GuestService;
import Service.ServiceService;

public class Main {
    public static void main(String[] args) {
        ServiceService serviceService = new ServiceService();
        System.out.println(serviceService.getStatisticalReport().toString());
    }
}
