package casino;

import java.util.HashMap;

import javax.swing.*;

public class Slot {
	private ImageIcon[] image;
	private Symbol[] symbol;
	private ImageIcon displayedImage;
	private Symbol displayedSymbol;
	private HashMap<ImageIcon, Symbol> imageMap = new HashMap<ImageIcon, Symbol>(); // I just realized now that a
																					// HashMap would have been smarter
																					// than using two different arrays.
																					// Will change implementation later

	public Slot(ImageIcon[] image, Symbol[] symbol) {
		this.image = image;
		this.symbol = symbol;
		rollNew();
	}

	public ImageIcon[] getImage() {
		return this.image;
	}

	public Symbol[] getSymbol() {
		return this.symbol;
	}

	public ImageIcon getDisplayedImage() {
		return this.displayedImage;
	}

	public Symbol getDisplayedSymbol() {
		return this.displayedSymbol;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (this == obj) {
			return true;
		} else if (this.getClass() == obj.getClass()) {
			Slot tempSlot = (Slot) obj;
			if (!(this.getImage().length == tempSlot.getImage().length
					&& this.getSymbol().length == tempSlot.getSymbol().length)) {
				return false;
			}
			for (int i = 0; i < this.getSymbol().length; i++) {
				if (!this.getSymbol()[i].equals(tempSlot.getSymbol()[i])) {
					return false;
				}
				return true;
			}
		}
		return false;
	}

	public boolean isEqualSymbol(Object obj) {
		if (obj == null) {
			return false;
		} else if (this == obj) {
			return true;
		} else if (this.getClass() == obj.getClass()) {
			Slot tempSlot = (Slot) obj;
			if (this.displayedSymbol.equals(tempSlot.displayedSymbol)) {
				return true;
			}
		}
		return false;
	}

	public void rollNew() {
		int displayIndex = (int) (Math.random() * this.image.length);
		this.displayedImage = this.image[displayIndex];
		this.displayedSymbol = this.symbol[displayIndex];
	}

}
