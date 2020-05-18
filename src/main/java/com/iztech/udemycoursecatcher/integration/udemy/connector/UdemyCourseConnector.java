package com.iztech.udemycoursecatcher.integration.udemy.connector;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iztech.udemycoursecatcher.integration.udemy.client.Course;

@Service
public class UdemyCourseConnector {

	@Value("${udemy.host}")
	private String host;
	
	private String mapping = "/api-2.0/courses";
	private String urlParams = "?fields[course]=title,discount,url,is_paid,avg_rating,num_reviews,primary_category,primary_subcategory,published_time&ordering=most-reviewed&page_size=2&page=1&subcategory=Web Development|Gaming";
	private String endpoint;
	private RestTemplate rest;
	private HttpHeaders headers;
	private HttpStatus status;

	public UdemyCourseConnector() {
		this.rest = new RestTemplate();
		this.headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "*/*");
		headers.add("Authorization",
				"Basic dkljSkdvRWt5NVZlUzk3MWNpc3ZVakZZaFdlOFlTSURPRmlHZ1RZVDpHVm1kYkVBNnQ0YUNMaUUxZm4zUWhseU9LNXdBbkdqR1Iwd3Q3NEdsUkpnS3ByaGNnYzdIS3pwUnFUTlNTcENuOVVZV3dXWEZ2akZmQ0Q0OU55TWkxbjF6NUI1TUhSTVAyMVFoUnZFOXBvWmFrcU9RYU1hczJEQkxkc3BKbVY5eA==");
	}

	public List<Course> get() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		this.endpoint = host + mapping + urlParams;
		HttpEntity<String> requestEntity = new HttpEntity<String>("", this.headers);
		ResponseEntity<String> responseEntity = rest.exchange(this.endpoint, HttpMethod.GET, requestEntity, String.class);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		JsonNode jsonNode = objectMapper.readTree(responseEntity.getBody());
		String results = jsonNode.get("results").toString();
		List<Course> listCourse = objectMapper.readValue(results, new TypeReference<List<Course>>(){});
		this.setStatus(responseEntity.getStatusCode());
		return listCourse;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
