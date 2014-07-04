package Client;

import ISend.ISend;
import engine.GameFrame;
import engine.Input;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class App {

    public static int id = 0;

    public ISend send;
    private Input input = new Input();
    private TextField textFieldLogin, textFieldConnect, textFieldRegister;
    private boolean log = false;
    private String ip;

    public App() {

        Connect();//вспомогательное окно получающее ip для подключиния

        //серверная часть
        try {
            // fire to localhost port 1099
            Registry myRegistry = LocateRegistry.getRegistry(ip, 1099);
            // search for myMessage service
            send = (ISend) myRegistry.lookup("myMessage");
            //send.addPlayer();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Login();//вспомогательное окно регистрирующее или логирующее пользователя

        GameFrame app = GameFrame.getInstance();	// Форма делается так а не через конструктор.
        app.setSize(600, 600);
        app.setTitle("Client");
        Scene scene = new Scene(send);          // Своя сцена.
        app.begin(scene);					// Скармливаем сцену.
        scene.addKeyListener(input);		//подпись на события мыши и клавы
        scene.addMouseListener(input);
        scene.addMouseMotionListener(input);
    }

    public void Login() {
        final Frame loginFrame = new Frame();
        loginFrame.setLayout(null);
        loginFrame.setSize(250, 220);
        loginFrame.setTitle("Введите ваш ID для логина или Ник для регистрации");
        loginFrame.setVisible(true);

        textFieldLogin = new TextField("введите ваш ID для логина");
        textFieldLogin.setLocation(10, 40);
        textFieldLogin.setSize(210, 40);
        textFieldLogin.setVisible(true);

        Button butLog = new Button("Login");
        butLog.setLocation(20, 90);
        butLog.setBackground(Color.ORANGE);
        butLog.setSize(80, 20);
        butLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aE) {
                id = Integer.parseInt(textFieldLogin.getText());
                log = true;
                loginFrame.dispose();
            }
        });

        textFieldRegister = new TextField("введите ваш Ник для регистрации");
        textFieldRegister.setLocation(10, 120);
        textFieldRegister.setSize(210, 40);
        textFieldRegister.setVisible(true);

        Button butCreate = new Button("Create");
        butCreate.setLocation(20, 170);
        butCreate.setBackground(Color.ORANGE);
        butCreate.setSize(80, 20);
        butCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aE) {
                try {
                    id = send.addPlayer(textFieldRegister.getText());
                    log = true;
                    loginFrame.dispose();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        loginFrame.add(butLog);
        loginFrame.add(butCreate);
        loginFrame.add(textFieldLogin);
        loginFrame.add(textFieldRegister);

        while(!log){ //кост ыль
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log = !log;
    }

    public void Connect() {
        final Frame connectFrame = new Frame();
        connectFrame.setLayout(null);
        connectFrame.setSize(200, 180);
        connectFrame.setTitle("Введите IP сервера");
        connectFrame.setVisible(true);

        textFieldConnect = new TextField("127.0.0.1");
        textFieldConnect.setLocation(10, 40);
        textFieldConnect.setSize(180, 50);
        textFieldConnect.setVisible(true);

        Button butConnect = new Button("Connect");
        butConnect.setLocation(20, 110);
        butConnect.setBackground(Color.GREEN);
        butConnect.setSize(80, 20);
        butConnect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aE) {
                ip = textFieldConnect.getText();
                log = true;
                connectFrame.dispose();
            }
        });

        connectFrame.add(butConnect);
        connectFrame.add(textFieldConnect);

        while(!log){ //костыль
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log = !log;
    }

    public static void main(String[] args){
        new App();
    }
}

