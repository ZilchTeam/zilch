package Server;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControlPanel extends Frame {
    public ControlPanel() {
        setSize(200, 100);
        setVisible(true);
        setTitle("Control");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void paint (Graphics g)
    {
        g.drawString("Сервак короч",50,60);
    }

}