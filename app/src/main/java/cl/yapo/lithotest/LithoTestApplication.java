package cl.yapo.lithotest;

import android.app.Application;

import com.facebook.soloader.SoLoader;


public class LithoTestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SoLoader.init(this, false);
    }
}
