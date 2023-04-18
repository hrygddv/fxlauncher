package fxlauncher;

import java.io.IOException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class Constants {
	
	private static final ResourceBundle bundleMessage;

	public static FileHandler fileHandler = null;

	static {
		try {
			fileHandler = new FileHandler(".//fxlauncher.log", true);
			fileHandler.setLevel(Level.ALL);
			fileHandler.setFormatter(new SimpleFormatter());
		} catch (IOException e) {
			e.printStackTrace();
		}
		bundleMessage = ResourceBundle.getBundle("Messages");
	}
	
	private Constants() {
	}

	public static String getString(final String pKey) {
		try {
			return bundleMessage.getString(pKey);
		} catch (MissingResourceException e) {
			return String.valueOf('!') + pKey + '!';
		}
	}
}
