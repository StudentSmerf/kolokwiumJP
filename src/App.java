import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


class DrawingApp extends JFrame{
    public DrawingApp(){
        setTitle("Drawing App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuPanel menuPanel = new MenuPanel();
        DrawingPanel drawingPanel = new DrawingPanel(menuPanel);
        drawingPanel.startTimer();
        drawingPanel.setFocusable(true);



        setLayout(new BorderLayout());
        add(menuPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                menuPanel.setWindowSize(e.getComponent().getSize());
                System.out.println("Resized to " + e.getComponent().getSize());
            }
        });


        setVisible(true);
    }
}




public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DrawingApp();
            }
        });
    }
}



