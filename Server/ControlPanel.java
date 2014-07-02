package Server;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ControlPanel extends Frame {

    ArrayList<Player> players;
    Player player1;//для теста короче
    Player player2;

    public ControlPanel() {
        setSize(200, 100);
        setVisible(true);
        setTitle("Control");
        //тестовая часть
        players = new ArrayList<Player>();
        player1 = new Player(new Point(100,100),1,Color.black,"lol",true,1);
        players.add(0,player1);
        player2 = new Player(new Point(50,50), 2, Color.black, "triangle", true, 2);
        players.add(1,player2);

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