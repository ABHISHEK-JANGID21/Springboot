package com.message.service;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.message.dao.IncomingMessageRepository;
import com.message.entity.IncomingMessage;
import com.message.model.MessageRequest;
import com.message.model.MessageResponse;

@Component
public class MessageProcessorService {
	public MessageProcessorService() {
	}

	@Autowired
	private IncomingMessageRepository incomingMessageRepository;

	public MessageResponse generateMessageResponse(MessageRequest messageRequest) {
		UUID uuid = UUID.randomUUID();
		String messageId = uuid.toString();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		MessageResponse messageResponse = new MessageResponse();
		IncomingMessage incomingMessage = new IncomingMessage();
		incomingMessage.setTimeStamp(timestamp);
		incomingMessage.setContent(messageRequest.getContent());
		incomingMessage.setMessageId(messageId);
		incomingMessage.setContext(messageRequest.getContext());
		incomingMessage.setFlowId(messageRequest.getFlow_id());
		incomingMessage.setMessageStatus("MESSAGE_RECEIVED");
		messageResponse.setMessageId(messageId);
		messageResponse.setReceivedTimeStamp(timestamp);
		messageResponse.setMessageStatus("Message Received");
		this.incomingMessageRepository.save(incomingMessage);
		return messageResponse;
	}
}
