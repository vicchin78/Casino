package casino;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class SlotsGUI extends MenuGUI {

	private JFrame frame;
	private JLabel title, instructions, balanceDisplay, insert;
	private JButton quit, back;
	private final JButton[] MONEY_BUTTONS = new JButton[3];
	private final int[] MONEY_VALUES = { 10, 50, 100 };
	private double balance;

	public SlotsGUI(double balance) {
		this.balance = balance;

		this.frame = new JFrame("Slots");
		setUpFrame(this.frame);
		MenuGUI.frame.setVisible(false);

		title = new JLabel("Welcome to Slots!");
		insertComponent(title, JLabel.CENTER + 130, frame.getY() - 20, frame.getWidth(), 60,
				new Font(("Serif"), Font.BOLD, 60), Color.black);

		instructions = new JLabel("Press Roll to Begin!");
		insertComponent(instructions, JLabel.CENTER + 225, frame.getY() + 40, frame.getWidth(), 60,
				new Font(("Serif"), Font.BOLD, 30), Color.black);

		balanceDisplay = new JLabel("Current Balance: $" + balance);
		insertComponent(balanceDisplay, JLabel.CENTER + 275, frame.getY() + 80, frame.getWidth(), 60,
				new Font(("Serif"), Font.BOLD, 15), Color.red);

		quit = new JButton("Quit");
		insertButton(quit, 310, 1100, 100, 50, new Font(("Serif"), Font.BOLD, 30), Color.black, Color.red);

		back = new JButton("Back to Menu");
		insertButton(back, 210, 1000, 300, 50, new Font(("Serif"), Font.BOLD, 30), Color.black, Color.red);

		insert = new JLabel("Insert Money:");
		insertComponent(insert, JLabel.CENTER + 275, quit.getY() - 380, frame.getWidth(), 60,
				new Font(("Serif"), Font.BOLD, 30), Color.black);

		for (int i = 0; i < MONEY_BUTTONS.length; i++) {
			MONEY_BUTTONS[i] = new JButton("$" + MONEY_VALUES[i]);
			if (i != 0) {
				insertButton(MONEY_BUTTONS[i], MONEY_BUTTONS[i - 1].getX() + 200, MONEY_BUTTONS[i - 1].getY(), 100, 100,
						new Font(("Serif"), Font.BOLD, 30), Color.black, Color.green);
			} else {
				insertButton(MONEY_BUTTONS[i], 110, 820, 100, 100, new Font(("Serif"), Font.BOLD, 30), Color.black,
						Color.green);
			}
		}

	}

	private void displayInvalidBalance() {
		JOptionPane.showMessageDialog(null, "You do not have enough money to roll that amount", "Not Enough Money",
				JOptionPane.PLAIN_MESSAGE);
	}

	private void handleTransaction(int price) {
		if (price > balance) {
			displayInvalidBalance();
		} else {
			SlotsGame game = new SlotsGame(price);
			game.playGame();
			balance += (game.getInput() - price);
			balanceDisplay.setText("Current Balance: $" + balance);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == quit) {
			System.exit(0);
		}
		if (e.getSource() == back) {
			frame.dispose();
			System.gc();
			new MenuGUI(balance);
		}
		if (e.getSource() == MONEY_BUTTONS[0]) {
			handleTransaction(MONEY_VALUES[0]);
		}
		if (e.getSource() == MONEY_BUTTONS[1]) {
			handleTransaction(MONEY_VALUES[1]);
		}
		if (e.getSource() == MONEY_BUTTONS[2]) {
			handleTransaction(MONEY_VALUES[2]);
		}
	}
}
