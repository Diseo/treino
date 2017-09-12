package com.example.diseomac.treino;

import android.app.Application;
import io.realm.Realm;

/**
 * Created by diseomac on 12/09/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
