package Methods;

import Service.GuestBillingService;
import Service.GuestService;
import Service.ServiceService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class StatisticalReportMethods {
    public static class statisticalReport implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, ServiceService.getStatisticalReport().toString(),"Statistical Report", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
