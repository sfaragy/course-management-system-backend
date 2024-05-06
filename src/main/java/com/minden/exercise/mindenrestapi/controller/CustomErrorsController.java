package com.minden.exercise.mindenrestapi.controller;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestController
public class CustomErrorsController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public CustomErrorsController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public String handleError(WebRequest webRequest) {
        // Get error attributes map from the request
        Map<String, Object> errorAttributesMap = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE));

        // Extract the error message from the error attributes map
        String errorMessage = (String) errorAttributesMap.get("message");

        // Return the error message
        return "An error occurred: " + errorMessage;
    }

    public String getErrorPath() {
        return "/error";
    }
}
