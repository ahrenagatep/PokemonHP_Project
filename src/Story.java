public class Story {
    int turn;
    Game game;
    UI ui;
    VisibilityManager vm;
    Pokemon p1poke;
    Pokemon p2poke;
    Pokemon poke1;
    Pokemon poke2;
    Pokemon poke3;
    Pokemon poke4;
    Pokemon defaultPoke;
    int p1Potions, p2Potions;
    public Story(Game g, UI userInterface, VisibilityManager vManager) {
        game = g;
        ui = userInterface;
        vm = vManager;
        poke1 = new Pokemon();
        poke2 = new Pokemon();
        poke3 = new Pokemon();
        poke4 = new Pokemon();
        p1poke = new Pokemon();
        p2poke = new Pokemon();
        defaultPoke = new Pokemon();

        poke1.setName("Charizard");
        poke1.setType("Fire");
        poke1.setHealth(135);
        poke1.setMaxHealth(135);
        poke1.setAttack(30);
        poke1.setDefense(25);
        poke1.setSpriteR(getClass().getResource("resources/sprites/charizard/charizardR.png"));
        poke1.setSpriteL(getClass().getResource("resources/sprites/charizard/charizardL.png"));
        poke1.setAttack1("Slash");
        poke1.setAttack2("Fire Fang");
        poke1.setBulk("Reinforce");

        poke2.setName("Snorlax");
        poke2.setType("Normal");
        poke2.setHealth(130);
        poke2.setMaxHealth(130);
        poke2.setAttack(25);
        poke2.setDefense(30);
        poke2.setSpriteR(getClass().getResource("resources/sprites/snorlax/snorlaxR.png"));
        poke2.setSpriteL(getClass().getResource("resources/sprites/snorlax/snorlaxL.png"));
        poke2.setAttack1("Tackle");
        poke2.setAttack2("Body Slam");
        poke2.setBulk("Bulk Up");

        poke3.setName("Eevee"); // my gf's favorite Pokémon
        poke3.setType("Normal");
        poke3.setHealth(100);
        poke3.setMaxHealth(100);
        poke3.setAttack(20);
        poke3.setDefense(15);
        poke3.setSpriteR(getClass().getResource("resources/sprites/eevee/eeveeR.png"));
        poke3.setSpriteL(getClass().getResource("resources/sprites/eevee/eeveeL.png"));
        poke3.setAttack1("Quick Attack");
        poke3.setAttack2("Tail Whip");
        poke3.setBulk("Endure");

        poke4.setName("Wooper"); // my favorite Pokémon
        poke4.setType("Water");
        poke4.setHealth(100);
        poke4.setMaxHealth(100);
        poke4.setAttack(10);
        poke4.setDefense(20);
        poke4.setSpriteR(getClass().getResource("resources/sprites/wooper/wooperR.png"));
        poke4.setSpriteL(getClass().getResource("resources/sprites/wooper/wooperL.png"));
        poke4.setAttack1("Mud Slap");
        poke4.setAttack2("Water Gun");
        poke4.setBulk("Rain Dance");

        defaultPoke.setName("null");
        defaultPoke.setType("null");
        defaultPoke.setHealth(100);
        defaultPoke.setMaxHealth(100);
        defaultPoke.setAttack(0);
        defaultPoke.setDefense(0);

        p1Potions = 5;
        p2Potions = 5;
    }
    public void defaultSetup(){
        ui.hp1LabelNumber.setText(""+p1poke.getHealth());
        ui.p1PokeLabel.setText(p1poke.getName());
        ui.hp2LabelNumber.setText(""+p2poke.getHealth());
        ui.p2PokeLabel.setText(p2poke.getName());

        ui.healthBar1.setMinimum(0);
        ui.healthBar1.setMaximum(p1poke.getMaxHealth());
        ui.healthBar1.setValue(p1poke.getMaxHealth());

        ui.healthBar2.setMinimum(0);
        ui.healthBar2.setMaximum(p2poke.getMaxHealth());
        ui.healthBar2.setValue(0);

        ui.healthBar1.setValue(p1poke.getMaxHealth());
        ui.healthBar2.setValue(0);
    }
    public void flip(){
        ui.playMusic(1);
        int who = (int)(Math.random()*2+1);
        if(who == 2){
            ui.mainTextArea.setText("Player 2 goes first!\n\nPress any button to\ncontinue.");

            ui.choice1.setText(">");
            ui.choice2.setText(">");
            ui.choice3.setText(">");
            ui.choice4.setText(">");

            game.nextPosition1 = "p2turn";
            game.nextPosition2 = "p2turn";
            game.nextPosition3 = "p2turn";
            game.nextPosition4 = "p2turn";
        } else if (who == 1) {
            ui.mainTextArea.setText("Player 1 goes first!\n\nPress any button to\ncontinue.");

            ui.choice1.setText(">");
            ui.choice2.setText(">");
            ui.choice3.setText(">");
            ui.choice4.setText(">");

            game.nextPosition1 = "p1turn";
            game.nextPosition2 = "p1turn";
            game.nextPosition3 = "p1turn";
            game.nextPosition4 = "p1turn";
        }
    }
    public void p1Turn(){
        turn = 1;
        ui.mainTextArea.setText("Player 1's turn!\n\nWhat will\n"+p1poke.getName()+" do?");

        ui.choice1.setText("<html><p>" + p1poke.getAttack1() + "</p></html>");
        ui.choice2.setText("<html><p>" + p1poke.getAttack2() + "</p></html>");
        ui.choice3.setText("<html><p>" + p1poke.getBulk() + "</p></html>");
        ui.choice4.setText("Use Potion");

        game.nextPosition1 = "attack1";
        game.nextPosition2 = "risky1";
        game.nextPosition3 = "bulk1";
        game.nextPosition4 = "potion1";
    }
    public void p2Turn(){
        turn = 2;
        ui.mainTextArea.setText("Player 2's turn!\n\nWhat will\n"+p2poke.getName()+" do?");

        ui.choice1.setText("<html><p>" + p2poke.getAttack1() + "</p></html>");
        ui.choice2.setText("<html><p>" + p2poke.getAttack2() + "</p></html>");
        ui.choice3.setText("<html><p>" + p2poke.getBulk() + "</p></html>");
        ui.choice4.setText("Use Potion");

        game.nextPosition1 = "attack2";
        game.nextPosition2 = "risky2";
        game.nextPosition3 = "bulk2";
        game.nextPosition4 = "potion2";
    }
    public void pChoose(int playerNumber){
        String playerName = (playerNumber == 1) ? "Player 1" : "Player 2";

        ui.mainTextArea.setText(playerName + ", choose your\nPokemon!");
        ui.choice1.setText("Charizard");
        ui.choice2.setText("Snorlax");
        ui.choice3.setText("Eevee");
        ui.choice4.setText("Wooper");

        // Set next positions for player 1 if it's their turn
        if (playerNumber == 1) {
            game.nextPosition1 = "charizard";
            game.nextPosition2 = "snorlax";
            game.nextPosition3 = "eevee";
            game.nextPosition4 = "wooper";
        } else { // Set next positions for player 2 if it's their turn
            game.nextPosition1 = "charizard2";
            game.nextPosition2 = "snorlax2";
            game.nextPosition3 = "eevee2";
            game.nextPosition4 = "wooper2";
        }
    }
    public void next(){
        if(p1poke.getHealth() > 0 && p2poke.getHealth() > 0){
            if(turn == 1){
                selectPosition("p2turn");
            }else if(turn == 2){
                selectPosition("p1turn");
            }
        }else if(p1poke.getHealth() <= 0 || p2poke.getHealth() <= 0){
            end(ui,game,p1poke,p2poke);
        }
    }
    public void selectPosition(String nextPosition){
        switch (nextPosition) {
            case "p1pick" -> pChoose(1);
            case "charizard" -> {
                p1poke.assignPokemon(poke1);
                ui.setSprite(ui.resize(poke1.getSpriteR(), 240), 1);
                selectPosition("p2pick");
                ui.playSoundEffect(2);
            }
            case "snorlax" -> {
                p1poke.assignPokemon(poke2);
                ui.setSprite(ui.resize(poke2.getSpriteR(), 255), 1);
                selectPosition("p2pick");
                ui.playSoundEffect(2);
            }
            case "eevee" -> {
                p1poke.assignPokemon(poke3);
                ui.setSprite(ui.resize(poke3.getSpriteR(), 288), 1);
                selectPosition("p2pick");
                ui.playSoundEffect(2);
            }
            case "wooper" -> {
                p1poke.assignPokemon(poke4);
                ui.setSprite(ui.resize(poke4.getSpriteR(), 288), 1);
                selectPosition("p2pick");
                ui.playSoundEffect(2);
            }
            case "p2pick" -> pChoose(2);
            case "charizard2" -> {
                p2poke.assignPokemon(poke1);
                ui.setSprite(ui.resize(poke1.getSpriteL(), 240), 2);
                ui.playSoundEffect(2);
                defaultSetup();
                selectPosition("flip");
            }
            case "snorlax2" -> {
                p2poke.assignPokemon(poke2);
                ui.setSprite(ui.resize(poke2.getSpriteL(), 255), 2);
                ui.playSoundEffect(2);
                defaultSetup();
                selectPosition("flip");
            }
            case "eevee2" -> {
                p2poke.assignPokemon(poke3);
                ui.setSprite(ui.resize(poke3.getSpriteL(), 288), 2);
                ui.playSoundEffect(2);
                defaultSetup();
                selectPosition("flip");
            }
            case "wooper2" -> {
                p2poke.assignPokemon(poke4);
                ui.setSprite(ui.resize(poke4.getSpriteL(), 288), 2);
                ui.playSoundEffect(2);
                defaultSetup();
                selectPosition("flip");
            }
            case "flip" -> flip();
            case "p1turn" -> p1Turn();
            case "p2turn" -> p2Turn();
            case "continue" -> next();
            case "attack1" -> p1poke.attacks(p2poke, ui, game, p1poke, p2poke);
            case "risky1" -> p1poke.riskyAttacks(p2poke, ui, game, p1poke, p2poke);
            case "bulk1" -> p1poke.bulks(p1poke, ui, game);
            case "potion1" -> {
                p1poke.usePotion("hyper", ui, game, p1poke, p2poke, p1poke.getMaxHealth(), 1, p1Potions);
                p1Potions--;
            }
            case "attack2" -> p2poke.attacks(p1poke, ui, game, p1poke, p2poke);
            case "risky2" -> p2poke.riskyAttacks(p1poke, ui, game, p1poke, p2poke);
            case "bulk2" -> p2poke.bulks(p2poke, ui, game);
            case "potion2" -> {
                p2poke.usePotion("hyper", ui, game, p1poke, p2poke, p2poke.getMaxHealth(), 2, p2Potions);
                p2Potions--;
            }
            case "finish" -> vm.endScreen();
            case "exit" -> System.exit(0);
            case "restart" -> {
                ui.playSoundEffect(2);
                vm.showTitleScreen();
                ui.playMusic(0);
                ui.mainTextArea.setText("");
                ui.p1PokeLabel.setText("");
                ui.p2PokeLabel.setText("");
                ui.hp1LabelNumber.setText("");
                ui.hp2LabelNumber.setText("");
                p1poke.assignPokemon(defaultPoke);
                p2poke.assignPokemon(defaultPoke);
                selectPosition("p1pick");
            }
        }
    }
    public void end(UI ui, Game game, Pokemon p1poke, Pokemon p2poke){
        ui.stopMusic();
        ui.playSoundEffect(3);
        if(p1poke.getHealth() <= 0 || p2poke.getHealth() <= 0){
            if(p1poke.getHealth() > 0){
                ui.mainTextArea.setText(p2poke.getName()+" fainted.\n\n"+p1poke.getName()+" has won!");
                ui.choice1.setText("Finish");
                ui.choice2.setText(">");
                ui.choice3.setText(">");
                ui.choice4.setText(">");

                game.nextPosition1 = "finish";
                game.nextPosition2 = "finish";
                game.nextPosition3 = "finish";
                game.nextPosition4 = "finish";

            }else if(p2poke.getHealth() > 0){
                ui.mainTextArea.setText(p1poke.getName()+" fainted.\n\n"+p2poke.getName()+" has won!");
                ui.choice1.setText("Finish");
                ui.choice2.setText(">");
                ui.choice3.setText(">");
                ui.choice4.setText(">");

                game.nextPosition1 = "finish";
                game.nextPosition2 = "finish";
                game.nextPosition3 = "finish";
                game.nextPosition4 = "finish";
            }
        }
    }
}
