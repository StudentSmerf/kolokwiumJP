import javax.swing.*;
import java.awt.*;


class DrawingApp extends JFrame{
    public DrawingApp(){
        setTitle("Drawing App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuPanel menuPanel = new MenuPanel();
        DrawingPanel drawingPanel = new DrawingPanel();
        drawingPanel.setFocusable(true);

        DrawingController controller = new DrawingController(drawingPanel);

        setLayout(new BorderLayout());
        add(menuPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);


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


//MenuPanel.currentOption == MenuPanel.option.drawRect



