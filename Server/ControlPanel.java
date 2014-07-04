package Server;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ControlPanel extends Frame {

    ArrayList<Player> players;
    ArrayList<LivingObj> livingObjs;
    ArrayList<NoLifeObj> noLifeObjs;

    public ControlPanel() {
        setSize(200, 100);
        setVisible(true);
        setTitle("Control");

        //todo всё на фабрику
        players = new ArrayList<Player>();
        livingObjs = new ArrayList<LivingObj>();
        noLifeObjs = new ArrayList<NoLifeObj>();

        //неживой объект для теста
        NoLifeObj tree = new NoLifeObj(new Point(300,300),5, Color.blue, "tree", true );
        noLifeObjs.add(tree);

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