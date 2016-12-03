package edu.asu.msse.gnayak2.swingapp;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame jframe = new JFrame("Hello world java swing");

				jframe.setSize(500, 400);
				jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jframe.setVisible(true);
			}
		});

	}

}
