package casino;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class RouletteGUI extends MenuGUI {

	private JFrame frame;
	private JLabel title, instructions, balanceDisplay;
	private JButton quit, back;
	private double balance;

	public RouletteGUI(double balance) {
		this.balance = balance;

		this.frame = new JFrame("Roulette");
		setUpFrame(this.frame);
		MenuGUI.frame.setVisible(false);

		title = new JLabel("Welcome to Roulette!");
		insertComponent(title, JLabel.CENTER + 75, frame.getY() - 20, frame.getWidth(), 80,
				new Font(("Serif"), Font.BOLD, 60), Color.black);

		instructions = new JLabel("Press Spin to Begin!");
		insertComponent(instructions, JLabel.CENTER + 225, frame.getY() + 40, frame.getWidth(), 50,
				new Font(("Serif"), Font.BOLD, 30), Color.black);

		balanceDisplay = new JLabel("Current Balance: $" + balance);
		insertComponent(balanceDisplay, JLabel.CENTER + 275, frame.getY() + 80, frame.getWidth(), 60,
				new Font(("Serif"), Font.BOLD, 15), Color.red);

		quit = new JButton("Quit");
		insertButton(quit, 310, 1100, 100, 50, new Font(("Serif"), Font.BOLD, 30), Color.black, Color.red);

		back = new JButton("Back to Menu");
		insertButton(back, 210, 1000, 300, 50, new Font(("Serif"), Font.BOLD, 30), Color.black, Color.red);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == quit) {
			System.exit(0);
		}
		if (e.getSource() == back) {
			frame.setVisible(false);
			System.gc();
			new MenuGUI(balance);
		}
	}
}
