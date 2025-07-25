package com.example.pajoheshgram.ui.chats;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.SearchView;

import com.example.pajoheshgram.R;

import java.util.ArrayList;
import java.util.List;

public class ChatListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ChatAdapter adapter;
    private List<ChatItem> chatItems;
    private List<ChatItem> filteredItems;

    private SearchView searchView;
    private ImageView iconSearch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewChats);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        searchView = view.findViewById(R.id.search_view);
        iconSearch = view.findViewById(R.id.icon_search);

        // داده‌ی ماک اولیه
        chatItems = new ArrayList<>();
        chatItems.add(new ChatItem("علی", "سلام خوبی؟", "13:20", R.drawable.avatar_ali));
        chatItems.add(new ChatItem("زهرا", "کجا بودی دیروز؟", "11:15", R.drawable.ic_avatar_placeholder));
        chatItems.add(new ChatItem("مهدی", "اوکی شد", "09:10", R.drawable.avatar_sara));
        chatItems.add(new ChatItem("نیما", "درست شد", "17:00", R.drawable.ic_avatar_placeholder));
        chatItems.add(new ChatItem("سارا", "تو گروه نوشتم", "19:10", R.drawable.avatar_sara));

        filteredItems = new ArrayList<>(chatItems);

        adapter = new ChatAdapter(getContext(), filteredItems, item -> {
            Intent intent = new Intent(getContext(), ChatActivity.class);
            intent.putExtra("chat_name", item.getContactName());
            intent.putExtra("avatar_res_id", item.getAvatarUrl());
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);

        iconSearch.setOnClickListener(v -> {
            // نمایش یا مخفی‌سازی باکس سرچ
            if (searchView.getVisibility() == View.GONE) {
                searchView.setVisibility(View.VISIBLE);
                searchView.requestFocus();
            } else {
                searchView.setQuery("", false);
                searchView.setVisibility(View.GONE);
                filteredItems.clear();
                filteredItems.addAll(chatItems);
                adapter.notifyDataSetChanged();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String query) { return false; }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterChats(newText);
                return true;
            }
        });

        return view;
    }

    private void filterChats(String query) {
        filteredItems.clear();
        if (TextUtils.isEmpty(query)) {
            filteredItems.addAll(chatItems);
        } else {
            for (ChatItem item : chatItems) {
                if (item.getContactName().toLowerCase().contains(query.toLowerCase()) ||
                        item.getLastMessage().toLowerCase().contains(query.toLowerCase())) {
                    filteredItems.add(item);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }
}
