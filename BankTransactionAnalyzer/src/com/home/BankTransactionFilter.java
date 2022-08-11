package com.home;

@FunctionalInterface
public interface BankTransactionFilter<T extends BankTransaction> {
	public boolean test(T arg0);
}
