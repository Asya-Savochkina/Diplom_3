package model;

import org.apache.commons.lang3.RandomStringUtils;

public class UserAuthRequest {
    private String email;
    private String password;

    public UserAuthRequest() {
    }

    public UserAuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private static final String RANDOM_PASSWORD = RandomStringUtils.randomAlphanumeric(6);

    public static UserAuthRequest getCorrectUserLoginAndPassword(CreateTheUserRequest createTheUserRequest) {
        UserAuthRequest userAuthRequest = new UserAuthRequest();
        userAuthRequest.setEmail(createTheUserRequest.getEmail());
        userAuthRequest.setPassword(createTheUserRequest.getPassword());
        return userAuthRequest;
    }
}
