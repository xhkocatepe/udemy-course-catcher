package com.iztech.udemycoursecatcher.Service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.Data;

@Data
@Service
public class CourseService {

	private String server = "https://www.udemy.com/api-2.0/courses?fields[course]=title,discount,url,is_paid,avg_rating,num_reviews,primary_category,primary_subcategory,published_time&ordering=most-reviewed&page_size=100&page=1&subcategory=Web Development|Gaming";
	private RestTemplate rest;
	private HttpHeaders headers;
	private HttpStatus status;

	public CourseService() {
		this.rest = new RestTemplate();
		this.headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "*/*");
		headers.add("Authorization", "Basic dkljSkdvRWt5NVZlUzk3MWNpc3ZVakZZaFdlOFlTSURPRmlHZ1RZVDpHVm1kYkVBNnQ0YUNMaUUxZm4zUWhseU9LNXdBbkdqR1Iwd3Q3NEdsUkpnS3ByaGNnYzdIS3pwUnFUTlNTcENuOVVZV3dXWEZ2akZmQ0Q0OU55TWkxbjF6NUI1TUhSTVAyMVFoUnZFOXBvWmFrcU9RYU1hczJEQkxkc3BKbVY5eA==");
	}

	public String get() {
		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
		ResponseEntity<String> responseEntity = rest.exchange(server, HttpMethod.GET, requestEntity,
				String.class);
		this.setStatus(responseEntity.getStatusCode());
		return responseEntity.getBody();
	}
}
