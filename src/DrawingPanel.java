import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.min;


public class DrawingPanel extends JPanel {
    private ArrayList<Rectangle> rectangles;
    private ArrayList<DrawingController> workers;
    private Rectangle currentRectangle;
    private MenuPanel menuPanel;

    private int prevX, prevY;
    public DrawingPanel(MenuPanel menu) {
        menuPanel = menu;
        workers = new ArrayList<>();
        currentRectangle = new Rectangle();
        rectangles = new ArrayList<>();
        setBackground(Color.white);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(currentRectangle == null) {
                    prevX = e.getX();
                    prevY = e.getY();
                    currentRectangle = new Rectangle(e.getX(), e.getY(), 0, 0);

                }
                else {
                    int width = abs(prevX - e.getX());
                    int height = abs(prevY - e.getY());
                    int x = min(prevX , e.getX());
                    int y = min(prevY , e.getY());
                    currentRectangle.setBounds(x, y, width, height);
                    repaint();
                    rectangles.add(currentRectangle);
                    currentRectangle = null;
                }

            }



        });

    }
    void startTimer(){
        ActionListener simulationClock = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < rectangles.size(); i++) {
                    DrawingController controller = new DrawingController(rectangles.get(i), menuPanel);
                    controller.execute();
                    if(controller.GetRect() != null){
                        rectangles.set(i, controller.GetRect());
                    }
                    repaint();
                }
            }
        };

        Timer simulationTimer = new Timer(200, simulationClock);
        simulationTimer.setRepeats(true);
        simulationTimer.start();
    }





    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(rectangles != null){
            for (Rectangle rectangle : rectangles) {
                g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            }
        }

    }
}