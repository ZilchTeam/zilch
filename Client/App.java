package Client;

import ISend.ISend;
import engine.GameFrame;
import engine.Input;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class App {

    Input input = new Input();
    private ISend send;

    public App() {
        //серверная часть
        try {
            // fire to localhost port 1099
            Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            // search for myMessage service
            send = (ISend) myRegistry.lookup("myMessage");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        GameFrame app = GameFrame.getInstance();	// Форма делается так а не через конструктор.
        app.setSize(600, 600);
        Scene scene = new Scene(send);          // Своя сцена.
        app.begin(scene);					// Скармливаем сцену.
        scene.addKeyListener(input);		//подпись на события мыши и клавы
        scene.addMouseListener(input);
        scene.addMouseMotionListener(input);
    }

    public static void main(String[] args){
        new App();
    }
}

