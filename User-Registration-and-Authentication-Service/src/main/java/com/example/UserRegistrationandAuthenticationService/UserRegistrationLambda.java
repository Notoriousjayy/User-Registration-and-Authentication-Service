package com.example.UserRegistrationandAuthenticationService;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.CognitoEvent;

public class UserRegistrationLambda implements RequestHandler<CognitoEvent, Void> {

    @Override
    public Void handleRequest(CognitoEvent event, Context context) {
        // Extract user registration data from the event
        String username = event.getRequest().getUserAttributes().get("username");
        String email = event.getRequest().getUserAttributes().get("email");

        // Store user data in your database or perform other registration tasks
        // ...

        return null;
    }
}
