package com.example.instagram.models;

import com.parse.Parse;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import org.json.JSONArray;

import java.util.List;

@ParseClassName("Post")
public class Post extends ParseObject {
    // keys for each column
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";
    private static final String LIKES_KEY = "likes";

    // getters/setters for each column
    public String getDescription() {
        return getString(KEY_DESCRIPTION);
    }

    public void setDescription(String description) {
        put(KEY_DESCRIPTION, description);
    }

    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile) {
        put(KEY_IMAGE, parseFile);
    }

    public String getUsername() {return getParseUser(KEY_USER).getUsername();}

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user) {
        put(KEY_USER, user);
    }

    private List<ParseUser> getLikes() {
        return getList(LIKES_KEY);
    }

    public void setLikes() {
        JSONArray array = new JSONArray();
        put(LIKES_KEY, array);
    }
}
