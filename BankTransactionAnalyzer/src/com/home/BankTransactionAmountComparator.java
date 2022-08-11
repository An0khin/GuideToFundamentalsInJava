package com.home;

import java.util.Comparator;

public class BankTransactionAmountComparator<T extends BankTransaction> implements Comparator<T> {

	@Override
	public int compare(T arg0, T arg1) {
		if(arg0.getAmount() > arg1.getAmount())
			return 1;
		if(arg0.getAmount() < arg1.getAmount())
			return -1;
		return 0;
	}
	
}
