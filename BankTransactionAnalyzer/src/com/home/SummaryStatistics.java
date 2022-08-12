package com.home;

public class SummaryStatistics {
	private final double max;
	private final double min;
	private final double average;
	private final double sum;
	
	public SummaryStatistics(final double max, final double min, final double average, final double sum) {
		super();
		this.max = max;
		this.min = min;
		this.average = average;
		this.sum = sum;
	}

	public double getMax() {
		return max;
	}

	public double getMin() {
		return min;
	}

	public double getAverage() {
		return average;
	}

	public double getSum() {
		return sum;
	}
	
}
