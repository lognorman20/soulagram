package com.example.instagram;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import java.util.Date;

public class PostDetailsActivity extends AppCompatActivity {
    private Post post;
    private ImageView ivDetailedPostImage;
    private TextView tvDetailedDescription;
    private TextView tvDetailedUsername;
    private TextView tvCreatedAt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        ivDetailedPostImage = (ImageView) findViewById(R.id.ivDetailedPostImage);
        tvDetailedDescription = (TextView) findViewById(R.id.tvDetailedDescription);
        tvDetailedUsername = (TextView) findViewById(R.id.tvDetailedUsername);
        tvCreatedAt = (TextView) findViewById(R.id.tvCreatedAt);

        // unwrapping the post from the adapter
        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra("post"));
        tvDetailedDescription.setText(post.getDescription());
        tvDetailedUsername.setText(post.getUsername());
        tvCreatedAt.setText(calculateTimeAgo(post.getCreatedAt()));
        Glide.with(PostDetailsActivity.this).load(post.getImage().getUrl()).centerCrop().into(ivDetailedPostImage);
    }

    public static String calculateTimeAgo(Date createdAt) {

        int SECOND_MILLIS = 1000;
        int MINUTE_MILLIS = 60 * SECOND_MILLIS;
        int HOUR_MILLIS = 60 * MINUTE_MILLIS;
        int DAY_MILLIS = 24 * HOUR_MILLIS;

        try {
            createdAt.getTime();
            long time = createdAt.getTime();
            long now = System.currentTimeMillis();

            final long diff = now - time;
            if (diff < MINUTE_MILLIS) {
                return "just now";
            } else if (diff < 2 * MINUTE_MILLIS) {
                return "a minute ago";
            } else if (diff < 50 * MINUTE_MILLIS) {
                return diff / MINUTE_MILLIS + " m";
            } else if (diff < 90 * MINUTE_MILLIS) {
                return "an hour ago";
            } else if (diff < 24 * HOUR_MILLIS) {
                return diff / HOUR_MILLIS + " h";
            } else if (diff < 48 * HOUR_MILLIS) {
                return "yesterday";
            } else {
                return diff / DAY_MILLIS + " d";
            }
        } catch (Exception e) {
            Log.i("Error:", "getRelativeTimeAgo failed", e);
            e.printStackTrace();
        }

        return "";
    }
}
