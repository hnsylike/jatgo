package com.kafang.atgo.restful.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity(name = "WS_AUDITTRAIL")
public class WsAuditTrail {
	
	public interface TableColumn {
		String id = "id";
		String username = "username";
		String opType = "opType";
		String describe = "describe";
		String time = "time";
	}
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", length = 100,nullable = true)
	private String username;

	@Column(name = "opType", length = 50,nullable = true)
	private OpType opType;
	
	@Column(name = "describe", length = 500,nullable = true)
	private String describe;
	
	@Column(name = "time",nullable = true)
	private Date time;

}
