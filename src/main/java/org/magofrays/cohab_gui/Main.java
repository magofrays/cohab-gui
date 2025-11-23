package org.magofrays.cohab_gui;

import javax.swing.*;

import org.magofrays.cohab_gui.view.MainWindow;

import java.awt.*;

public class Main {
 public static void main(String[] args) {
     SwingUtilities.invokeLater(() -> {
    	 MainWindow window = new MainWindow("приложение");

        
     });
 }
}