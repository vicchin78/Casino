package casino;

import javax.swing.*;

public class SlotsGame extends ImageIcon implements Playable {

	public static final Slot[] slots = new Slot[3];
	private double input;
	private static final Symbol[] symbols = Symbol.values();
	private static final ImageIcon[] images = new ImageIcon[symbols.length];

	public SlotsGame(double input) {
		this.input = input;
		initializeImages();
		for (int i = 0; i < slots.length; i++) {
			slots[i] = new Slot(images, symbols);
		}
	}

	public double getInput() {
		return this.input;
	}

	public void setInput(double input) {
		this.input = input;
	}

	private void initializeImages() { // will add images later
		images[0] = new ImageIcon();
		images[1] = new ImageIcon();
		images[2] = new ImageIcon();
		images[3] = new ImageIcon();
		images[4] = new ImageIcon();
	}

	private double checkMultiplier() {
		if (allUnique() || allSpecificSymbol(Symbol.SKULL)) {
			return 0;
		} else if (allSpecificSymbol(Symbol.SEVEN)) {
			return 3;
		} else if (allSame()) {
			return 2;
		}
		return 1.5;
	}

	private boolean allUnique() {
		return !(slots[0].isEqualSymbol(slots[1]) || slots[0].isEqualSymbol(slots[2])
				|| slots[1].isEqualSymbol(slots[2]));
	}

	private boolean allSpecificSymbol(Symbol symbol) {
		return allSame() && slots[0].getDisplayedSymbol().equals(symbol);
	}

	private boolean allSame() {
		return slots[0].isEqualSymbol(slots[1]) && slots[0].isEqualSymbol(slots[2]) && slots[1].isEqualSymbol(slots[2]);
	}

	@Override
	public void playGame() {
		for (int i = 0; i < slots.length; i++) {
			slots[i].rollNew();
		}
		input *= checkMultiplier();
	}
}
