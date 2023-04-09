import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter extends JFrame {
    private JLabel label;
    private int counting=1;
    private JButton increase;
    private JButton decrease;
    Counter(){
        setLayout(new BorderLayout());
        setTitle("Counter App");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        label=new JLabel("Count: "+counting);
        label.setFont(new Font("Arial", Font.PLAIN, 24));
        add(label,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

        increase=new JButton("Increase");
        increase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counting++;
                label.setText("Count: "+counting);
            }
        });
        buttonPanel.add(increase);

        decrease=new JButton("Decrease");
        decrease.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counting--;
                label.setText("Count: "+counting);
            }
        });
        buttonPanel.add(decrease);

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
}
