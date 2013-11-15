package com.boredatlunch.whatsforlunch.Test;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boredatlunch.whatsforlunch.Service.SearchRestaurantServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-Test.xml"})

public class SearchEateriesServiceTest {
	
	@Qualifier("searchRestaurantService")
	SearchRestaurantServiceImpl searchRestaurantService;
	
	@Test
	public void TestSearchByLocation() {
		String response = searchRestaurantService.searchYelpByLocation("ice cream", "raleigh");
		
		assertNotNull(response);
		assertTrue(response.length() >= 0);
	}

	public SearchRestaurantServiceImpl getSearchRestaurantService() {
		return searchRestaurantService;
	}

	public void setSearchRestaurantService(
			SearchRestaurantServiceImpl searchRestaurantService) {
		this.searchRestaurantService = searchRestaurantService;
	}
	
	
}
