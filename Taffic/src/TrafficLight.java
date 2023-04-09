import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLight extends JPanel implements ActionListener {
    private Color color;
    private Timer timer;
    private Color trafficColor=Color.GRAY;
    TrafficLight(int x,int y,Color color){
        this.trafficColor=color;
        setBounds(x,y,50,100);
        setBackground(Color.BLACK);

        timer=new Timer(5000,this);
        timer.start();
    }
    public Color getStatus(){
        return trafficColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(trafficColor);
        g.fillOval(15, 40, 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (trafficColor == Color.GRAY) {
            trafficColor = Color.RED;
        } else if (trafficColor == Color.RED) {
            trafficColor = Color.YELLOW;
        } else if (trafficColor == Color.YELLOW) {
            trafficColor = Color.GREEN;
        } else if (trafficColor == Color.GREEN) {
            trafficColor = Color.GRAY;
        }

        repaint();
    }
}
