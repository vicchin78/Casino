package casino;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuGUI implements ActionListener {

	public static JFrame frame;
	private JLabel title, instructions, balanceDisplay;
	private Container container;
	private JButton slots, blackjack, roulette, quit;
	private final int WIDTH = 720;
	private final int HEIGHT = 1280;
	private static double DEFAULT_BALANCE = 100.00;
	private double balance;

	public MenuGUI(double balance) {
		this.balance = balance;

		frame = new JFrame("Casino");
		setUpFrame(frame);

		title = new JLabel("Welcome to the Casino!!!");
		insertComponent(title, JLabel.CENTER + 35, frame.getY() - 20, frame.getWidth(), 60,
				new Font(("Serif"), Font.BOLD, 60), Color.black);

		instructions = new JLabel("Select a game below!!!");
		insertComponent(instructions, JLabel.CENTER + 225, frame.getY() + 40, frame.getWidth(), 60,
				new Font(("Serif"), Font.BOLD, 30), Color.black);

		balanceDisplay = new JLabel("Current Balance: $" + balance);
		insertComponent(balanceDisplay, JLabel.CENTER + 275, frame.getY() + 80, frame.getWidth(), 60,
				new Font(("Serif"), Font.BOLD, 15), Color.red);

		quit = new JButton("Quit");
		insertButton(quit, 310, 900, 100, 50, new Font(("Serif"), Font.BOLD, 30), Color.black, Color.red);

		slots = new JButton("Slots");
		insertButton(slots, 260, 300, 200, 50, new Font(("Serif"), Font.BOLD, 30), Color.black, Color.yellow);

		blackjack = new JButton("Blackjack");
		insertButton(blackjack, 260, 500, 200, 50, new Font(("Serif"), Font.BOLD, 30), Color.black, Color.pink);

		roulette = new JButton("Roulette");
		insertButton(roulette, 260, 700, 200, 50, new Font(("Serif"), Font.BOLD, 30), Color.black, Color.green);

	}

	public MenuGUI() {
		this(DEFAULT_BALANCE);
	}

	public void setUpFrame(JFrame frame) {
		frame.setVisible(true);
		frame.setBounds(0, 0, WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = frame.getContentPane();
		container.setLayout(null);
		container.setBackground(Color.blue);
	}

	public void insertComponent(JComponent component, int x, int y, int width, int height, Font font, Color color) {
		component.setFont(font);
		component.setBounds(x, y, width, height);
		component.setForeground(color);
		component.setVisible(true);
		container.add(component);
	}

	public void insertButton(JButton button, int x, int y, int width, int height, Font font, Color colorText,
			Color colorBackground) {
		insertComponent(button, x, y, width, height, font, colorText);
		button.setBackground(colorBackground);
		button.addActionListener(this);
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == quit) {
			System.exit(0);
		}
		if (e.getSource() == slots) {
			frame.setVisible(false);
			System.gc();
			new SlotsGUI(this.balance);
		}
		if (e.getSource() == blackjack) {
			frame.setVisible(false);
			System.gc();
			new BlackjackGUI(this.balance);
		}
		if (e.getSource() == roulette) {
			frame.setVisible(false);
			System.gc();
			new RouletteGUI(this.balance);
		}

	}
}
