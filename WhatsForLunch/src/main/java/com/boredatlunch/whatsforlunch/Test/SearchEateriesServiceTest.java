package com.boredatlunch.whatsforlunch.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.boredatlunch.whatsforlunch.Service.SearchRestaurantService;
import com.boredatlunch.whatsforlunch.Service.SearchRestaurantServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-Test.xml")
@TestExecutionListeners( {DependencyInjectionTestExecutionListener.class})
public class SearchEateriesServiceTest {
	@Autowired
	@Qualifier("searchRestaurantService")
	SearchRestaurantServiceImpl searchRestaurantService;
	
	@Test
	public void TestSearchByLocation() {
		String response = searchRestaurantService.searchYelpByLocation("ice cream", "raleigh");
		assertNotNull(response);
		assertTrue(response.length() >= 0);
	}
	
	@Test
	public void testSearchBusinessById() {
		String response = searchRestaurantService.searchYelpByBusiness("tom-yum-thai-cary");
		assertNotNull(response);
	}
	
	public SearchRestaurantServiceImpl getSearchRestaurantService() {
		return searchRestaurantService;
	}

	public void setSearchRestaurantService(
			SearchRestaurantServiceImpl searchRestaurantService) {
		this.searchRestaurantService = searchRestaurantService;
	}
}
