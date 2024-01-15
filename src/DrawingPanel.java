import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class DrawingPanel extends JPanel {
    private ArrayList<Rectangle> rectangles;
    private Rectangle currentRectangle;

    private int prevX, prevY;
    public DrawingPanel() {

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
                    int width = prevX - e.getX();
                    int height = prevY - e.getY();
                    currentRectangle.setBounds(e.getX(), e.getY(), width, height);
                    repaint();
                    rectangles.add(currentRectangle);
                    currentRectangle = null;
                }

            }



        });

    }


    int deltaY = 0, deltaX = 0;
    public void moveRectangle(MenuPanel.option option) {

        switch (option){
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
        if(rectangles != null){
            for (Rectangle rectangle : rectangles) {
                rectangle.setBounds(rectangle.x + deltaX, rectangle.y + deltaY, rectangle.width, rectangle.height);
            }
        }
        repaint();
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