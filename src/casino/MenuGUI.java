package casino;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuGUI implements ActionListener {

	private JFrame frame;
	private JLabel title, instructions, balanceDisplay;
	private Container container;
	private JButton quit;
	private final int WIDTH = 720;
	private final int HEIGHT = 1280;
	public static double DEFAULT_BALANCE = 100;
	private double balance;

	public MenuGUI(double balance) {
		this.balance = balance;
		
		setUpFrame();

		title = new JLabel("Welcome to the Casino!!!");
		insertComponent(title, JLabel.CENTER + 35, frame.getY() - 20, frame.getWidth(), 60,
				new Font(("Serif"), Font.BOLD, 60), Color.black);

		instructions = new JLabel("Select a game below!!!");
		insertComponent(instructions, JLabel.CENTER + 225, frame.getY() + 40, frame.getWidth(), 60,
				new Font(("Serif"), Font.BOLD, 30), Color.black);

		balanceDisplay = new JLabel("Balance: $" + balance);
		insertComponent(balanceDisplay, JLabel.CENTER + 400, frame.getY() + 80, frame.getWidth(), 60,
				new Font(("Serif"), Font.BOLD, 20), Color.red);

		quit = new JButton("Quit");
		insertComponent(quit, 310, 900, 100, 50, new Font(("Serif"), Font.BOLD, 30), Color.black, Color.red);
		quit.addActionListener(this);
	}

	public MenuGUI() {
		new MenuGUI(DEFAULT_BALANCE);
	}

	private void setUpFrame() {
		frame = new JFrame("Casino");
		frame.setVisible(true);
		frame.setBounds(0, 0, WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = frame.getContentPane();
		container.setLayout(null);
	}

	private void insertComponent(JComponent component, int x, int y, int width, int height, Font font, Color color) {
		component.setFont(font);
		component.setBounds(x, y, width, height);
		component.setForeground(color);
		component.setBackground(color);
		component.setVisible(true);
		container.add(component);
	}

	private void insertComponent(JComponent component, int x, int y, int width, int height, Font font, Color colorText,
			Color colorBackground) {
		insertComponent(component, x, y, width, height, font, colorText);
		component.setBackground(colorBackground);
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

	}
}
