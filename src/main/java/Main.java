import Data.DataBase;
import Model.*;
import Service.EmployeeService;
import Service.GuestService;
import Service.ServiceService;
import Service.RoomService;
import Service.GuestBillingService;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.*;
import java.awt.*;
import java.util.List;

import JFrame.MainFrame;

public class Main {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("Les Etoiles.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.start();


        new MainFrame();
    }
}
