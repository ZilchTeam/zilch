package Client;

import ISend.ISend;
import Server.BaseClass;
import Server.Player;
import engine.GameCanvas;
import engine.Input;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.rmi.RemoteException;
import java.util.ArrayList;

class Scene extends GameCanvas {
    private Image   banan = new ImageIcon("ban.png").getImage(),
                    img = new ImageIcon("arrow.png").getImage();
    private ArrayList<BaseClass> visibleObj;
    private AffineTransform at;
    private double Angle;
    private BufferedImage original_img,
            rotated_img;
    private AffineTransformOp atOp;
    private int     h = img.getHeight(null),
                    w = img.getWidth(null);
    private ISend send;
    public Scene(ISend send) {
        this.send = send;
        setSize(100, 100);

        original_img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics g2 =  original_img.createGraphics();
        g2.drawImage(img, 0, 0, null);
        g2.dispose(); //освобождает все системные ресурсы, что использует
        rotated_img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

    }

    @Override
    public void update(float elapsedTime) throws RemoteException {
        //отправить на сервер список нажатых клавиш + идентификатор игрока
        try {
            send.setPressedKeys(Input.getPressedKeys(), App.id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        //обновить список объектов для отрисовки на карте(пока только объекты игроков)
        try {
            visibleObj = send.getList();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g, float elapsedTime) {	// Рисовалка тут.

        //отрисовать все объекты(пока только игроки)
        for (int i = 0; i < visibleObj.size(); i++) {
            BaseClass obj = visibleObj.get(i);

            //определяем угол на который нужно повернуть изображение в радианах
            Angle = Math.PI-Math.atan2((obj.getX()-Input.getMousePosition().x),(obj.getY()-Input.getMousePosition().y));
            at = new AffineTransform();
            at.setToRotation(Angle, w/2, h/2); //поворачиваем изображение и смещаем на половину по X и Y ,для того чтобы осью вращения был центр изображения
            atOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            atOp.filter(original_img, rotated_img);

            g.setColor(obj.getColor());
            //над игроками ники
            if (obj.getName() != null ) {
                g.drawString(obj.getName(), obj.getX(), obj.getY());
                g.drawImage(rotated_img, obj.getX(), obj.getY(), null);
            }
            else {
                g.drawString("no life", obj.getX(), obj.getY());
                g.drawImage(banan, obj.getX(), obj.getY(), null);
            }
            g.setColor(Color.white);
        }

    }
}