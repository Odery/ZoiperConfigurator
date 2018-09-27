package com.vakamisu.zoiper;

import java.io.*;

public class ExtParser {
    public static ExtList parse(String path) throws IOException {
        ExtList extList = new ExtList();
        BufferedReader b = new BufferedReader(new FileReader(new File(path)));
        String line = "";

        while ((line = b.readLine()) != null){
            String[] split = line.split(",");
            extList.add(
                    Integer.parseInt(split[0].trim()),
                    split[1].trim()
            );
        }
        return extList;
    }
}
