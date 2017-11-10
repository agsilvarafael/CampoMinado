package br.edu.so.control;

import java.util.Timer;
import java.util.TimerTask;

import br.edu.so.view.MainFrame;

public class ControleCronometro {

	private static Integer minutos = 0;
	private static Integer segundos = 0;
	private static Timer timer = new Timer();

	public static void iniciaCronometro(MainFrame mFrame) {
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				segundos++;
				if (segundos == 60) {
					segundos = 0;
					minutos++;
				}
				String min = minutos <= 9 ? "0" + minutos : minutos + "";
				String seg = segundos <= 9 ? "0" + segundos : segundos + "";
				mFrame.getLblCronometro().setText(min + ":" + seg);
			}
		}, 0, 1000);
	}

	public static void pararCronometro() {
		timer.cancel();
		timer.purge();
	}

	public static void reiniciarCronometro(MainFrame mFrame) {
		minutos = 0;
		segundos = 0;
		pararCronometro();
		timer = new Timer();
		iniciaCronometro(mFrame);
	}

}
