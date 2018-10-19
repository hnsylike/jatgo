package com.kafang.atgo.bean.fix;

import com.kafang.atgo.bean.fix.enums.MsgType;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;

import com.kafang.atgo.bean.fix.base.BaseFixBean;
import com.kafang.atgo.bean.fix.base.FixMessage;
import com.kafang.atgo.bean.fix.base.FixMessageAnalysisException;
import com.kafang.atgo.bean.fix.field.FixResendEndFlagField;
import com.kafang.atgo.bean.fix.field.collect.FixFieldLists;

public class FixResendEndFlag extends BaseFixBean<FixResendEndFlagField> {


    public FixResendEndFlag() {
        super(MsgType.ResendEndFlag);
    }

    public FixResendEndFlag(FixMessage fixMessage) throws FixMessageAnalysisException {
        super(fixMessage);
    }

    @Override
    public ImmutableList<FixResendEndFlagField> getFixFields() {
        return FixFieldLists.FixResendEndFlagFields;
    }

    @Override
    protected void setAttributes() {
    	
    }

    @Override
    protected MutableMap<FixResendEndFlagField, Object> attributesToMap() {
        return null;
    }

}
