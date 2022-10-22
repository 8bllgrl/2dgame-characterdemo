package test;

import java.awt.*;
import java.util.Scanner;

public class GetSetTester {

    static int age = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userinput = " ";
        while (!userinput.equals("quit")){
            userinput = scanner.nextLine();
            if(userinput.equals("<")){
                setAgePrevious();
                System.out.println();
            } else if (userinput.equals(">") ){
                setAgeNext();
                System.out.println();
            }

            System.out.println(age);
        }


    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        GetSetTester.age = age;
    }

    public static void setAgeNext(){
        age = getAge();
        age++;
        if (age>70){
            age = 70;
        }
    }
    public static void setAgePrevious(){
        age = getAge();
        age--;
        if (age <=0){
            age = 1;
        }
    }

    private void drawUI(Graphics2D g2) {
//        Color ffxivBlue = new Color(0, 63, 229);
//        Color ffxivDark = new Color(11, 18, 59);
//        ////////////////////////////////
//        //VERTICAL BOX
//
//        int wid2;
//        int hei2;
//        int xpos;
//        int ypos;
//
//        wid2 = 150;
//        hei2 = 100;
//        xpos = 30;
//        ypos = 150;



//rectwid = 430;
//        recthei = 460;
//        xpos = 950;
//        ypos = 80;
//        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
//        g2.setPaint(gradientPaint2);
//        g2.fillRect((xpos) - rectwid, ypos, rectwid, recthei);
//        g2.setStroke(new BasicStroke(5));
//        g2.setColor(Color.gray);
//        g2.drawRect((xpos) - rectwid, ypos, rectwid - 19, recthei);


        //950,80,430,460
//        GradientPaint gradientPaint2 = new GradientPaint(0, hei2 + ypos, ffxivDark, 0, ypos, ffxivBlue);
//
//        g2.setPaint(gradientPaint2);
//        g2.fillRect(xpos, ypos, wid2, hei2);
//
//        //////////////////////////////
////
//        rectwid = 360;
//        recthei = 430;
//        g2.setColor(Color.darkGray);
//        g2.fillRect(190, 90, rectwid, recthei);
//
//        rectwid = 200;
//        recthei = 460;
//        xpos = 0;
//        ypos = 90;
//        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
//        g2.setPaint(gradientPaint2);
//        g2.fillRect(0, 80, rectwid, recthei);
//        g2.setStroke(new BasicStroke(5));
//        g2.setColor(Color.gray);
//        g2.drawRect(2, 80, rectwid, recthei);
//
//
//        rectwid = 430;
//        recthei = 460;
//        xpos = 950;
//        ypos = 80;
//        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
//        g2.setPaint(gradientPaint2);
//        g2.fillRect((xpos) - rectwid, ypos, rectwid, recthei);
//        g2.setStroke(new BasicStroke(5));
//        g2.setColor(Color.gray);
//        g2.drawRect((xpos) - rectwid, ypos, rectwid - 19, recthei);
//
////
//        rectwid = 950;
//        recthei = 110;
//        xpos = 0;
//        ypos = 0;
//        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
//        g2.setPaint(gradientPaint2);
//        g2.fillRect(0, 0, rectwid, recthei);
//        g2.setStroke(new BasicStroke(5));
//        g2.setColor(Color.gray);
//        g2.drawRect(2, 2, rectwid - 20, recthei - 2);
////
//
//        rectwid = 950;
//        recthei = 250;
//        xpos = 0;
//        ypos = 740 - recthei;
//        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
//        g2.setPaint(gradientPaint2);
//        g2.fillRect(0, (ypos), rectwid, recthei);
//        g2.setStroke(new BasicStroke(5));
//        g2.setColor(Color.gray);
//        g2.drawRect(2, ypos, rectwid - 20, recthei - 42);
//
//        ////////////////////////////////////////////////
//
//        //buttons on top.
//
//
//        ////NAME BOX
//        rectwid = 165;
//        recthei = 45;
//        xpos = 15;
//        ypos = 20;
//        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
//        g2.setPaint(gradientPaint2);
//        g2.fillRect(xpos, (ypos), rectwid, recthei);
//        g2.setStroke(new BasicStroke(3));
//        g2.setColor(Color.lightGray);
//        g2.drawRect(xpos, ypos, rectwid, recthei);
//
//
//        ////GENDER
//        rectwid = 165;
//        recthei = 45;
//        ypos = 130;
//        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
//        g2.setPaint(gradientPaint2);
//        g2.fillRect(xpos, (ypos), rectwid, recthei);
//        g2.setStroke(new BasicStroke(3));
//        g2.setColor(Color.lightGray);
//        g2.drawRect(xpos, ypos, rectwid, recthei);
//
//
//        ////VOICE
//
//        rectwid = 100;
//        recthei = 45;
//        ypos = 265;
//        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
//        g2.setPaint(gradientPaint2);
//        g2.fillRect(xpos, (ypos), rectwid, recthei);
//        g2.setStroke(new BasicStroke(3));
//        g2.setColor(Color.lightGray);
//        g2.drawRect(xpos, ypos, rectwid, recthei);
//
//        ////AGE
//
//        rectwid = 100;
//        recthei = 45;
//        ypos = 365;
//        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
//        g2.setPaint(gradientPaint2);
//        g2.fillRect(xpos, (ypos), rectwid, recthei);
//        g2.setStroke(new BasicStroke(3));
//        g2.setColor(Color.lightGray);
//        g2.drawRect(xpos, ypos, rectwid, recthei);
//
//
//        ////APPEARANCE
//
//        rectwid = 215;
//        recthei = 45;
//        xpos = 480;
//        ypos = 20;
//        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
//        g2.setPaint(gradientPaint2);
//        g2.fillRect(xpos, (ypos), rectwid, recthei);
//        g2.setStroke(new BasicStroke(3));
//        g2.setColor(Color.lightGray);
//        g2.drawRect(xpos, ypos, rectwid, recthei);
//
//
//        //DISPLAY BOXES.
//
//        g2.setColor(Color.black);
//
//        //NAME
//        g2.fillRect(17, 65, 200, 45);
//        g2.fillRect(225, 65, 200, 45);
//
//
//        //GENDER
//        //buffered images
//
//        //VOICE
//        g2.fillRect(75, 315, 70, 45);
//        //AGE
//        g2.fillRect(75, 415, 70, 45);
//        //APPEARANCE
//        g2.fillRect(550, 65, 70, 45);


    }
}
