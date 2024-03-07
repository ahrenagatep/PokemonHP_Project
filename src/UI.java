import javax.swing.*;
import java.awt.*;
import java.io.*;
public class UI {
    public ImageIcon resize(ImageIcon sprite, int scale){
        Image scaledImage = sprite.getImage().getScaledInstance(scale,scale,Image.SCALE_DEFAULT);
        ImageIcon resprite = new ImageIcon(scaledImage);
        return resprite;
    }
    ImageIcon titleBackground = new ImageIcon(getClass().getResource("resources/textures/titleScreen.gif"));
    ImageIcon battleBackground = new ImageIcon(getClass().getResource("resources/textures/battleBackground.png"));
    JFrame window;
    Container con;
    JPanel titlePanel, subPanel, startButtonPanel, mainTextPanel, choiceButtonPanel,
            p1Panel, p2Panel, endButtonPanel, sprite1, sprite2, hpPanel1, hpPanel2;
    JLabel titleLabel, subLabel, hp1Label, hp1LabelNumber, p1PokeLabel, hp2Label,
            hp2LabelNumber, p2PokeLabel, backgroundLabel, p1SpriteLabel, p2SpriteLabel;
    JButton startButton, choice1, choice2, choice3, choice4, backToMenu, exitGame;
    JTextArea mainTextArea;
    Font pixelMPlus;
    JProgressBar healthBar1, healthBar2;
    Font normalFont = new Font("SansSerif",Font.BOLD,35);
    Font battleFont = new Font("SansSerif",Font.BOLD,20);
    Color hotPink = new Color(255,71,218);
    Color customRed = new Color(233,79,55);
    Color customYellow = new Color(241,196,15);
    Color customGreen = new Color(79,119,45);
    Color customBlue = new Color(48,76,137);
    Sound sound = new Sound();

