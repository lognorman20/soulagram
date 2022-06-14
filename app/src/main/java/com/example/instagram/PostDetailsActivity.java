package com.example.instagram;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

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
        tvCreatedAt.setText(post.getCreatedAt().toString());
        Glide.with(PostDetailsActivity.this).load(post.getImage().getUrl()).centerCrop().into(ivDetailedPostImage);
    }
}
