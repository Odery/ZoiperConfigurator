package com.vakamisu.zoiper;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import java.io.FileWriter;
import java.io.IOException;

public class ZoiperConfigManager {
    private final int range = 800;
    private final int start = 1030;
    private final int end = 1110;
    private SAXBuilder builder;
    private ExtList extList;

    public ZoiperConfigManager() throws IOException {
        extList = ExtParser.parse("ext.csv");
        builder = new SAXBuilder();
    }

    public void checkUser(User user) throws JDOMException, IOException {
        Document doc = builder.build(user.getZoiperConfig());
        Element rootNode = doc.getRootElement();
        try{
            rootNode.getChild("accounts").getChild("account").getChild("username");
        }catch (NullPointerException exc){
            System.out.println(user.getUserName() + " - no zoip config");
            user.setEmpty(true);
            return;
        }
        Element userName = rootNode.getChild("accounts").getChild("account").getChild("username");
        Element account = rootNode.getChild("general").getChild("account");
        Element name = rootNode.getChild("accounts").getChild("account").getChild("name");
        Element context = rootNode.getChild("accounts").getChild("account").getChild("context");
        Element password = rootNode.getChild("accounts").getChild("account").getChild("password");

        int extWas = Integer.parseInt(userName.getText());
        user.setExtWas(extWas);

        if (extWas < range){
            context.setText("wisebanc.pbx.commpeak.com");

            Ext extNow = extList.getFreeOne(start, end);
            String accountCon = "wisebanc.pbx.commpeak.com";
            account.setText(extNow.getNumber() + "@" + accountCon);
            context.setText(accountCon);
            name.setText(extNow.getNumber() + "@" + accountCon);
            user.setExtNow(extNow.getNumber());
            userName.setText(extNow.getNumber() + "");
            password.setText(extNow.getPass());
            extNow.setTaken(true);
        }

        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.output(doc, new FileWriter(user.getZoiperConfig()));
        }
}
