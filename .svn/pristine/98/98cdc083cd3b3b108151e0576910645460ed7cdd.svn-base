package com.kafang.atgo.backup.service;

public class BackupMsg implements Comparable<BackupMsg> {

	private long sequence;
	private String msgText;

	public BackupMsg(int date, int time, String msgText) {
		this.sequence = date * 1000000000L + time;
		this.msgText = msgText;
	}

	public long getSequence() {
		return sequence;
	}

	public String getMsgText() {
		return msgText;
	}

	@Override
	public int compareTo(BackupMsg o) {
		return this.sequence < o.sequence ? -1 : this.sequence > o.sequence ? 1 : 0;
	}

}
