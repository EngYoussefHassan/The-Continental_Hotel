package Methods;

import Data.DataBase;
import Model.Employee;
import Model.Guest;
import Model.Room;
import Service.EmployeeService;
import Service.GuestService;
import Service.RoomService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GuestMethods {
    public static class addGuest implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = JOptionPane.showInputDialog(null, "Enter Guest's name: ");
            String natID = JOptionPane.showInputDialog(null, "Enter Guest's national Id: ");
            String input = JOptionPane.showInputDialog(null, "Enter Room: ");
            int roomNo = Integer.parseInt(input);
            if (Objects.equals(RoomService.doesRoomExist(roomNo), true)) {
                String input1 = JOptionPane.showInputDialog(null, "Checkout Date (ENTER YEAR) ");
                int year = Integer.parseInt(input1);
                String input2 = JOptionPane.showInputDialog(null, "Checkout Date (ENTER MONTH) ");
                int month = Integer.parseInt(input2);
                String input3 = JOptionPane.showInputDialog(null, "Checkout Date (ENTER DAY) ");
                int day = Integer.parseInt(input3);
                LocalDate checkout = LocalDate.of(year, month, day);
                GuestService.addGuest(name, natID, roomNo, checkout);
            } else JOptionPane.showMessageDialog(null, "Room not Found!");


        }
    }

    public static class updateGuest implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int guestRoom = 0;
            String input = JOptionPane.showInputDialog(null, "Enter Guest's Id: ");
            int id = Integer.parseInt(input);
            String input2 = JOptionPane.showInputDialog(null, "Enter Guest's new room number: ");
            int roomNum = Integer.parseInt(input2);
            if (Objects.equals(RoomService.doesRoomExist(roomNum), true)) {
                GuestService.updateGuestRoom(id, roomNum);
                JOptionPane.showMessageDialog(null, "Guest updated successfully!");
            } else JOptionPane.showMessageDialog(null, "Room not found!");
        }
    }

    public static class deleteGuest implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog(null, "Enter Guest's Id: ");
            int id = Integer.parseInt(input);
            if (Objects.equals(GuestService.doesGuestExist(id), true)) {
                GuestService.deleteGuest(id);
                JOptionPane.showMessageDialog(null, "Guest deleted successfully!");
            } else JOptionPane.showMessageDialog(null, "Guest not found!");
        }
    }

    public static class viewAllGuests implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, DataBase.guests.toString(), "Guests", JOptionPane.PLAIN_MESSAGE);
        }


    }
}
