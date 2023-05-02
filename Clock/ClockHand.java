public class ClockHand {
	private int value;
	private int limit; // value at which the ClockHand should reset it value to 0, meaning it did a
								// full turn

	public ClockHand(int limit) {
		this.limit = limit;
		this.value = 0;
	}

	public void advance() {
		this.value += 1;
		if (this.value >= this.limit) {
			this.value = 0;
		}
	}

	public int getValue() {
		return this.value;
	}

	public String toString() {
		if (this.value < 10) { // formats values to have 2 digits, eg: 3 turns into 03, and 11 stays the same
			return "0" + this.value;
		}
		return "" + this.value;
	}
}
