package com.practice.springbootbatchapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class SpringbootBatchAppApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void loadProductsFromCsvToDatabase() throws Exception {

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/load/fileData")
						.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		Assert.assertEquals("\"COMPLETED\"", mvcResult.getResponse().getContentAsString());
		System.out.println("Batch Status:::"+mvcResult.getResponse().getContentAsString());

	}

}
