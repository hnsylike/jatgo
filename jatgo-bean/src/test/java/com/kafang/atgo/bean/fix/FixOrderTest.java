package com.kafang.atgo.bean.fix;

import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import com.kafang.atgo.bean.fix.base.FixBeanLegalityException;
import com.kafang.atgo.bean.fix.base.FixMessage;
import com.kafang.atgo.bean.fix.base.FixMessageAnalysisException;

@Slf4j
public class FixOrderTest {

	@Test
	public void test() {
		FixOrder fixOrder = FixOrder.buildFixOrder();

		fixOrder.setSendingTime(LocalDateTime.now());
		fixOrder.setClOrdId(1000000000L);
		fixOrder.setClientId(100075);// 母账户编号 100075 100150 100006
		fixOrder.setHandlInst(1);// 委托级别
		fixOrder.setSymbol(600000);// 6位股票代码
		fixOrder.setSecurityExchange(2);// 交易所类型,SH上海
		fixOrder.setSecurityType(0);// 证券类型CS
		fixOrder.setSide(1);
		fixOrder.setTransactTime(LocalDateTime.now());// 委托发送时间
		fixOrder.setOrderQty(1000);// 委托股数
		fixOrder.setOrdType(0);// 委托类型
		fixOrder.setPrice(20.00D);// 委托价格
		try {
			String fixString;
			fixString = fixOrder.toFixMessage();
			log.info(fixString);
			FixMessage fixMessage = new FixMessage(fixString);
			log.info(fixMessage.getMsgType() + "");
			try {
				@SuppressWarnings("unused")
				FixOrder order = new FixOrder(fixMessage);
			} catch (FixMessageAnalysisException e) {
				log.error("", e);
			}
		} catch (FixBeanLegalityException e1) {
			log.error("", e1);
		}

	}

}
