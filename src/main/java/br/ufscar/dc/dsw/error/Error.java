package br.ufscar.dc.dsw.error;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Error implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final List<String> error;

	public Error() {
		error = new ArrayList<>();
	}

	public Error(String message) {
		error = new ArrayList<>();
		error.add(message);
	}

	public void add(String message) {
		error.add(message);
	}

	public boolean isThereError() {
		return !error.isEmpty();
	}

	public List<String> getError() {
		return error;
	}
}
