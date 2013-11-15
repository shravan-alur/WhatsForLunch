package com.boredatlunch.whatsforlunch.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.boredatlunch.whatsforlunch.Model.Polls.Poll;


public class PollPersistenceService {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public static final String COLLECTION = "polls";
	
	public void savePoll(Poll poll) {
		mongoTemplate.save(poll, COLLECTION);
	}
	
	public List<Poll> getAllPolls() {
		List<Poll> polls = mongoTemplate.findAll(Poll.class, COLLECTION);
		return polls;
	}
	
	public Poll findPollById(String pollId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("pollId").is(pollId));
		Poll poll = mongoTemplate.findOne(query, Poll.class, COLLECTION);
		return poll;
	}
	
	public List<Poll> findPollByCreator(String creatorName) {
		Query query = new Query();
		MongoOperations mongoOperations = (MongoOperations) mongoTemplate;
		query.addCriteria(Criteria.where("creatorName").is("sk"));
		List<Poll> pollsList = mongoOperations.find(query, Poll.class, COLLECTION);
		return pollsList;
	}
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
}
