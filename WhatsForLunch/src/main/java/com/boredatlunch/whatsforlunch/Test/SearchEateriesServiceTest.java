package com.boredatlunch.whatsforlunch.Test;
import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boredatlunch.whatsforlunch.Service.SearchRestaurantServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-Services.xml"})

public class SearchEateriesServiceTest {
	
	@Autowired
	SearchRestaurantServiceImpl searchEateriesService;
	
	@Test
	public void TestSearchByLocation() {
		String response = null;
		//response = searchEateriesService.searchByLatLong("burritos", 30.361471, -87.164326);
		assertNotNull(response);
	}
	
}
