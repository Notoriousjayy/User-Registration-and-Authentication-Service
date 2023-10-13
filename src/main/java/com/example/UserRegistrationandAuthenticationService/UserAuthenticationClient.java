package com.example.UserRegistrationandAuthenticationService;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class UserAuthenticationClient {

    private final String apiGatewayUrl = "https://your-api-gateway-url/authentication"; // Replace with your actual endpoint URL

    public String authenticateUser(String username, String password) {
        // Create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Create headers with content type and any other required headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create a request entity with headers and request body (if any)
        // In this example, we assume a JSON request body with username and password
        String requestBody = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make the HTTP POST request
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiGatewayUrl, HttpMethod.POST, requestEntity, String.class);

        // Check the HTTP status code
        HttpStatus statusCode = responseEntity.getStatusCode();

        if (statusCode == HttpStatus.OK) {
            // Authentication successful, and response body contains authentication token
            String authToken = responseEntity.getBody();
            return authToken;
        } else {
            // Authentication failed
            return null;
        }
    }

//    public static void main(String[] args) {
//        UserAuthenticationClient client = new UserAuthenticationClient();
//        String authToken = client.authenticateUser("your_username", "your_password");
//
//        if (authToken != null) {
//            System.out.println("Authentication successful. Auth Token: " + authToken);
//        } else {
//            System.out.println("Authentication failed.");
//        }
//    }
}

