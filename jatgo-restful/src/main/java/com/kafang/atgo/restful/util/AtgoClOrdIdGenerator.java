package com.kafang.atgo.restful.util;

import java.time.LocalDate;
import java.time.LocalTime;

public class AtgoClOrdIdGenerator {

	private int incr;
	private long secc;
	private long pid;
	private long dayc;

	private LocalDate currDate;
	// private LocalTime currTime;

	public AtgoClOrdIdGenerator(int pid) {
		if (!(pid > 0 && pid < 921)) {
			throw new IllegalArgumentException("pid == " + pid + " , is too big.");
		}
		this.pid = pid * 100000_00000_000000L;
		this.currDate = LocalDate.now();
		genDayc();
	}

	private void genDayc() {
		this.dayc = (((currDate.getYear() - 2000) * 12 + currDate.getMonth().getValue()) * 31
				+ currDate.getDayOfMonth()) * 100000_000000L;
	}

	public long nextClOrdId() {
		LocalDate nowDate = LocalDate.now();
		if (!(currDate.getDayOfYear() == nowDate.getDayOfYear())) {
			this.currDate = nowDate;
			genDayc();
		}
		LocalTime nowTime = LocalTime.now();
		long nowSecc = (nowTime.getHour() * 3600 + nowTime.getMinute() * 60 + nowTime.getSecond()) * 1000000L;

		if (nowSecc != secc) {
			this.secc = nowSecc;
			this.incr = 0;
		}
		long clOrdID = pid + dayc + secc + incr;
		incr++;
		// 922 33720 36854 775807
		// pid dayc sec incr
		return clOrdID;
	}


}
