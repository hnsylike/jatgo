package com.kafang.atgo.restful.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity(name = "WS_HARDWARE")
public class WsHardware {
	
	public interface TableColumn {

		String id = "id";
		String userId = "userId";
		String mac = "mac";
		String iip = "iip";
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "userId", nullable = true)
	private int userId;
	
	@Column(name = "mac", nullable = true)
	private String mac;
	
	@Column(name = "iip", nullable = true)
	private String iip;

}
