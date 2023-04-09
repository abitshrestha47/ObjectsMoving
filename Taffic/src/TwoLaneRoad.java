import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class TwoLaneRoad extends JPanel implements ComponentListener,ActionListener,Runnable{
    private int roadWidth,roadLength;
    private Color roadColor=Color.GRAY;
    private TrafficLight traffic;
    private TrafficLight traffic2;
    private Car car;
    private Car car1;
    private int laneWidth=20;
    private Color laneColor=Color.WHITE;
    private int spaceBetweenLanes=50;
    private int getWidth;
    private Timer timer;
    private Thread carThread1;
    private Thread carThread2;
    TwoLaneRoad(int width,int length){
        setLayout(null);
        roadWidth=width;
        roadLength=length;

        car=new Car(20,(roadLength-30)/4,Color.WHITE);
        car1=new Car(20,(roadLength-30)/4+200,Color.WHITE);

        traffic=new TrafficLight(730,60,Color.RED);
        traffic2=new TrafficLight(730,280,Color.GREEN);
        add(traffic);
        add(traffic2);

        carThread1 = new Thread(this, "carThread1");
        carThread2 = new Thread(this, "carThread2");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(roadColor);
        g.fillRect(0,0,roadWidth,roadLength);

        g.setColor(laneColor);
        g.fillRect(0,(roadLength-30)/2,roadWidth,laneWidth);

        g.setColor(laneColor);
        g.fillRect(0, (roadLength-30 + spaceBetweenLanes) / 2, roadWidth, laneWidth);

        g.setColor(Color.WHITE);
        g.fillRect(700, 0, 5, roadLength);

        car.draw(g);
        car1.draw(g);

        car.move(getWidth=800);
        car1.move(getWidth=800);
        repaint();
    }

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {
        getWidth=getWidth();
    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void start() {
        carThread1.start();
        carThread2.start();
    }

    @Override
    public void run() {
//        System.out.println("Thread started: " + Thread.currentThread().getName());
        while (true) {
//            System.out.println("Thread started: " + Thread.currentThread().getName());
            if (Thread.currentThread() == carThread1) {
                if (traffic.getStatus() == Color.RED) {
                    car.stop();
                } else {
                    car.start();
                }
                if(traffic2.getStatus()==Color.RED){
                    car1.stop();
                }
                else{
                    car1.start();
                }
            }
//            if (Thread.currentThread() == carThread2) {
//                if (traffic2.getStatus() == Color.RED) {
//                    System.out.println("fdfdf");
//                    car1.stop();
//                } else {
//                    car1.start();
//                }
//            }
//                if (traffic.getStatus() == Color.RED) {
//                    car.stop();
//                } else {
//                    car.start();
//                }
//
//                if (traffic2.getStatus() == Color.RED) {
//                    car1.stop();
//                } else {
//                    car1.start();
//                }
        }
    }
}