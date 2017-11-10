package br.edu.so.util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class FonteCronometro {

	public static Font getFonteRelogio() {
		Font clock = null;
		try {
			clock = Font
					.createFont(Font.TRUETYPE_FONT, new File(FonteCronometro.class
							.getResource("/br/edu/so/font/alarmClock.ttf").toString().substring(5)))
					.deriveFont(Font.BOLD, 50);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(clock);
		} catch (FontFormatException | IOException e) {
			System.err.println(e.getMessage());
		}
		return clock;
	}

}
