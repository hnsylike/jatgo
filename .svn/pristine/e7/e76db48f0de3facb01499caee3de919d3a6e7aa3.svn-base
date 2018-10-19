package com.kafang.atgo.restful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.kafang.atgo.persistence.db.base.entity.SimpleEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "WS_PHONE")
public class WsPhone implements SimpleEntity {

	public interface TableColumn {
		String id = "id";
		String phone = "phone";
		String userID = "userID";
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "phone", length = 32, nullable = false)
	private String phone;

	@Column(name = "userID")
	private Long userId;

}
