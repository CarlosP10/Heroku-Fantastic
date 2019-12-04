package com.fantasticCode.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


import org.apache.jasper.tagplugins.jstl.core.When;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantasticCode.repositories.OfferRepository;
import com.fantasticCode.repositories.Offer_type_Repository;
import com.fantasticCode.service.OfferService;
import com.fantasticCode.service.Offer_type_Service;


public class OfferTestUnit {

	@Autowired
	private OfferRepository offer_repository;
	
	private OfferService offerService;
	
	Offer test;
	
	@Before
	public void setUp(){
		test = new Offer(1, 
							"offer name", 
							"offer description", 
							"10", 
							"https://www.sciencemag.org/sites/default/files/styles/inline__450w__no_aspect/public/dogs_1280p_0.jpg?itok=4t_1_fSJ.jpg",
							1,
							new GregorianCalendar(2019, Calendar.NOVEMBER, 24).getTime(),
							new GregorianCalendar(2019, Calendar.NOVEMBER, 28).getTime(),
							"SVPROMO",
							1,
							(float) 20.0,
							new Offer_type(1, "comida"),
							new Date()
				);
	}
	
	@Test
	public void testEndDate() {
		assertTrue(test.setEnddate(new GregorianCalendar(2019, Calendar.NOVEMBER, 28).getTime()));
		assertFalse(test.setEnddate(new GregorianCalendar(2019, Calendar.NOVEMBER, 23).getTime()));
	}
	
	@Test
	public void priceTest() {
		assertTrue(test.setPrice_range(20));
		assertFalse(test.setPrice_range(-5));
	}
	
	@Test
	public void urlTest() {
		assertTrue(test.setUrlposter("https://www.sciencemag.org/sites/default/files/styles/inline__450w__no_aspect/public/dogs_1280p_0.jpg?itok=4t_1_fSJ.jpg"));
		assertTrue(test.setUrlposter("\"https://www.sciencemag.org/sites/default/files/styles/inline__450w__no_aspect/public/dogs_1280p_0.jpg?itok=4t_1_fSJ.png"));
		assertFalse(test.setUrlposter("\"https://www.sciencemag.org/sites/default/files/styles/inline__450w__no_aspect/public/dogs_1280p_0.jpg?itok=4t_1_fSJ.jpn"));
		
	}
	
	
}
