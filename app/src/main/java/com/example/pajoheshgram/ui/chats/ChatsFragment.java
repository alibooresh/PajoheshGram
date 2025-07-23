package com.example.pajoheshgram.ui.chats;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pajoheshgram.R;

import java.util.ArrayList;
import java.util.List;

public class ChatsFragment extends Fragment {

    private ChatsViewModel chatsViewModel;
    private RecyclerView recyclerView;
    private ChatsAdapter adapter;

    public ChatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_chats, container, false);

        recyclerView = root.findViewById(R.id.recycler_chats);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // ViewModel و داده ماک
        chatsViewModel = new ViewModelProvider(this).get(ChatsViewModel.class);
        adapter = new ChatsAdapter(chatsViewModel.getMockChats());
        recyclerView.setAdapter(adapter);

        return root;
    }
}
