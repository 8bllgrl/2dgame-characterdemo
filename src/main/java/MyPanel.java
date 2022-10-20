import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class MyPanel extends JPanel {

    int rectwid, recthei;
    BufferedImage image;

    MyPanel() {

        importImage();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        Color ffxivBlue = new Color(0, 63, 229);
        Color ffxivDark = new Color(11, 18, 59);
        drawUIMethod(g2);

        g2.dispose();
    }

    private void drawUIMethod(Graphics2D g2) {
        Color ffxivBlue = new Color(0, 63, 229);
        Color ffxivDark = new Color(11, 18, 59);

        ////////////////////////////////
        //VERTICAL BOX

        int wid2;
        int hei2;
        int xpos;
        int ypos;

        wid2 = 150;
        hei2 = 100;
        xpos = 30;
        ypos = 150;

        GradientPaint gradientPaint2 = new GradientPaint(0, hei2 + ypos, ffxivDark, 0, ypos, ffxivBlue);

        g2.setPaint(gradientPaint2);
        g2.fillRect(xpos, ypos, wid2, hei2);

        //////////////////////////////
//
        rectwid = 360;
        recthei = 430;
        g2.setColor(Color.darkGray);
        g2.fillRect(190, 90, rectwid, recthei);

        rectwid = 200;
        recthei = 460;
        xpos = 0;
        ypos = 90;
        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(0, 80, rectwid, recthei);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.gray);
        g2.drawRect(2, 80, rectwid, recthei);


        rectwid = 430;
        recthei = 460;
        xpos = 950;
        ypos = 80;
        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect((xpos) - rectwid, ypos, rectwid, recthei);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.gray);
        g2.drawRect((xpos) - rectwid, ypos, rectwid - 19, recthei);

//
        rectwid = 950;
        recthei = 110;
        xpos = 0;
        ypos = 0;
        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(0, 0, rectwid, recthei);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.gray);
        g2.drawRect(2, 2, rectwid - 20, recthei - 2);
//

        rectwid = 950;
        recthei = 250;
        xpos = 0;
        ypos = 740 - recthei;
        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(0, (ypos), rectwid, recthei);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.gray);
        g2.drawRect(2, ypos, rectwid - 20, recthei - 42);

        g2.drawImage(image, 240, 120, image.getWidth() / 2, image.getHeight() / 2, null);

        ////////////////////////////////////////////////

        //buttons on top.


        ////NAME BOX
        rectwid = 165;
        recthei = 45;
        xpos = 15;
        ypos = 20;
        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(xpos, (ypos), rectwid, recthei);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.lightGray);
        g2.drawRect(xpos, ypos, rectwid, recthei);


        ////GENDER
        rectwid = 165;
        recthei = 45;
        ypos = 130;
        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(xpos, (ypos), rectwid, recthei);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.lightGray);
        g2.drawRect(xpos, ypos, rectwid, recthei);


        ////VOICE

        rectwid = 100;
        recthei = 45;
        ypos = 265;
        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(xpos, (ypos), rectwid, recthei);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.lightGray);
        g2.drawRect(xpos, ypos, rectwid, recthei);

        ////AGE

        rectwid = 100;
        recthei = 45;
        ypos = 365;
        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(xpos, (ypos), rectwid, recthei);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.lightGray);
        g2.drawRect(xpos, ypos, rectwid, recthei);


        ////APPEARANCE

        rectwid = 215;
        recthei = 45;
        xpos = 480;
        ypos = 20;
        gradientPaint2 = new GradientPaint(0, recthei + ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(xpos, (ypos), rectwid, recthei);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.lightGray);
        g2.drawRect(xpos, ypos, rectwid, recthei);


        //DISPLAY BOXES.

        g2.setColor(Color.black);

        //NAME
        g2.fillRect(17, 65, 200, 45);
        g2.fillRect(225, 65, 200, 45);


        //GENDER
        //buffered images

        //VOICE
        g2.fillRect(75, 315, 70, 45);
        //AGE
        g2.fillRect(75, 415, 70, 45);
        //APPEARANCE
        g2.fillRect(550, 65, 70, 45);


    }

    private void importImage() {
        InputStream inputStream = getClass().getResourceAsStream("/hda-f.png");

        try {
            image = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
