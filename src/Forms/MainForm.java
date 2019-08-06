
/*
 *
 *  Copyright (C) 2019.  PSEU - Palestine Polytechnic University - All Rights Reserved
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

/*
 * Created by Basel.Altamimi on 8/4/2019.
 */

package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private static int calender1=0;
    private int calender2;

    public MainForm() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application on JForm exit
        this.setTitle("Main Form");
        this.setSize(600, 200);
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.setVisible(true);

        JButton b1 = new JButton("Show Calender 1"); // Button 1 (Create Calender 1)
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                showNewCalender();
            }
        });

        JButton b2 = new JButton("Show Calender 2"); // Button 2 (Create Calender 2)
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                showNewCalender();
            }
        });


        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel.add(b1);
        panel.add(b2);

        this.add(panel);
    }

    /**
     * Create and show new calender object
     * Todo: This method logs the object HashCode in a text file, after refactoring the code; show warning message if the HashCode of Calender1 doesn't equal Calender2 HashCode
     */
    private void showNewCalender() {
        SwingCalendar sc = SwingCalendar.getInstance();
        sc.setVisible(true);
        Util.Logger.log("Object HC: " + sc.hashCode()); // Log Calender hash code


        //this code is for testing the calenders objects hash
        calender2= sc.hashCode();
        if(MainForm.calender1==0)
            MainForm.calender1=calender2;
        else
        {
            if( MainForm.calender1!=calender2)
                JOptionPane.showMessageDialog(null, "calenders objects dont have the same HASH" , "warning", JOptionPane.PLAIN_MESSAGE);
        };

    }


}
