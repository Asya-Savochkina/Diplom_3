package model;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class CreateTheUserRequest {
    private String email;
    private String password;
    private String name;

    public CreateTheUserRequest() {
    }

    public CreateTheUserRequest(String name, String email, String password) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static CreateTheUserRequest getUserAllRequiredField() {
        String name = RandomStringUtils.randomAlphabetic(5);
        String email = RandomStringUtils.randomAlphabetic(5) + "@mail.ru";
        String password = RandomStringUtils.randomAlphabetic(8);
        return new CreateTheUserRequest(name, email, password);
    }

    public static CreateTheUserRequest getUserWrongPassword() {
        String name = RandomStringUtils.randomAlphabetic(5);
        String email = RandomStringUtils.randomAlphabetic(5) + "@mail.ru";
        String password = RandomStringUtils.randomAlphabetic(2);
        return new CreateTheUserRequest(name, email, password);
    }

    public static String createRandomEmail() {
        return RandomStringUtils.randomAlphanumeric(5) + "@example.ru";
    }

    public static String createRandomName() {
        return RandomStringUtils.randomAlphanumeric(7);
    }
}
