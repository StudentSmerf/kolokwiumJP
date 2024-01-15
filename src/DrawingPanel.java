import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


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
                    int width = prevX - e.getX();
                    int height = prevY - e.getY();
                    currentRectangle.setBounds(e.getX(), e.getY(), width, height);
                    repaint();
                    DrawingController controller = new DrawingController( currentRectangle, menuPanel);
                    workers.add(controller);
                    //rectangles.add(currentRectangle);
                    currentRectangle = null;
                }

            }



        });

    }
    void startTimer(){
        ActionListener simulationClock = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (DrawingController worker : workers) {
                    worker.execute();
                }
            }
        };

        Timer simulationTimer = new Timer(1000, simulationClock);
        simulationTimer.setRepeats(true);
        simulationTimer.start();
    }





    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(rectangles != null){
            for (DrawingController worker : workers) {
                //Nie zwraca rectangle i nie mam czasu
                //Rectangle rectangle = worker.execute();
                //g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            }
        }

    }
}