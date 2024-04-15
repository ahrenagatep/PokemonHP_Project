import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// test comment

public class Game {
    choiceHandler cHandler = new choiceHandler();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    Story story = new Story(this, ui, vm);
    public static void main(String[] args) {
        new Game();
    }
    public Game(){
        ui.createUI(cHandler);
        vm.showTitleScreen();
    }
    public class choiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch (yourChoice) {
                case "start" -> {
                    ui.stopMusic();
                    ui.playSoundEffect(2);
                    vm.showGameScreen();
                    story.pChoose(1);
                }
                case "c1" -> story.selectPosition(nextPosition1);
                case "c2" -> story.selectPosition(nextPosition2);
                case "c3" -> story.selectPosition(nextPosition3);
                case "c4" -> story.selectPosition(nextPosition4);
                case "exit" -> {
                    ui.playSoundEffect(2);
                    System.exit(0);
                }
                case "restart" -> {
                    ui.playSoundEffect(2);
                    ui.mainTextArea.setText("");
                    ui.p1PokeLabel.setText("Choosing...");
                    ui.p2PokeLabel.setText("Choosing...");
                    ui.hp1LabelNumber.setText("");
                    ui.hp2LabelNumber.setText("");
                    ui.setSprite(null, 1);
                    ui.setSprite(null, 2);
                    story.p1poke.assignPokemon(story.defaultPoke);
                    story.p2poke.assignPokemon(story.defaultPoke);
                    ui.healthBar1.setMinimum(0);
                    ui.healthBar1.setMaximum(1);
                    ui.healthBar1.setValue(1);
                    ui.healthBar2.setMinimum(0);
                    ui.healthBar2.setMaximum(1);
                    ui.healthBar2.setValue(0);
                    vm.showGameScreen();
                    story.selectPosition("p1pick");
                }
            }
        }
    }
}
