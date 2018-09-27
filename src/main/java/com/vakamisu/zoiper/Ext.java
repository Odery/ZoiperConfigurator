package com.vakamisu.zoiper;

public class Ext{
    private final int number;
    private final String pass;
    private boolean taken;

    public Ext(int number, String pass) {
        this.number = number;
        this.pass = pass;
    }

    public int getNumber() {
        return number;
    }

    public String getPass() {
        return pass;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}