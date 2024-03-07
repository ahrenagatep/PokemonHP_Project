public class VisibilityManager {
    UI ui;
    public VisibilityManager(UI userInterface){
        ui = userInterface;
    }
    public void showTitleScreen(){
        // Show the title screen
        ui.titleLabel.setText("Pokemon");
        ui.titlePanel.setVisible(true);
        ui.subLabel.setText("Hot Pink");
        ui.subLabel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        // Hide game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.p1Panel.setVisible(false);
        ui.p2Panel.setVisible(false);
        ui.sprite1.setVisible(false);
        ui.sprite2.setVisible(false);

        // Hide the end screen
        ui.endButtonPanel.setVisible(false);
    }
    public void showGameScreen(){
        // Hide title screen
        ui.titlePanel.setVisible(false);
        ui.subLabel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        // Show game screen
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.p1Panel.setVisible(true);
        ui.p2Panel.setVisible(true);
        ui.sprite1.setVisible(true);
        ui.sprite2.setVisible(true);

        ui.backgroundLabel.setIcon(ui.battleBackground);
    }
    public void endScreen(){
        // Update title screen for game over
        ui.titleLabel.setText("Game Over");
        ui.titlePanel.setVisible(true);
        ui.subLabel.setText("Retry?");
        ui.subLabel.setVisible(true);

        // Reuse button for option
        ui.startButtonPanel.setVisible(true);
        ui.startButton.setText("PLAY AGAIN");
        ui.startButton.setActionCommand("restart");

        // Hide game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.p1Panel.setVisible(false);
        ui.p2Panel.setVisible(false);
        ui.sprite1.setVisible(false);
        ui.sprite2.setVisible(false);
        ui.backgroundLabel.setIcon(ui.titleBackground);
    }
}
