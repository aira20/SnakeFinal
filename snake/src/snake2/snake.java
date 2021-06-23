package snake2;
//import javafx.scene.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class snake extends JFrame implements  KeyListener, ActionListener
{

     static String head;       //direction of head
     static int foodx;         //coordinates of x point of the food
     static int foody;         //coordinates of y point of the food

     static ArrayList<Integer>  arrayx;      //to store x point of the snake
     static ArrayList<Integer>  arrayy;     //to store y point of the snake
     Timer timer;
     int delay=10;                        //Speed of snake
     static algorithm obj=new algorithm();
    public snake()
    {
        head="";
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
        timer.start();
          arrayx = new ArrayList<Integer>();
        arrayy = new ArrayList<Integer>();
        foodx= (int) (Math.random()*90+5)*5; //why use 5? because the size of the snake is 5 if lower it  
        foody= (int) (Math.random()*90+5)*5; //will not be able to eat the food of more snake will not come close to the food
      

        for (int i = 0; i < 10; i++) {
            arrayx.add(250-5*i);

        }
        for (int i = 0; i < 10; i++)
        {
            arrayy.add(250);
        }


    }


    public static void main(String args[])
    {

        snake jf=new snake();
        JFrame j=new JFrame();
        jf.setTitle("Snake game");
        jf.setVisible(true);

        jf.setSize(500,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
        @Override
    public void paint(Graphics g)
    {
        head=obj.a_star(arrayx, arrayy, foodx, foody);                  //takes the next direction for snake from A* algorithm class
        g.setColor(Color.BLACK);                                        //Colour of background
        g.fillRect(0,0,500,500);
        if(arrayx.get(0)==foodx && arrayy.get(0)==foody) {
            foodx= (int) (Math.random()*90+5)*5;                        //code ini di gunakan untuk setiap kali snakenya makan maka akan randomize makanan baru 
            foody=(int) (Math.random()*90+5)*5;
            System.out.println(foodx+" "+foody);

            arrayy.add(arrayy.get(arrayy.size()-1));                    //menambahkan index supaya size snake akan membesar
            arrayx.add(arrayx.get(arrayx.size()-1));

        }

        for(int i=0;i<arrayx.size();i++) //Paint snake
        {

            g.setColor(Color.white);
            g.fillRect(arrayx.get(i),arrayy.get(i), 5, 5);
        }



        g.fillRect(foodx,foody,5,5); //food colour


    }



    public void keyTyped(KeyEvent k) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }


    public void keyReleased(KeyEvent k) {

    }




    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(head.equals("right"))
        {
            for (int i = arrayx.size() - 1; i >= 1; i--)
            {

                arrayx.set(i, arrayx.get(i - 1));
            }
            for (int i = arrayy.size() - 1; i >= 1; i--)
            {
                arrayy.set(i, arrayy.get(i - 1));
            }
            //head of the snake

            arrayx.set(0, arrayx.get(0) + 5);
            repaint();

        }
        if(head.equals("left"))
        {
            for (int i = arrayx.size() - 1; i >= 1; i--) {

                arrayx.set(i, arrayx.get(i - 1));
            }
            for (int i = arrayy.size() - 1; i >= 1; i--) {
                arrayy.set(i, arrayy.get(i - 1));
            }
            //head of the snake

            arrayx.set(0, arrayx.get(0) - 5);
            repaint();

        }
        if(head.equals("up"))
        {
            for(int i=arrayx.size()-1;i>=1;i--) {

                arrayx.set(i,arrayx.get(i-1));
            }
            for(int i=arrayy.size()-1;i>=1;i--)
            {
                arrayy.set(i,arrayy.get(i-1));
            }
            //head of the snake

            arrayy.set(0,arrayy.get(0)-5);
            repaint();

        }
        if(head.equals("down"))
        {
            for(int i=arrayx.size()-1;i>=1;i--) {

                arrayx.set(i,arrayx.get(i-1));
            }
            for(int i=arrayy.size()-1;i>=1;i--)
            {
                arrayy.set(i,arrayy.get(i-1));
            }
            //head of the snake

            arrayy.set(0,arrayy.get(0)+5);
            repaint();

        }

    }
}