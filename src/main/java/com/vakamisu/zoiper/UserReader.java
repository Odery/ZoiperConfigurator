package com.vakamisu.zoiper;

import org.jdom2.JDOMException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserReader {
    private List<User> users;
    private File usersFolder;
    private ZoiperConfigManager configurator;

    public UserReader() throws IOException {
        configurator = new ZoiperConfigManager();
        usersFolder = new File("C:\\Users\\serpe\\IdeaProjects\\ZoiperConfigurator\\users");
        users = new ArrayList<>();
    }

    public List<User> checkUsers() throws JDOMException, IOException {
        for (File file : usersFolder.listFiles()) {
            users.add(readUser(file));
        }
        return users;
    }

    //TODO КОСТИЛЬ
    private User readUser(File file) throws JDOMException, IOException {
        User user = new User(file.getName());
        if (Arrays.asList(file.listFiles()).isEmpty() || !new File(file.getPath() + "\\AppData\\Roaming\\Zoiper\\Config.xml").exists()) {
            user.setEmpty(true);
            return user;
        }
        user.setZoiperConfig(new File(file.getPath()+"\\AppData\\Roaming\\Zoiper\\Config.xml"));
        checkExt(user);
        return user;
    }

    private void checkExt(User user) throws JDOMException, IOException {
        configurator.checkUser(user);
    }

    public List<User> getUsers(){
        return users;
    }
}
