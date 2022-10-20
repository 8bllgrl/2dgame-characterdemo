import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class MyPanel extends JPanel implements Runnable{

    int rectwid, recthei;
    BufferedImage hdatih;
    BufferedImage basicMiqo;
    private int frames =0 ;
    private long lastCheck = 0;
    Thread gameThread;
    int FPS = 60;

    private int animationTick, animationIndex;
    private int animationSpeed = 15;

    private BufferedImage[] walkAnimation;

    MyPanel() {

        importImage();
        loadAnimations();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);



        Graphics2D g2 = (Graphics2D) g;

        drawUI(g2);

        //h'datih
//        g2.drawImage(image,240,120, image.getWidth()/2,image.getHeight()/2,null);
        BufferedImage subimageMqi = basicMiqo.getSubimage(0, 0, 400, 500);
//        g2.drawImage(subimageMqi,200,100, 350,450,null);


        g2.setFont(new Font("Sitka Text", Font.ITALIC, 32));
        g2.setColor(Color.white);

        //First Name Button
        g2.drawString("Name",55,55);
        //First Name
        g2.drawString("Sun Miqo'te",25,100);

        //Last Name
        g2.drawString("Tia",300,100);

        updateAnimationTick();
        g2.drawImage(walkAnimation[animationIndex],215,90, 315,415,null);



        //////////////

        frames++;
        if (System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames =0;
        }

        g2.dispose();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void run(){

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime-lastTime)/ drawInterval;

            lastTime= currentTime;

            if (delta >=1){
                repaint();
                delta--;
            }
        }

    }

    private void loadAnimations(){
        walkAnimation = new BufferedImage[5];

        for (int i = 0; i < walkAnimation.length; i++) {
            walkAnimation[i] = basicMiqo.getSubimage(i*400, 0, 400, 500);
            
        }

    }

    public void updateAnimationTick(){

        animationTick++;
        if(animationTick >= animationSpeed){
            animationTick = 0;
            animationIndex++;
            //this resets it back to the far left side of the animation if it reaches the end of the array!
            if (animationIndex >= walkAnimation.length){
                animationIndex = 0;
            }
        }

    }

    public void update(){

    }


    private void drawUI(Graphics2D g2){
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

        GradientPaint gradientPaint2 = new GradientPaint(0, hei2+ypos, ffxivDark, 0, ypos, ffxivBlue);

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
        gradientPaint2 = new GradientPaint(0, recthei+ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(0, 80, rectwid, recthei);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.gray);
        g2.drawRect(2, 80, rectwid, recthei);


        rectwid = 430;
        recthei = 460;
        xpos = 950;
        ypos = 80;
        gradientPaint2 = new GradientPaint(0, recthei+ypos, ffxivDark, 0, ypos, ffxivBlue);
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
        gradientPaint2 = new GradientPaint(0, recthei+ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(0, 0, rectwid, recthei);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.gray);
        g2.drawRect(2, 2, rectwid - 20, recthei - 2);
//

        rectwid = 950;
        recthei = 250;
        xpos = 0;
        ypos = 740-recthei;
        gradientPaint2 = new GradientPaint(0, recthei+ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(0, (ypos), rectwid, recthei);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.gray);
        g2.drawRect(2, ypos, rectwid - 20, recthei - 42);

        ////////////////////////////////////////////////

        //buttons on top.


        ////NAME BOX
        rectwid = 165;
        recthei = 45;
        xpos = 15;
        ypos = 20;
        gradientPaint2 = new GradientPaint(0, recthei+ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(xpos, (ypos), rectwid, recthei);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.lightGray);
        g2.drawRect(xpos, ypos, rectwid, recthei);


        ////GENDER
        rectwid = 165;
        recthei = 45;
        ypos = 130;
        gradientPaint2 = new GradientPaint(0, recthei+ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(xpos, (ypos), rectwid, recthei);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.lightGray);
        g2.drawRect(xpos, ypos, rectwid, recthei);


        ////VOICE

        rectwid = 100;
        recthei = 45;
        ypos = 265;
        gradientPaint2 = new GradientPaint(0, recthei+ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(xpos, (ypos), rectwid, recthei);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.lightGray);
        g2.drawRect(xpos, ypos, rectwid, recthei);

        ////AGE

        rectwid = 100;
        recthei = 45;
        ypos = 365;
        gradientPaint2 = new GradientPaint(0, recthei+ypos, ffxivDark, 0, ypos, ffxivBlue);
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
        gradientPaint2 = new GradientPaint(0, recthei+ypos, ffxivDark, 0, ypos, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(xpos, (ypos), rectwid, recthei);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.lightGray);
        g2.drawRect(xpos, ypos, rectwid, recthei);


        //DISPLAY BOXES.

        g2.setColor(Color.black);

        //NAME
        g2.fillRect(17,65,200,45);
        g2.fillRect(225,65,200,45);


        //GENDER
        //buffered images

        //VOICE
        g2.fillRect(75,315,70,45);
        //AGE
        g2.fillRect(75,415,70,45);
        //APPEARANCE
        g2.fillRect(550,65,70,45);


    }

    private void importImage() {
        InputStream inputStreamHdatih = getClass().getResourceAsStream("/hda-f.png");

        try {
            hdatih = ImageIO.read(inputStreamHdatih);
            basicMiqo = ImageIO.read(getClass().getResourceAsStream("/animbase.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
