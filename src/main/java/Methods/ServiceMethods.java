package Methods;

import Service.RoomService;
import Service.ServiceService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ServiceMethods {
    public static class addService implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String serviceName = JOptionPane.showInputDialog(null, "Enter Service Name: ");
            String input2 = JOptionPane.showInputDialog(null, "Enter Service Price: ");
            double price = Double.parseDouble(input2);
            ServiceService.addService(serviceName, price);
        }
    }


    public static class deleteService implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String input2 = JOptionPane.showInputDialog(null, "Enter Service Id ");
            int Id = Integer.parseInt(input2);
            if(Objects.equals(ServiceService.doesServiceExist(Id),true)) {
                ServiceService.deleteService(Id);
            }else JOptionPane.showMessageDialog(null,"Service not found");
        }
    }
    public static class updateService implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input2 = JOptionPane.showInputDialog(null, "Enter Service Id ");
            int Id = Integer.parseInt(input2);
            if(Objects.equals(ServiceService.doesServiceExist(Id),true)) {
            String input3 = JOptionPane.showInputDialog(null, "Enter Service Price ");
            double Price = Double.parseDouble(input3);

                ServiceService.updateService(Id,Price);
            }else JOptionPane.showMessageDialog(null,"Service not found");

        }
    }


}




