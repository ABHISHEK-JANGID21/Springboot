package com.message.model;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class MessageResponse {
	private String messageId;
	private Timestamp receivedTimeStamp;
	private String messageStatus;
}
