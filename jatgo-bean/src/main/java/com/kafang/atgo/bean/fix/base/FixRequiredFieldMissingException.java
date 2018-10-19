package com.kafang.atgo.bean.fix.base;

import com.kafang.atgo.AtgoException;

public class FixRequiredFieldMissingException extends AtgoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FixRequiredFieldMissingException(FixField field) {
		super("[FieldName -> " + field.getGeneralFixField().fieldName() + " | Tag -> " + field.getGeneralFixField().tag()
				+ "] is null!");
	}

}
