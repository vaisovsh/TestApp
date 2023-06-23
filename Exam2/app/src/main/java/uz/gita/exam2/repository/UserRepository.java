package uz.gita.exam2.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import uz.gita.exam2.model.UserData;

public class UserRepository {
    private static UserRepository repository;
    private List<UserData> users = new ArrayList<>();
    private static SharedPreferences pref;
    private static SharedPreferences.Editor editor;

    private UserRepository() {

    }
    public final static void init(Context context){
        pref = context.getSharedPreferences("Settings", Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public static UserRepository getInstance() {
        if (repository == null)
            repository = new UserRepository();
        return repository;
    }

    public void saveUsers(String login, String password){
        loadUser();
        users.add(new UserData(login, password));
        Gson gson = new Gson();
        String json = gson.toJson(users);
        editor.putString("USERS", json).apply();
    }

    private void loadUser(){
        List<UserData> myUsers;
        Type type = new TypeToken<List<UserData>>() {}.getType();
        Gson gson = new Gson();
        if (!pref.getString("USERS","").isEmpty()) {
            myUsers = gson.fromJson(pref.getString("USERS", ""), type);
            for (int i = 0; i < myUsers.size(); i++) {
                Log.d("TTT", i + "   ");
                users.add(myUsers.get(i));
            }
        }
    }
    public boolean hasUser(String login){
        for (int i = 0; i < users.size(); i++) {
            if (login.equals(users.get(i).getLogin()))
                return true;
        }
        return false;
    }
    public String getUSerPassword(String login){
        loadUser();
        for (int i = 0; i < users.size(); i++) {
            if (login.equals(users.get(i).getLogin()))
                return users.get(i).getPassword();
        }
        return "";
    }
}
