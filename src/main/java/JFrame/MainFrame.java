package JFrame;

import Methods.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainFrame extends JFrame {
    public MainFrame() {


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 3));

        ImageIcon imageIcon = new ImageIcon("hotel.jpg");
        JLabel imageLabel = new JLabel(imageIcon);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(imageLabel, BorderLayout.CENTER);

        add(panel);
        setTitle("The Continental");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setVisible(true);

        JButton[] buttons = new JButton[7];


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 7; i++) {
            buttons[i] = new JButton();
            buttons[i].setFocusable(false);
            buttons[i].setFont(new Font("", Font.BOLD, 20));
            this.setLayout(null);
            this.setSize(1920, 1080);
            this.setVisible(true);
            this.add(buttons[i]);
        }
        buttons[0].setText("Employee Management");
        buttons[0].setBounds(550, 100, 400, 50);
        buttons[1].setText("Guest Management");
        buttons[1].setBounds(550, 180, 400, 50);
        buttons[2].setText("Room Management");
        buttons[2].setBounds(550, 260, 400, 50);
        buttons[3].setText("Service Management");
        buttons[3].setBounds(550, 340, 400, 50);
        buttons[4].setText("Guest Billing Services");
        buttons[4].setBounds(550, 420, 400, 50);
        buttons[5].setText("Statistical Report");
        buttons[5].setBounds(550, 500, 400, 50);


        buttons[0].addActionListener(new Button1Listener());
        buttons[1].addActionListener(new Button2Listener());
        buttons[2].addActionListener(new Button3Listener());
        buttons[3].addActionListener(new Button4Listener());
        buttons[4].addActionListener(new Button5Listener());
        buttons[5].addActionListener(new StatisticalReportMethods.statisticalReport());


        add(mainPanel);

        setSize(1920, 1080);
        setVisible(true);
    }

    private class Button1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            JButton[] buttons = new JButton[8];

            JFrame button1Frame = new JFrame("Button 1 Window");
            JPanel button1Panel = new JPanel();
            button1Panel.setLayout(new GridLayout(5, 1));

            buttons[0] = new JButton("Add Employee");
            buttons[0].addActionListener(new EmployeeMethods.addEmployee());
            button1Panel.add(buttons[0]);
            buttons[1] = new JButton("Update Employee");
            buttons[1].addActionListener(new EmployeeMethods.updateEmployee());
            button1Panel.add(buttons[1]);
            buttons[2] = new JButton("Delete Employee");
            buttons[2].addActionListener(new EmployeeMethods.deleteEmployee());
            button1Panel.add(buttons[2]);
            buttons[3] = new JButton("Assign Guest Room");
            buttons[3].addActionListener(new EmployeeMethods.assignGuestRoom());
            button1Panel.add(buttons[3]);
            buttons[4] = new JButton("Assign Guest Services");
            buttons[4].addActionListener(new EmployeeMethods.assignGuestServices());
            button1Panel.add(buttons[4]);
            buttons[5] = new JButton("View Near Checkouts");
            buttons[5].addActionListener(new EmployeeMethods.viewNearCheckouts());
            button1Panel.add(buttons[5]);
            buttons[6] = new JButton("View Today's Checkouts");
            buttons[6].addActionListener(new EmployeeMethods.viewTodayCheckouts());
            button1Panel.add(buttons[6]);
            buttons[7] = new JButton("View All Employees");
            buttons[7].addActionListener(new EmployeeMethods.viewAllEmployees());
            button1Panel.add(buttons[7]);
            button1Frame.add(button1Panel);
            button1Frame.setSize(800, 1000);
            button1Frame.setVisible(true);
        }
    }

    private class Button2Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton[] buttons = new JButton[4];
            JFrame button2Frame = new JFrame("Button 2 Window");
            JPanel button2Panel = new JPanel();
            button2Panel.setLayout(new GridLayout(5, 1));

            buttons[0] = new JButton("Add Guest");
            buttons[0].addActionListener(new GuestMethods.addGuest());
            button2Panel.add(buttons[0]);
            buttons[1] = new JButton("Update Guest");
            buttons[1].addActionListener(new GuestMethods.updateGuest());
            button2Panel.add(buttons[1]);
            buttons[2] = new JButton("Delete Guest");
            buttons[2].addActionListener(new GuestMethods.deleteGuest());
            button2Panel.add(buttons[2]);
            buttons[3] = new JButton("View All Guests");
            buttons[3].addActionListener(new GuestMethods.viewAllGuests());
            button2Panel.add(buttons[3]);
            button2Frame.add(button2Panel);
            button2Frame.setSize(800, 1000);
            button2Frame.setVisible(true);
        }
    }


    private class Button3Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton[] buttons = new JButton[6];
            JFrame button3Frame = new JFrame("Button 3 Window");
            JPanel button3Panel = new JPanel();
            button3Panel.setLayout(new GridLayout(5, 1));

            buttons[0] = new JButton("Add Room");
            buttons[0].addActionListener(new RoomMethods.addRoom());
            button3Panel.add(buttons[0]);
            buttons[1] = new JButton("Update Availability");
            buttons[1].addActionListener(new RoomMethods.updateRoomAvailability());
            button3Panel.add(buttons[1]);
            buttons[2] = new JButton("Delete Room");
            buttons[2].addActionListener(new RoomMethods.DeleteRoom());
            button3Panel.add(buttons[2]);
            buttons[3] = new JButton("Filter Free Rooms");
            buttons[3].addActionListener(new RoomMethods.FilterBusy());
            button3Panel.add(buttons[3]);
            buttons[4] = new JButton("Filter Free Rooms and it's type");
            buttons[4].addActionListener(new RoomMethods.FilterBusyRoomType());
            button3Panel.add(buttons[4]);
            buttons[5] = new JButton("View All Rooms");
            buttons[5].addActionListener(new RoomMethods.ViewAllRooms());
            button3Panel.add(buttons[5]);
            button3Frame.add(button3Panel);
            button3Frame.setSize(1000, 800);
            button3Frame.setVisible(true);
        }
    }


    private class Button4Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton[] buttons = new JButton[3];
            // Create a new window with 5 buttons
            JFrame button4Frame = new JFrame("Button 4 Window");
            JPanel button4Panel = new JPanel();
            button4Panel.setLayout(new GridLayout(5, 1));

            buttons[0] = new JButton("Add Service");
            buttons[0].addActionListener(new ServiceMethods.addService());
            button4Panel.add(buttons[0]);
            buttons[1] = new JButton("Delete Service");
            buttons[1].addActionListener(new ServiceMethods.deleteService());
            button4Panel.add(buttons[1]);
            buttons[2] = new JButton("Update Service");
            buttons[2].addActionListener(new ServiceMethods.updateService());
            button4Panel.add(buttons[2]);
            button4Frame.add(button4Panel);
            button4Frame.setSize(1000, 800);
            button4Frame.setVisible(true);
        }
    }


    private class Button5Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton[] buttons = new JButton[3];
            // Create a new window with 5 buttons
            JFrame button5Frame = new JFrame("Button 5 Window");
            JPanel button5Panel = new JPanel();
            button5Panel.setLayout(new GridLayout(5, 1));

            buttons[0] = new JButton("View Reservation Cost");
            buttons[0].addActionListener(new GuestBillingMethods.reservationCost());
            button5Panel.add(buttons[0]);
            buttons[1] = new JButton("View Services Cost");
            buttons[1].addActionListener(new GuestBillingMethods.servicesCost());
            button5Panel.add(buttons[1]);
            buttons[2] = new JButton("Total Invoice");
            buttons[2].addActionListener(new GuestBillingMethods.invoice());
            button5Panel.add(buttons[2]);
            button5Frame.add(button5Panel);
            button5Frame.setSize(1000, 800);
            button5Frame.setVisible(true);
        }
    }

}