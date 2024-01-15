import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel{
    public enum option{
        dol, gora, lewo, prawo;
    }
    public static option currentOption;
    public MenuPanel(){
        JButton dolButton = new JButton("Dół");
        JButton goraButton = new JButton("Góra");
        JButton lewoButton = new JButton("Lewo");
        JButton prawoButton = new JButton("Prawo");

        add(dolButton);
        add(goraButton);
        add(lewoButton);
        add(prawoButton);

        dolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentOption = option.dol;

            }
        });
        goraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentOption = option.gora;

            }
        });
        lewoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentOption = option.lewo;

            }
        });
        prawoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentOption = option.prawo;

            }
        });

    }

}
