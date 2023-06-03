package Methods;

import Service.GuestBillingService;
import Service.GuestService;
import Service.RoomService;
import Service.ServiceService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GuestBillingMethods {
    public static class reservationCost implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog(null, "Enter Guest's Id:");
            int id = Integer.parseInt(input);
            if(Objects.equals(GuestService.doesGuestExist(id),true)){
                double cost = GuestBillingService.calcReservationCost(id);
                JOptionPane.showMessageDialog(null,cost,"Guest Reservation Cost",JOptionPane.PLAIN_MESSAGE);
            }else JOptionPane.showMessageDialog(null,"Guest Not found!");
        }
    }

    public static class servicesCost implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog(null, "Enter Guest's Id:");
            int id = Integer.parseInt(input);
            if(Objects.equals(GuestService.doesGuestExist(id),true)){
                double cost = GuestBillingService.calcCostOfServices(id);
                JOptionPane.showMessageDialog(null,cost,"Guest Services Cost",JOptionPane.PLAIN_MESSAGE);
            }else JOptionPane.showMessageDialog(null,"Guest Not found!");
        }
    }

    public static class invoice implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog(null, "Enter Guest's Id:");
            int id = Integer.parseInt(input);
            if(Objects.equals(GuestService.doesGuestExist(id),true)){
                double cost = GuestBillingService.calcGuestInvoice(id);
                JOptionPane.showMessageDialog(null,cost,"Guest Invoice",JOptionPane.PLAIN_MESSAGE);
            }else JOptionPane.showMessageDialog(null,"Guest Not found!");
        }
    }
}
