package net.azib.java.students.t104971.homework.athletics.util;

import org.apache.log4j.Logger;

import java.awt.*;
import java.net.URI;

public class BrowserLaunch {

    public static void openURL(String url) {
        try {
            Desktop.getDesktop().browse(new URI("file://" + url));
        } catch (Exception e) {
            Logger.getLogger(BrowserLaunch.class).error(e);
        }
    }

}
