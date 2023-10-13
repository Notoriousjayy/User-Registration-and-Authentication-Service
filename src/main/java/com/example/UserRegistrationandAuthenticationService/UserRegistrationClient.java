package com.example.UserRegistrationandAuthenticationService;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class UserRegistrationClient {

    private final String apiGatewayUrl = "https://your-api-gateway-url/registration"; // Replace with your actual endpoint URL

    public void registerUser(String username, String email, String password) {
        // Create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Create headers with content type and any other required headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create a request body with the user registration data in JSON format
        String requestBody = "{\"username\":\"" + username + "\",\"email\":\"" + email + "\",\"password\":\"" + password + "\"}";

        // Create a request entity with headers and request body
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make the HTTP POST request
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiGatewayUrl, HttpMethod.POST, requestEntity, String.class);

        // Check the HTTP status code
        HttpStatus statusCode = responseEntity.getStatusCode();

        if (statusCode == HttpStatus.OK) {
            // Registration successful
            System.out.println("Registration successful.");
        } else {
            // Registration failed
            System.out.println("Registration failed.");
        }
    }

//    public static void main(String[] args) {
//        UserRegistrationClient client = new UserRegistrationClient();
//        client.registerUser("your_username", "your_email@example.com", "your_password");
//    }
}

