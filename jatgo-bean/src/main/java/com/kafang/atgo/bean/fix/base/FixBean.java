package com.kafang.atgo.bean.fix.base;

import org.eclipse.collections.api.list.ImmutableList;


public interface FixBean<K extends FixField> {

	ImmutableList<K> getFixFields();

	String toFixMessage() throws FixBeanLegalityException;

	void fromFixMessage(FixMessage fixMessage) throws FixMessageAnalysisException;

}
