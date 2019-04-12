package it1.studentmanagement.jframe;

import javax.swing.SwingUtilities;

public class App {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					final MainWindow wnd = new MainWindow();
	                wnd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
