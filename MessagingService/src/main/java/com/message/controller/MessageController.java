package com.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.message.model.MessageRequest;
import com.message.model.MessageResponse;
import com.message.service.MessageProcessorService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageProcessorService messageProcessorService;

	@PostMapping("/publish")
	@ApiOperation(value ="To publish message")
	public MessageResponse addMessage(@RequestBody MessageRequest messageRequest) {
		MessageResponse messageResponse = messageProcessorService.generateMessageResponse(messageRequest);
		return messageResponse;
	}
}
