package com.home;

import java.util.ArrayList;
import java.util.List;

public class Notification {
	private final List<String> errors = new ArrayList<>();
	
	public boolean addError(final String message) {
		return errors.add(message);
	}
	
	public boolean hasErrors() {
		return !errors.isEmpty();
	}
	
	public String errorMessage() {
		return errors.toString();
	}
	
	public List<String> getErrors() {
		return errors;
	}
}
