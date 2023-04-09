import javax.swing.*;
import java.awt.*;
public class Car {
    private int x,y;
    private Color color;
    private boolean move = true;

    Car(int x,int y,Color color){
        this.x=x;
        this.y=y;
        this.color=color;
    }


    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x,y,70,30);
    }
    public void start(){
        move = true;
    }

    public void stop(){
        move = false;
    }
    public void move(int getWidth){
        if(move){
            x+=1;
            if(x>=getWidth){
                x=0;
            }
        }
    }
//    public void move(int getWidth){
//        x+=1;
//        if(x>=getWidth){
//            x=0;
//        }
//    }
}