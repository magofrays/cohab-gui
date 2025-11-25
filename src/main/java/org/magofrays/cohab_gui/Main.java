package org.magofrays.cohab_gui;

import javax.swing.SwingUtilities;

import org.magofrays.cohab_gui.view.MainWindow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		ApplicationContext context = SpringApplication.run(Main.class, args);
		SwingUtilities.invokeLater(() -> {
			MainWindow window = context.getBean(MainWindow.class);
		});
 }
}