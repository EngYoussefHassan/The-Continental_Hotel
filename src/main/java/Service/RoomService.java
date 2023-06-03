package Service;

import Data.DataBase;
import Model.*;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class RoomService {


    public static void addRoom(int roomNo, String roomType) {
        double cost;
        RoomType roomTypeEnum;
        if (Objects.equals(roomType, "Single") || Objects.equals(roomType, "single") || Objects.equals(roomType, "SINGLE")) {
            cost = 800;
            roomTypeEnum = RoomType.SINGLE;
            DataBase.rooms.add(new Room(roomNo, roomTypeEnum, false, cost));
            JOptionPane.showMessageDialog(null, "Room Added Successfully!");
        } else if (Objects.equals(roomType, "Double") || Objects.equals(roomType, "double") || Objects.equals(roomType, "DOUBLE")) {
            cost = 1000;
            roomTypeEnum = RoomType.DOUBLE;
            DataBase.rooms.add(new Room(roomNo, roomTypeEnum, false, cost));
            JOptionPane.showMessageDialog(null, "Room Added Successfully!");
        } else if (Objects.equals(roomType, "Suite") || Objects.equals(roomType, "suite") || Objects.equals(roomType, "SUITE")) {
            cost = 1500;
            roomTypeEnum = RoomType.SUITE;
            DataBase.rooms.add(new Room(roomNo, roomTypeEnum, false, cost));
            JOptionPane.showMessageDialog(null, "Room Added Successfully!");
        } else JOptionPane.showMessageDialog(null, "RoomType not valid!");
    }


    public static void deleteRoom(int Id) {
        DataBase.rooms.removeIf(room -> room.getRoomNo() == Id);
    }

    public static void updateRoomAvailability(int roomNo) {
        for (Room room : DataBase.rooms) {
            if (room.getRoomNo() == roomNo) {
                room.setOccupied(false);
            }
        }
    }


    public static void filterBusy(boolean state) {
        for (Room room : DataBase.rooms) {
            if (room.isOccupied() == state) {
                JOptionPane.showMessageDialog(null, room.toString(), "FreeRooms", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public static void filterBusyRoomType(boolean state, String roomType) {
        RoomType roomTypeEnum;

        if (Objects.equals(roomType, "Single") || Objects.equals(roomType, "single") || Objects.equals(roomType, "SINGLE")) {
            roomTypeEnum = RoomType.SINGLE;
            for (Room room : DataBase.rooms) {
                if (room.isOccupied() == state && Objects.equals(room.getRoomType(), roomTypeEnum)) {
                    JOptionPane.showMessageDialog(null, room.toString(), "FreeRoomsType", JOptionPane.PLAIN_MESSAGE);
                }
            }
        } else if (Objects.equals(roomType, "Double") || Objects.equals(roomType, "double") || Objects.equals(roomType, "DOUBLE")) {
            roomTypeEnum = RoomType.DOUBLE;
            for (Room room : DataBase.rooms) {
                if (room.isOccupied() == state && Objects.equals(room.getRoomType(), roomTypeEnum))
                    JOptionPane.showMessageDialog(null, room.toString(), "FreeRoomsType", JOptionPane.PLAIN_MESSAGE);
            }
        } else if (Objects.equals(roomType, "Suite") || Objects.equals(roomType, "suite") || Objects.equals(roomType, "SUITE")) {
            roomTypeEnum = RoomType.DOUBLE;
            for (Room room : DataBase.rooms) {
                if (room.isOccupied() == state && Objects.equals(room.getRoomType(), roomTypeEnum))
                    JOptionPane.showMessageDialog(null, room.toString(), "FreeRoomsType", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }


    public static boolean doesRoomExist(int roomNo) {
        boolean state = false;
        for (Room room : DataBase.rooms) {
            if (room.getRoomNo() == roomNo) {
                state = true;
                break;
            }
        }
        return state;
    }

}
