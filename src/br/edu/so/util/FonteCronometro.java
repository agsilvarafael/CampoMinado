package br.edu.so.util;

import java.awt.Font;

public class FonteCronometro {
	
	public static Font fonteRelogio() {
		return new Font(FonteCronometro.class.getResource("/br/edu/so/font/alarm clock.ttf").toString(), 0, 30);
	}

}
