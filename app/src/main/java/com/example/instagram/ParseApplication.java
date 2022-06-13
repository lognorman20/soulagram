package com.example.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Need to register
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("GMMFpMTJIXtiqIkIoQeLH3EGAmjKfKag1wd0cfcF")
                .clientKey("NLf8dlwx0liLFBT4E19hLQp3It2jTi9qc5frkh42")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }


}
