package org.example;

public class Player {

    String color;
    boolean isMyturn;

    public Player(String color, boolean isMyturn) {
        this.color = color;
        this.isMyturn = isMyturn;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isMyturn() {
        return isMyturn;
    }

    public void setMyturn(boolean myturn) {
        isMyturn = myturn;
    }
}
