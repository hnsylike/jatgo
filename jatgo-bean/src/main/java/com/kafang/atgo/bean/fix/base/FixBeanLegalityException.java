package com.kafang.atgo.bean.fix.base;

import com.kafang.atgo.AtgoException;

public class FixBeanLegalityException extends AtgoException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5366982390266114018L;

	public FixBeanLegalityException(String message) {
		super(message);
	}

	public FixBeanLegalityException(String message, Throwable cause) {
		super(message, cause);
	}

	public FixBeanLegalityException(Throwable cause) {
		super("Please check FixBean object fields", cause);
	}

}
