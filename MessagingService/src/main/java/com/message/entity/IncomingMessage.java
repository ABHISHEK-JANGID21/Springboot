package com.message.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "t_incoming_message")
@ApiModel(description = "Incoming message details")
public class IncomingMessage {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "message_id")
	private String messageId;

	@Column(name = "flow_id")
	private String flowId;

	@Column(name = "context")
	private String context;

	@Column(name = "message_status")
	private String messageStatus;

	@Column(name = "time_stamp")
	private Timestamp timeStamp;
	
	@Column(name = "message_content")
	private String content;
}
