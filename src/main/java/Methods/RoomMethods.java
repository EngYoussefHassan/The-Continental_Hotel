package Methods;

import Data.DataBase;
import Model.Employee;
import Model.RoomType;
import Service.RoomService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoomMethods {
    public static class addRoom implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input2 = JOptionPane.showInputDialog(null, "Enter Room number: ");
            int roomNo = Integer.parseInt(input2);
            if (Objects.equals(RoomService.doesRoomExist(roomNo), false)) {
                String roomType = JOptionPane.showInputDialog(null, "Enter room type (SINGLE / DOUBLE / SUITE) : ");
                RoomService.addRoom(roomNo, roomType);
            } else JOptionPane.showMessageDialog(null, "Room already exist!");
        }
    }

    public static class updateRoomAvailability implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input2 = JOptionPane.showInputDialog(null, "Enter Room number: ");
            int roomNo = Integer.parseInt(input2);

            if (Objects.equals(RoomService.doesRoomExist(roomNo), true)) {
                RoomService.updateRoomAvailability(roomNo);
                JOptionPane.showMessageDialog(null, "Room " + roomNo + " is now Available!");
            } else JOptionPane.showMessageDialog(null, "Room Not found!");
        }

    }


    public static class DeleteRoom implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int id;
            String input2 = JOptionPane.showInputDialog(null, "Enter Room number: ");
            id = Integer.parseInt(input2);
            if (Objects.equals(RoomService.doesRoomExist(id), true)) {
                RoomService.deleteRoom(id);
                JOptionPane.showMessageDialog(null, "Room deleted successfully");
            } else JOptionPane.showMessageDialog(null, "Room Not found!");
        }
    }


    public static class FilterBusy implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            RoomService.filterBusy(false);

        }
    }

    public static class FilterBusyRoomType implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String roomType=JOptionPane.showInputDialog(null,"Enter room Type");

            RoomService.filterBusyRoomType(false,roomType);

        }
    }
    public static class ViewAllRooms implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,DataBase.rooms.toString(),"AllRooms", JOptionPane.PLAIN_MESSAGE);

        }
    }


}

