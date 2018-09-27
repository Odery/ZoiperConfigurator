package com.vakamisu.zoiper;

import java.io.File;

//POJO
public class User {
    private String userName;
    private File zoiperConfig;
    private int extWas;
    private int extNow;
    private boolean empty;

    public User(String userName, File zoiperConfig, int extWas, int extNow, boolean empty) {
        this.userName = userName;
        this.zoiperConfig = zoiperConfig;
        this.empty = empty;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public File getZoiperConfig() {
        return zoiperConfig;
    }

    public void setZoiperConfig(File zoiperConfig) {
        this.zoiperConfig = zoiperConfig;
    }

    public int getExtWas() {
        return extWas;
    }

    public void setExtWas(int extWas) {
        this.extWas = extWas;
    }

    public int getExtNow() {
        return extNow;
    }

    public void setExtNow(int extNow) {
        this.extNow = extNow;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    @Override
    public String toString() {
        return empty ? userName + "," + "empty" + "\n": userName + "," + extWas + "," + extNow + "\n";
    }
}
