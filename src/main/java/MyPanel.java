import test.EnumGender;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class MyPanel extends JPanel implements Runnable {

    //TODO: Use abstract in some way.

    BufferedImage hdatih;
    BufferedImage basicMiqo;
    BufferedImage maleimage;
    BufferedImage femaleimage;
    private int frames = 0;
    private long lastCheck = 0;
    Thread gameThread;
    int FPS = 60;

    private int animationTick, animationIndex;
    private int animationSpeed = 15;

    private BufferedImage[] walkAnimation;

    //get/set assets
    String firstName; //randomized only.
    char tribeLetter; // can be typed or selected from a drop down list.
    String lastName; //if clicked, alternate between nunh or tia.
    //appearance
    int appearanceRow = 0; //can only range from the size of the appearances array.
    EnumGender gender;
    int voiceNumber; //can only range from the size of the voices array.
    int age; // if below 1, make 1. if above 70, make 70.
    final int ageMax = 70;
    final int ageMin = 1;

    Random randomizer = new Random();


    MyPanel() {

        importImage();
        loadAnimations();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
//        drawUI(g2);
        drawUIImproved(g2);
        drawUIText(g2);


        updateAnimationTick();

        drawCharacter(g2);
        ///gender images:
        g2.drawImage(femaleimage, 35, 200, 50, 50, null);
        g2.drawImage(maleimage, 100, 200, 50, 50, null);

        //////////////

        frames++;
        if (System.currentTimeMillis() - lastCheck >= 1000) {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }

        g2.dispose();
    }

    public void drawUIImproved(Graphics2D g2) {
        drawBackground(g2);

        //Blue UI with the grey outlines.
        drawUIBlueBox(520, 80, 430, 460, g2); //EAST PANE
        drawUIBlueBox(0, 90, 200, 460, g2); //WEST PANE
        drawUIBlueBox(0, 0, 950, 110, g2); //NORTH PANE
        drawUIBlueBox(0, 490, 950, 259, g2); //SOUTH PANE
        drawUIBlueBox(15, 20, 165, 45, g2); //NAME BUTTON
        drawUIBlueBox(15, 130, 165, 45, g2); //GENDER BUTTON
        drawUIBlueBox(15, 265, 100, 45, g2); //VOICE BUTTON
        drawUIBlueBox(15, 365, 100, 45, g2); //AGE BUTTON
        drawUIBlueBox(480, 20, 215, 45, g2); //APPEARANCE BUTTON

        //Black boxes for text.

        drawDisplayBoxBlack(17, 65, 200, 45, g2); //NAME
        drawDisplayBoxBlack(225, 65, 200, 45, g2); //NAME 2
        drawDisplayBoxBlack(75, 315, 70, 45, g2); //VOICE
        drawDisplayBoxBlack(75, 415, 70, 45, g2); //AGE
        drawDisplayBoxBlack(550, 65, 70, 45, g2); //APPEARANCE


    }

    public void drawBackground(Graphics2D g2) {
        g2.setColor(Color.darkGray);
        g2.fillRect(190, 90, 360, 430);
    }

    public void drawUIBlueBox(int x, int y, int width, int height, Graphics2D g2) {
        Color ffxivBlue = new Color(0, 63, 229);
        Color ffxivDark = new Color(11, 18, 59);
        GradientPaint gradientPaint2 = new GradientPaint(0, height + y, ffxivDark, 0, y, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(x, y, width, height);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.gray);
        g2.drawRect(x, y, width, height);
    }

    public void drawDisplayBoxBlack(int x, int y, int width, int height, Graphics2D g2) {
        g2.setColor(Color.black);
        g2.fillRect(x, y, width, height);
    }

    public void drawCharacter(Graphics2D g2) {
        BufferedImage subimageMqi = basicMiqo.getSubimage(0, 0, 400, 500);
        g2.drawImage(walkAnimation[animationIndex], 215, 90, 315, 415, null);
    }

    public void drawUIText(Graphics2D g2) {
        g2.setFont(new Font("Sitka Text", Font.ITALIC, 32));
        g2.setColor(Color.white);

        //First Name Button
        g2.drawString("Name", 55, 55);
        //First Name
        g2.drawString("Sun Miqo'te", 25, 100);
        //Last Name
        g2.drawString("Tia", 300, 100);
        //Gender Button
        g2.drawString("Gender", 47, 162);
        //Voice Button
        g2.drawString("Voice", 25, 300);
        //Voice text
        g2.drawString("M:1", 82, 350);
        //Age Button
        g2.drawString("Age", 25, 400);
        //Age text
        g2.drawString("X", 100, 450);
        //Appearance Button
        g2.drawString("Appearance", 500, 52);
        //Appearance Text
        g2.drawString("m-1", 555, 100);

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                repaint();
                delta--;
            }
        }

    }

    private void loadAnimations() {
        walkAnimation = new BufferedImage[5];

        for (int i = 0; i < walkAnimation.length; i++) {
            walkAnimation[i] = basicMiqo.getSubimage(i * 400, 0, 400, 500);

        }

    }

    public void updateAnimationTick() {

        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
            //this resets it back to the far left side of the animation if it reaches the end of the array!
            if (animationIndex >= walkAnimation.length) {
                animationIndex = 0;
            }
        }

    }

    public void update() {

    }


    private void importImage() {
        InputStream inputStreamHdatih = getClass().getResourceAsStream("/imageassets/hda-f.png");

        try {
            hdatih = ImageIO.read(inputStreamHdatih);
            basicMiqo = ImageIO.read(getClass().getResourceAsStream("/imageassets/animbase.png"));
            femaleimage = ImageIO.read(getClass().getResourceAsStream("/imageassets/pank.png"));
            maleimage = ImageIO.read(getClass().getResourceAsStream("/imageassets/blea.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //getset previous next

    public void setAgeNext() {
        //set to the next value
    }

    public void setAgePrevious() {
        //set to the previous value
    }

    public void setAppearanceNext() {
        //set to the next value
    }

    public void setAppearancePrevious() {
        //set to the previous value
    }

    public void setVoiceNext() {
        //set to the next value
    }

    public void setVoicePrevious() {
        //set to the previous value
    }


    //getters and setters


    public void setRandomFirstName() {
        //array of miqote names
        //random number with max being the length.
        //switch case for male and female.
    }

    public void setTheLastName() {
        //if clicked, and if it is nunh, set to tia.
        //if clicked, and if it is tia, set to nunh.
    }

    public void setRandomAppearance() {
        //random number with max being the length of the array.
        //switch case for male and female.
    }

    public void setRandomVoice() {
        //random number with max being the length of the array.
        //switch case for male and female.
    }

    public void setRandomAge() {
        //random number with max being the length of the age max.
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getTribeLetter() {
        return tribeLetter;
    }

    public void setTribeLetter(char tribeLetter) {
        this.tribeLetter = tribeLetter;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAppearanceRow() {
        return appearanceRow;
    }

    public void setAppearanceRow(int appearanceRow) {
        this.appearanceRow = appearanceRow;
    }

    public EnumGender getGender() {
        return gender;
    }

    public void setGender(EnumGender gender) {
        this.gender = gender;
    }

    public int getVoiceNumber() {
        return voiceNumber;
    }

    public void setVoiceNumber(int voiceNumber) {
        this.voiceNumber = voiceNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFPS() {
        return FPS;
    }

    public void setFPS(int FPS) {
        this.FPS = FPS;
    }
}
