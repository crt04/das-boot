package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(App.class)
//@WebIntegrationTest
public class ShipwreckControllerWebIntegrationTest {
	
	@Test
	public void testListAll() throws IOException {
		
	//	RestTemplate restTemplate2 = new TestRestTemplate();
		RestTemplate restTemplate = new RestTemplate();
		// List<Shipwreck> lsw = new ArrayList<Shipwreck>();

		
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/v1/shipwrecks", String.class);
		
		assertThat(response.getStatusCode(),  equalTo(HttpStatus.OK));
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());
		
     //	assertThat(responseJson.isMissingNode(), is(false));
	    assertThat(responseJson.toString(), equalTo("[]"));
				
	}
	
	

}
