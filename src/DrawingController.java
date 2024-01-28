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
            System.out.println(rectangle.x + " " + rectangle.y);
            switch (MenuPanel.currentOption){
                case dol -> {
                    if(menu.getWindowSize().height - 80 > rectangle.y + rectangle.height){
                        deltaY = +1;

                    }

                }
                case gora -> {
                    if(10 < rectangle.y - 1) {
                        deltaY = -1;

                    }
                }
                case lewo -> {
                    if(10 < rectangle.x - 1) {
                        deltaX = -1;

                    }
                }
                case prawo -> {
                    if(menu.getWindowSize().width - 50 > rectangle.x + rectangle.width) {
                        deltaX = 1;

                    }
                }
            }
            rectangle.setBounds(rectangle.x + deltaX, rectangle.y + deltaY, rectangle.width, rectangle.height);

        } catch (Exception e) {
            System.out.println(e);
        }
        return rectangle;
    }
    public Rectangle GetRect(){
        return rectangle;
    }


}