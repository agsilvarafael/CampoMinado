package br.edu.so.util;

import java.awt.Font;

public class FonteCronometro {
	
	public static Font getFonteRelogio() {
		FonteCronometro.class.getResource("/br/edu/so/font/alarmClock.ttf").toString().substring(5);
		return new Font(FonteCronometro.class.getResource("/br/edu/so/font/alarmClock.ttf").toString(), Font.BOLD, 40);
	}

}
