package com.pp.sun.program;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertListToMap {
    public static void main(String[] args) {

        List<User> list = Arrays.asList(
                new User("Rama1","ram"),
                new User("Siva1","shiva"),
                new User("Bhole1","BHole"),
                new User("Bhole1","BHole")
        );

        Map<String,String> map = list.stream().collect(Collectors.toMap(
                User::getUserName,
                User::getPassword,
                (ext,dup)->ext
        ));
        System.out.println(map);
    }


}

class User {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
