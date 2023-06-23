package uz.gita.exam2.repository;

import android.app.Application;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UserRepository.init(this);
    }
}
