package com.example.pajoheshgram.ui.chats;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pajoheshgram.R;
import com.example.pajoheshgram.ui.message.Message;
import com.example.pajoheshgram.ui.message.MessageAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    ImageView imageAvatar, buttonSend;
    TextView textTitle;
    EditText editMessage;
    RecyclerView recyclerMessages;
    MessageAdapter adapter;
    List<Message> messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        imageAvatar = findViewById(R.id.chat_avatar);
        textTitle = findViewById(R.id.chat_contact_name);
        editMessage = findViewById(R.id.message_input);
        buttonSend = findViewById(R.id.send_button);
        recyclerMessages = findViewById(R.id.chat_recycler_view);

        String name = getIntent().getStringExtra("chat_name");
        int avatarRes = getIntent().getIntExtra("avatar_res_id", R.drawable.ic_avatar_placeholder);

        imageAvatar.setImageResource(avatarRes);
        textTitle.setText(name);

        messageList = new ArrayList<>();
        adapter = new MessageAdapter(messageList);
        recyclerMessages.setLayoutManager(new LinearLayoutManager(this));
        recyclerMessages.setAdapter(adapter);

        // ارسال پیام
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = editMessage.getText().toString().trim();
                if (!messageText.isEmpty()) {
                    messageList.add(new Message(messageText, true));
                    adapter.notifyItemInserted(messageList.size() - 1);
                    recyclerMessages.scrollToPosition(messageList.size() - 1);
                    editMessage.setText("");

                    // پیام دریافت شده فرضی
                    messageList.add(new Message("پاسخ خودکار!", false));
                    adapter.notifyItemInserted(messageList.size() - 1);
                    recyclerMessages.scrollToPosition(messageList.size() - 1);
                }
            }
        });
    }
}