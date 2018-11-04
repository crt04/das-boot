package com.boot;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	
	@InjectMocks
	private ShipwreckController sc ;
	
	@Mock
	ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGet() {
		Shipwreck sw = new Shipwreck();
		sw.setId(1l);
		
		when(shipwreckRepository.findById(1l).get()).thenReturn(sw);
	
		
		Shipwreck  wreck = sc.get(1L);
		
		verify(shipwreckRepository).findById(1L);
		
		
		assertEquals(1L, wreck.getId().longValue());
		assertThat(wreck.getId(), is(1L) );
		
		
	}

}
