package uz.gita.exam2.model;

import android.content.Context;
import android.content.SharedPreferences;

public class UserData {
    private String login;
    private String password;

    public UserData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
