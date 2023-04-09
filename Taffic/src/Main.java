import javax.swing.*;
import java.awt.*;
public class Main{
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setResizable(false);
        TwoLaneRoad t=new TwoLaneRoad(800,400);
        frame.add(t);
        t.start();
        frame.setVisible(true);
    }
}