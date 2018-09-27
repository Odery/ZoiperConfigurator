package com.vakamisu.zoiper;

import org.jdom2.JDOMException;

import java.io.*;

//FACADE TODO
public class Configurator {
    private UserReader reader;

    public Configurator(){
        try {
            reader = new UserReader();
        }catch (IOException exc){
            exc.printStackTrace();
        }
    }

    public void configureWithLog(){
        try {
            reader.checkUsers();

            File log = new File("log.csv");
            FileOutputStream fos = new FileOutputStream(log);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (User user : reader.getUsers()){
                bw.write(user.toString());
            }
            bw.flush();
            bw.close();
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }

    }
}
