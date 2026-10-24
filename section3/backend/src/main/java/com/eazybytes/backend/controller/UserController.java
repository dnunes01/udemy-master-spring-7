package com.eazybytes.backend.controller;

import com.eazybytes.backend.dto.UserDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/dummy/users")

public class UserController {

    @GetMapping({"/{userId}/posts/{postId}", "/api/dummy/users/{userId}"})
    public ResponseEntity<String> searchUserPostWithMultiPathVariables(@PathVariable Long userId, @PathVariable(required = false) Long postId) {
        String response = "Fetched user with id: " + userId;

        if (postId != null) {
            response = response + " and post id: " + postId;
        }
//        return response;
        return ResponseEntity.ok(response);
    }

    @GetMapping({"/{userId}/orders/{orderId}", "/api/dummy/users/{userId}"})
    public String searchUserOrderWithMultiPathVariables(@PathVariable(name = "userId") Long customerId, @PathVariable Long orderId) {
        return "Fetched user with id: " + customerId + " and order id: " + orderId;
    }

    @GetMapping({"/{userId}/address/{addressId}", "/api/dummy/users/{userId}"})
    public String searchUserAddressWithMultiPathVariables(@PathVariable Map<String, String> pathVariablesMap) {
        return "Fetched user with id: " + pathVariablesMap.get("userId") + " and order id: " + pathVariablesMap.get("addressId");
    }

    @GetMapping("/search/map")
    public String searchUserWithQueryParams(@RequestParam Map<String, String> requestParams) {
        return "Fetched user with query params: " + requestParams.get("name") + " and gender: " + requestParams.get("gender");
    }

    @GetMapping("/headers")
    public String readRequestHeaders(
            @RequestHeader("User-Agent") String userAgent
            , @RequestHeader(name = "User-Location", required = false) String userLocation) {
        return "Received user agent: " + userAgent + ", and user location: " + userLocation;
    }

    @GetMapping("/headers/map")
    public String readRequestHeadersWithMap(@RequestHeader Map<String, String> requestHeaders) {
        return "Received user agent: " + requestHeaders.get("User-Agent") + ", and user location: " + requestHeaders.get("User-Location");
    }

    @GetMapping("/headers/http-headers")
    public String readRequestHeadersWithHttpHeaders(@RequestHeader HttpHeaders requestHeaders) {
        return "Received user agent: " + requestHeaders.get("User-Agent") + ", and user location: " + requestHeaders.get("User-Location");
    }

    @PostMapping
    public String createUser(@RequestBody UserDto userDto) {
        return "Created user with data: " + userDto;
    }

    @PostMapping("request-entity")
    public ResponseEntity<String> createUserWithRequestEntity(RequestEntity<UserDto> requestEntity) {
        HttpHeaders httpHeaders = requestEntity.getHeaders();
        UserDto userDto = requestEntity.getBody();
        String queryParam = requestEntity.getUrl().getQuery();
        String path = requestEntity.getUrl().getPath();

//        return "Created user with data: " + userDto.toString();
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Custom-Header", "ExampleValue")
                .body("Created user with data: " + userDto.toString());
    }
}