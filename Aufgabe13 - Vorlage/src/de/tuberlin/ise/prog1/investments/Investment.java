package de.tuberlin.ise.prog1.investments;

public abstract class Investment implements Sortable {
	// unique id counter
	private static int nextId = 0;

	// unique identifier of this investment
	private final int id;

	public int getId() {
		return id;
	}

	public Investment() {
		this.id = nextId++;
	}

	public int compareTo(Investment l, Investment r) {
		if (l.equals(null) && r.equals(null)) {
			return 0;
		}
		if (l.equals(null) && !r.equals(null)) {
			return -1;
		}
		if (!l.equals(null) && r.equals(null)) {
			return 1;

		} else {
			if (l.netAssetValue() == r.netAssetValue()) {
				if (l.absolutePriceDelta() < r.absolutePriceDelta()) {
					return -1;
				}
				if (l.absolutePriceDelta() > r.absolutePriceDelta()) {
					return 1;
				}
				if (l.absolutePriceDelta() == r.absolutePriceDelta()) {
					return 0;
				}
			}
			if (l.netAssetValue() != r.netAssetValue()) {
				if (l.netAssetValue() < r.netAssetValue()) {
					return -1;
				}
				if (l.netAssetValue() > r.netAssetValue()) {
					return 1;
				}
				if (l.netAssetValue() == r.netAssetValue()) {
					return 0;
				}
			}
		}
		return 0;

	}
	
	public int compareTo(Investment r) {
	          return compareTo(this,r);
	      }

	/**
	 * Calculates the value of this investment
	 * 
	 * @return value of this investment
	 */
	public abstract double netAssetValue();

	/**
	 * Calculates the differences between the current value of this investment
	 * and the initial value of this investment
	 * 
	 * @return absolutePriceDelta
	 */
	public abstract double absolutePriceDelta();

	/**
	 * Calculates the value increas that is expected within a year, can be the
	 * same as netAssetValue if the investment dose not payout any profits
	 * 
	 * @return projectedEarningsPerYear
	 */
	public abstract double projectedEarningsPerYear();

}
