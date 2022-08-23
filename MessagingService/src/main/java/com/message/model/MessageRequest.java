package com.message.model;

import lombok.Data;

@Data
public class MessageRequest {
	private String context;
	private String flow_id;
	private String content;
}
