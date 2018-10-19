package com.kafang.atgo.backup.resend;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResendConfig {

	private int processId;
	private String processName;
	private String resendQueue;
	private List<ResendMessage> resendMessages;

}
