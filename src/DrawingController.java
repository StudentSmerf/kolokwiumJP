import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class DrawingController extends SwingWorker<Rectangle, Void> {
    private MenuPanel menu;

    private Rectangle rectangle;
    public DrawingController(Rectangle rectangle, MenuPanel menu){
        this.rectangle = rectangle;
        this.menu = menu;
        StartMoving();
    }
    void StartMoving(){

    }

    @Override
    public Rectangle doInBackground() throws IOException {
        int deltaY = 0, deltaX = 0;
        try {
            switch (MenuPanel.currentOption){
                case dol -> {
                    deltaY = -5;
                    deltaX = 0;
                }
                case gora -> {
                    deltaY = +5;
                    deltaX = 0;
                }
                case lewo -> {
                    deltaX = -5;
                    deltaY = 0;
                }
                case prawo -> {
                    deltaX = 5;
                    deltaY = 0;
                }
            }
            rectangle.setBounds(rectangle.x + deltaX, rectangle.y + deltaY, rectangle.width, rectangle.height);

        } catch (Exception e) {
            System.out.println(e);
        }
        return rectangle;
    }


}