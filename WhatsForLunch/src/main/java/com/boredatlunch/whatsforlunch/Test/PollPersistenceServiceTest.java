package com.boredatlunch.whatsforlunch.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.boredatlunch.whatsforlunch.Model.Polls.Poll;
import com.boredatlunch.whatsforlunch.Model.Polls.PollItem;
import com.boredatlunch.whatsforlunch.Service.PollPersistenceService;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-Test.xml"} )

public class PollPersistenceServiceTest {
	@Autowired
	@Qualifier("pollPersistenceService")
	PollPersistenceService pollService;
	
	@Autowired
	@Qualifier("poll")
	Poll poll;
	
	@Test
	public void testGetAllPolls() {
		List<Poll> pollsList = pollService.getAllPolls();
		assertTrue(pollsList.size() == 0);
	}
	
	@Test
	public void testSavePoll() {
		//Poll poll = new Poll();
		poll.setPollId(UUID.randomUUID().toString());
		poll.setCreatedTimestamp(new Date());
		poll.setCreatorEmail("test@test.com");
		poll.setCreatorName("TEST");
		
		List<PollItem> itemsList = new ArrayList<PollItem>();
		PollItem item = new PollItem();
		item.setBusinessName("Test icecream");
		item.setBusinessYelpId("123456");
		item.setVoteCount(3);
		itemsList.add(item);
		
		item.setBusinessName("Test custard");
		item.setBusinessYelpId("9875641");
		item.setVoteCount(2);
		itemsList.add(item);
		poll.setPollBusinessesList(itemsList);
		
		getPollService().savePoll(poll);
	}
	
	@Test
	public void testUpdatePoll() {
		//Poll poll = new Poll();
		poll = getPollService().findPollById("51789a8e-fce0-47b7-ac8a-d54c51bbad77");
		poll.setCreatorName("TEST_UPDATER_BOT");
		getPollService().savePoll(poll);
	}
	
	public PollPersistenceService getPollService() {
		return pollService;
	}

	public void setPollService(PollPersistenceService pollService) {
		this.pollService = pollService;
	}
	
	
}
