package com.message.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.message.entity.IncomingMessage;

@Component
public interface IncomingMessageRepository extends CrudRepository<IncomingMessage, Integer> {
}
