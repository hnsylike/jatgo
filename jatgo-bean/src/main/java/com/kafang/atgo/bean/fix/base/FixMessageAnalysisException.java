package com.kafang.atgo.bean.fix.base;

import com.kafang.atgo.AtgoException;

public class FixMessageAnalysisException extends AtgoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5450155517862849252L;

	public FixMessageAnalysisException(String message) {
		super(message);
	}

	public FixMessageAnalysisException(String message, Throwable cause) {
		super(message, cause);
	}

	public FixMessageAnalysisException(Throwable cause) {
		super("Please check message text", cause);
	}

}