    public void setSprite(ImageIcon spriteImage, int player){
        if(player == 1){
            p1SpriteLabel.setIcon(spriteImage);
        }else if(player == 2){
            p2SpriteLabel.setIcon(spriteImage);
        }
    }
    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic(){
        sound.stop();
    }
    public void playSoundEffect(int i){
        sound.setFile(i); // Change the path as needed
        sound.play();
    }
    public void createUI(Game.choiceHandler cHandler){
        try{
            pixelMPlus = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/fonts/PixelMplus10-Regular.ttf")).deriveFont(50f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/fonts/PixelMplus10-Regular.ttf")));
        }catch (IOException | FontFormatException e){
            e.printStackTrace();
        }

        playMusic(0);

        normalFont = pixelMPlus.deriveFont(50f);
        battleFont = pixelMPlus.deriveFont(30f);

        // WINDOW
        window = new JFrame(); // initialize JFrame
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        con = window.getContentPane();
        con.setLayout(null);

        // TITLE SCREEN
        titlePanel = new JPanel();
        titlePanel.setBounds(100,100,600,150);
        titlePanel.setBackground(Color.black);
        titlePanel.setOpaque(false);
        titleLabel = new JLabel("Pokemon"); // text
        titleLabel.setForeground(Color.white); // text color
        titleLabel.setFont(pixelMPlus.deriveFont(120f));
        titlePanel.add(titleLabel);
        window.add(titlePanel);

        // SUB TITLE
        subPanel = new JPanel();
        subPanel.setBounds(150,150,400,150);
        subPanel.setBackground(Color.black);
        subPanel.setOpaque(true);
        subLabel = new JLabel("Hot Pink");
        subLabel.setBounds(300,170,400,150);
        subLabel.setFont(pixelMPlus.deriveFont(50f));
        subLabel.setBackground(Color.black);
        subLabel.setForeground(Color.white);
        subPanel.add(subLabel);
        window.add(subLabel);

        // START BUTTON or END BUTTON
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(150,400,500,75);
        startButtonPanel.setBackground(Color.black);
        startButtonPanel.setLayout(new GridLayout(1,2));
        startButtonPanel.setOpaque(false);

        startButton = new JButton("PRESS START");
        startButton.setBackground(hotPink);
        startButton.setForeground(Color.white);
        startButton.setFont(battleFont.deriveFont(35f));
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startButton.setFocusPainted(false);
        startButtonPanel.add(startButton);

        exitGame = new JButton("EXIT GAME");
        exitGame.setBackground(hotPink);
        exitGame.setForeground(Color.white);
        exitGame.setFont(battleFont.deriveFont(35f));
        exitGame.addActionListener(cHandler);
        exitGame.setActionCommand("exit");
        exitGame.setFocusPainted(false);
        startButtonPanel.add(exitGame);

        window.add(startButtonPanel);

        // GAME SCREEN
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(0,350,400,200);
        mainTextPanel.setBackground(Color.lightGray);
        con.add(mainTextPanel);

        // TITLE SCREEN
        mainTextArea = new JTextArea("[text]");
        mainTextArea.setBounds(0,350,400,200);
        mainTextArea.setBackground(Color.lightGray);
        mainTextArea.setForeground(Color.darkGray);
        mainTextArea.setFont(battleFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        // GAME BUTTONS
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(400,350,400,200);
        choiceButtonPanel.setBackground(Color.pink);
        choiceButtonPanel.setLayout(new GridLayout(2,2));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(customRed);
        choice1.setForeground(Color.white);
        choice1.setFont(battleFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(customYellow);
        choice2.setForeground(Color.white);
        choice2.setFont(battleFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice 3");
        choice3.setBackground(customGreen);
        choice3.setForeground(Color.white);
        choice3.setFont(battleFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Choice 4");
        choice4.setBackground(customBlue);
        choice4.setForeground(Color.white);
        choice4.setFont(battleFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        p1Panel = new JPanel();
        p1Panel.setBounds(0,0,350,75);
        p1Panel.setBackground(Color.lightGray);
        con.add(p1Panel);
        p1PokeLabel = new JLabel("Choosing...");
        p1PokeLabel.setFont(battleFont);
        p1PokeLabel.setForeground(Color.darkGray);
        p1Panel.add(p1PokeLabel);
        hp1Label = new JLabel("HP:");
        hp1Label.setFont(battleFont);
        hp1Label.setForeground(Color.darkGray);
        p1Panel.add(hp1Label);
        hp1LabelNumber = new JLabel("");
        hp1LabelNumber.setFont(battleFont);
        hp1LabelNumber.setForeground(Color.darkGray);
        p1Panel.add(hp1LabelNumber);

        p2Panel = new JPanel();
        p2Panel.setBounds(450,0,350,75);
        p2Panel.setBackground(Color.lightGray);
        con.add(p2Panel);
        p2PokeLabel = new JLabel("Choosing...");
        p2PokeLabel.setFont(battleFont);
        p2PokeLabel.setForeground(Color.darkGray);
        p2Panel.add(p2PokeLabel);
        hp2Label = new JLabel("HP:");
        hp2Label.setFont(battleFont);
        hp2Label.setForeground(Color.darkGray);
        p2Panel.add(hp2Label);
        hp2LabelNumber = new JLabel("");
        hp2LabelNumber.setFont(battleFont);
        hp2LabelNumber.setForeground(Color.darkGray);
        p2Panel.add(hp2LabelNumber);

        hpPanel1 = new JPanel();
        hpPanel1.setBounds(0,50,350,25);
        hpPanel1.setOpaque(false);
        con.add(hpPanel1);
        healthBar1 = new JProgressBar();
        healthBar1.setPreferredSize(new Dimension(350,25));
        healthBar1.setBackground(customRed);
        healthBar1.setForeground(Color.green);
        p1Panel.add(healthBar1);

        hpPanel2 = new JPanel();
        hpPanel2.setBounds(450,50,350,25);
        hpPanel2.setOpaque(false);
        con.add(hpPanel2);
        healthBar2 = new JProgressBar();
        healthBar2.setPreferredSize(new Dimension(350,25));
        healthBar2.setBackground(Color.green);
        healthBar2.setForeground(customRed);
        p2Panel.add(healthBar2);

        healthBar1.setMinimum(0);
        healthBar1.setMaximum(1);
        healthBar1.setValue(1);
        healthBar2.setMinimum(0);
        healthBar2.setMaximum(1);
        healthBar2.setValue(0);

        // POKEMON SPRITES
        sprite1 = new JPanel();
        sprite1.setBounds(12,100,288,288);
        sprite1.setOpaque(false);
        JLabel p1Sprite = new JLabel();
        p1Sprite.setBounds(12,100,288,288);
        window.add(sprite1);
        p1SpriteLabel = new JLabel();
        p1SpriteLabel.setBounds(12,100,288,288);
        sprite1.add(p1SpriteLabel);

        sprite2 = new JPanel();
        sprite2.setBounds(500,100,288,288);
        sprite2.setOpaque(false);
        JLabel p2Sprite = new JLabel();
        p2Sprite.setBounds(500,100,288,288);
        window.add(sprite2);
        p2SpriteLabel = new JLabel();
        p2SpriteLabel.setBounds(12,100,288,288);
        sprite2.add(p2SpriteLabel);

        // BACKGROUND
        backgroundLabel = new JLabel(titleBackground);
        backgroundLabel.setBounds(0,0,800,600);
        window.add(backgroundLabel);

        // END BUTTONS
        endButtonPanel = new JPanel();
        endButtonPanel.setBounds(100,400,600,100);
        endButtonPanel.setBackground(Color.pink);
        endButtonPanel.setLayout(new GridLayout(1,2));

        backToMenu = new JButton("Back to Main Menu");
        backToMenu.setBackground(Color.lightGray);
        backToMenu.setForeground(Color.darkGray);
        backToMenu.setFont(battleFont.deriveFont(30f));
        backToMenu.addActionListener(cHandler);
        backToMenu.setActionCommand("restart");
        backToMenu.setFocusPainted(false);
        endButtonPanel.add(backToMenu);

        con.add(endButtonPanel);
        window.add(endButtonPanel);

        con.setVisible(false);
        con.setVisible(true);
        window.repaint();
        window.setVisible(true); // actually see it.
    }
}
