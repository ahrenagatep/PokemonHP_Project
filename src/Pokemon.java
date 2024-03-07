import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Pokemon {
    private String name;
    private String type;
    private int attack;
    private int defense;
    private int health;
    private int maxHealth;
    private String attack1;
    private String attack2;
    private String bulk;
    private ImageIcon spriteR;
    private ImageIcon spriteL;

    // Setters and getters !!
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public String getType(){return type;}
    public void setType(String type){this.type = type;}
    public int getAttack(){return attack;}
    public void setAttack(int attack){this.attack = attack;}
    public int getDefense(){return defense;}
    public void setDefense(int defense){this.defense = defense;}
    public int getHealth(){return health;}
    public void setHealth(int health){this.health = health;}
    public int getMaxHealth(){return maxHealth;}
    public void setMaxHealth(int maxHealth){this.maxHealth = maxHealth;}
    public ImageIcon getSpriteR(){return spriteR;}
    public void setSpriteR(URL spriteR){this.spriteR = createImageIcon(spriteR);}
    public ImageIcon getSpriteL(){return spriteL;}
    public void setSpriteL(URL spriteL){this.spriteL = createImageIcon(spriteL);}
    public String getAttack1(){return attack1;}
    public void setAttack1(String attack1){this.attack1 = attack1;}
    public String getAttack2(){return attack2;}
    public void setAttack2(String attack2){this.attack2 = attack2;}
    public String getBulk(){return bulk;}
    public void setBulk(String bulk){this.bulk = bulk;}
    private ImageIcon createImageIcon(URL url) {
        if (url != null) {
            return new ImageIcon(url);
        } else {
            return null;
        }
    }
    public void printInfo(){
        System.out.println("Name: "+name);
        System.out.println("Type: "+type);
        System.out.println("Attack: "+attack);
        System.out.println("Defense: "+defense);
        System.out.println("Health: "+health);
    }
    public boolean equals(Pokemon otherPokemon){
        return this.name.equals(otherPokemon.name) &&
                this.health == otherPokemon.health &&
                this.attack == otherPokemon.attack &&
                this.defense == otherPokemon.defense &&
                this.type.equals(otherPokemon.type);
    }
    public void assignPokemon(Pokemon other) {
        this.name = other.getName();
        this.type = other.getType();
        this.health = other.getHealth();
        this.attack = other.getAttack();
        this.defense = other.getDefense();
        this.maxHealth = other.getMaxHealth();
        this.attack1 = other.getAttack1();
        this.attack2 = other.getAttack2();
        this.bulk = other.getBulk();
    }
    public void attacks(Pokemon otherPokemon, UI ui, Game game, Pokemon p1poke, Pokemon p2poke){
        int effect = 1;
        int randomDamage = (int)(Math.random()*8+4);
        int totalDamage;
        totalDamage = randomDamage+this.getAttack()-otherPokemon.getDefense();
        if (totalDamage < 0){ // makes sure pokemon doesn't do negative damage
            totalDamage = 0;
            ui.mainTextArea.setText("It had no effect on\n"+otherPokemon.getName()+"...");
        }else{
            ui.mainTextArea.setText(this.getName()+" used "+this.getAttack1()+"\nand " +
                    "did "+totalDamage+" damage\nto "+otherPokemon.getName()+"!");
        }
        otherPokemon.health -= totalDamage;
        if(otherPokemon.getHealth() < 0){
            otherPokemon.health = 0;
        }

        ui.hp1LabelNumber.setText(String.valueOf(p1poke.getHealth()));
        ui.hp2LabelNumber.setText(String.valueOf(p2poke.getHealth()));
        ui.healthBar1.setValue(p1poke.getHealth());
        ui.healthBar2.setValue(p2poke.getMaxHealth()-p2poke.getHealth());

        ui.choice1.setText("Continue");
        ui.choice2.setText(">");
        ui.choice3.setText(">");
        ui.choice4.setText(">");

        game.nextPosition1 = "continue";
        game.nextPosition2 = "continue";
        game.nextPosition3 = "continue";
        game.nextPosition4 = "continue";
    }
    public void riskyAttacks(Pokemon otherPokemon, UI ui, Game game, Pokemon p1poke, Pokemon p2poke){
        int doubleDamage = (int)(Math.random()*2+1);
        this.defense -= 5;
        int randomDamage = (int)(Math.random()*8+4);
        int totalDamage = doubleDamage*randomDamage;
        int finalDamage = totalDamage+this.getAttack()-otherPokemon.getDefense();
        if (finalDamage < 0){ // makes sure pokemon doesn't do negative damage
            finalDamage = 0;
        }
        ui.mainTextArea.setText("Double damage! "+this.getName()+"\ndid "+finalDamage+" "+this.type+"\ndamage to "+
                otherPokemon.getName()+"!\n\n"+this.name+"'s defense decreased!");
        otherPokemon.health -= finalDamage;
        if(otherPokemon.getHealth() < 0){
            otherPokemon.health = 0;
        }

        ui.hp1LabelNumber.setText(String.valueOf(p1poke.getHealth()));
        ui.hp2LabelNumber.setText(String.valueOf(p2poke.getHealth()));
        ui.healthBar1.setValue(p1poke.getHealth());
        ui.healthBar2.setValue(p2poke.getMaxHealth()-p2poke.getHealth());

        ui.choice1.setText("Continue");
        ui.choice2.setText(">");
        ui.choice3.setText(">");
        ui.choice4.setText(">");

        game.nextPosition1 = "continue";
        game.nextPosition2 = "continue";
        game.nextPosition3 = "continue";
        game.nextPosition4 = "continue";
    }
    public void bulks(Pokemon otherPokemon, UI ui, Game game){ // increases attack and defense by 4-8
        int randomDefense = (int)(Math.random()*8+4);
        int randomAttack = (int)(Math.random()*8+4);
        ui.mainTextArea.setText(this.getName()+" used "+this.getBulk()+"!\n"+this.getName()+"'s attack and\ndefense rose!");
        otherPokemon.defense += randomDefense;
        otherPokemon.attack += randomAttack;
        if(otherPokemon.getAttack() > 40 && otherPokemon.getDefense() > 40){
            ui.mainTextArea.setText(this.getName()+" tried to use\n"+this.getBulk()+" but\ntheir attack and defense\nwon't go any higher!");
        }
        if(otherPokemon.getDefense() > 40){
            otherPokemon.defense = 40;
        }
        if(otherPokemon.getAttack() > 40){
            otherPokemon.defense = 40;
        }

        ui.choice1.setText("Continue");
        ui.choice2.setText(">");
        ui.choice3.setText(">");
        ui.choice4.setText(">");

        game.nextPosition1 = "continue";
        game.nextPosition2 = "continue";
        game.nextPosition3 = "continue";
        game.nextPosition4 = "continue";
    }
    public void usePotion(String type, UI ui, Game game, Pokemon p1poke, Pokemon p2poke, int maxHp, int player, int potions){
        int multiplier;
        switch(type){
            case "super"->multiplier = 2;
            case "hyper"->multiplier = 3;
            case "max"->multiplier=4;
            default->multiplier=1;
        }
        if(potions > 0){
            int hpHealed = ((int)(Math.random()*9)+5)*2;
            this.health += hpHealed;
            if(this.getHealth() > this.getMaxHealth()){ // Makes sure potion doesn't heal past full HP
                this.health = this.getMaxHealth();
                ui.mainTextArea.setText(this.getName()+" used a "+type+"\npotion and healed for\nfull health!\n\nYou have "+(potions-1)+" potions left.");
            }else{
                ui.mainTextArea.setText(this.getName()+" used a "+type+"\npotion and healed for\n"+hpHealed+" health!\n\nYou have "+(potions-1)+" potions left.");
            }
        }else{
            ui.mainTextArea.setText("You have no more\npotions to use\non "+this.getName()+"!");
        }

        ui.hp1LabelNumber.setText(String.valueOf(p1poke.getHealth()));
        ui.hp2LabelNumber.setText(String.valueOf(p2poke.getHealth()));
        ui.healthBar1.setValue(p1poke.getHealth());
        ui.healthBar2.setValue(p2poke.getMaxHealth()-p2poke.getHealth());

        ui.choice1.setText("Continue");
        ui.choice2.setText(">");
        ui.choice3.setText(">");
        ui.choice4.setText(">");

        game.nextPosition1 = "continue";
        game.nextPosition2 = "continue";
        game.nextPosition3 = "continue";
        game.nextPosition4 = "continue";
    }
}