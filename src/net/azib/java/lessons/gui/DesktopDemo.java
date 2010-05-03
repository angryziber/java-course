package net.azib.java.lessons.gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * DesktopDemo
 *
 * @author anton
 */
public class DesktopDemo {
	public static void main(String[] args) throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URI("http://java.azib.net"));
	}
}
