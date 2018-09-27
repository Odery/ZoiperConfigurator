package com.vakamisu.zoiper;

import java.util.ArrayList;
import java.util.List;

public class ExtList {
    List<Ext> extList = new ArrayList<>();

    public void add(int number, String pass){
        extList.add(new Ext(number, pass));
    }

    public List<Ext> getExtList() {
        return extList;
    }

    public Ext getFreeOne(int min_range, int max_range){
        for (Ext ext : extList){
            if (!ext.isTaken() &&
                    (ext.getNumber() <= max_range && ext.getNumber() >= min_range)){
                return ext;
            }
        }
        return null;
    }
}
