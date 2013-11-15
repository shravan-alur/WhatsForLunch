package com.boredatlunch.whatsforlunch.Test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-Test.xml"} )

public class PollPersistenceServiceTest {
	/*@Autowired
	@Qualifier("pollPersistenceService")
	PollPersistenceService pollService;
	
	@Test
	public void testGetAllPolls() {
		List<Poll> pollsList = pollService.getAllPolls();
		assertNotNull(pollsList);
		assertTrue(pollsList.size() >= 1);
	}*/
}
