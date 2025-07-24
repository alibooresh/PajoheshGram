package com.example.pajoheshgram.ui.chats;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pajoheshgram.R;

public class ChatActivity extends AppCompatActivity {

    ImageView imageAvatar;
    TextView textTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        imageAvatar = findViewById(R.id.image_chat_avatar);
        textTitle = findViewById(R.id.text_chat_title);

        String name = getIntent().getStringExtra("chat_name");
        int avatarRes = getIntent().getIntExtra("avatar_res_id", R.drawable.ic_avatar_placeholder);

        imageAvatar.setImageResource(avatarRes);
        textTitle.setText(name);
    }
}
