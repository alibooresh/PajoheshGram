package com.example.pajoheshgram.ui.chats;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pajoheshgram.R;

import java.util.ArrayList;
import java.util.List;

public class ChatListFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<ChatItem> chatItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewChats);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // داده ماک
        chatItems = new ArrayList<>();
        chatItems.add(new ChatItem("علی", "سلام خوبی؟", "13:20", R.drawable.avatar_ali));
        chatItems.add(new ChatItem("زهرا", "کجا بودی دیروز؟", "11:15", R.drawable.ic_avatar_placeholder));
        chatItems.add(new ChatItem("مهدی", "اوکی شد", "09:10", R.drawable.avatar_sara));

        ChatAdapter adapter = new ChatAdapter(getContext(), chatItems, item -> {
            Intent intent = new Intent(getContext(), ChatActivity.class);
            intent.putExtra("chat_name", item.getContactName());
            intent.putExtra("avatar_res_id", item.getAvatarUrl());
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);
        return view;
    }
}
