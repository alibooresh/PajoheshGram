package com.example.pajoheshgram.ui.contacts;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pajoheshgram.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ContactsFragment extends Fragment {

    private ContactAdapter adapter;
    private List<Contact> contacts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contacts, container, false);

        RecyclerView recycler = root.findViewById(R.id.recycler_contacts);
        EditText editSearch = root.findViewById(R.id.edit_search);
        FloatingActionButton fabAdd = root.findViewById(R.id.fab_add_contact);

        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        contacts = getMockContacts();
        adapter = new ContactAdapter(contacts);
        recycler.setAdapter(adapter);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filter(s.toString());
            }
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}
        });

        fabAdd.setOnClickListener(v -> showAddContactDialog());

        return root;
    }

    private List<Contact> getMockContacts() {
        List<Contact> list = new ArrayList<>();
        list.add(new Contact("علی","+989031999665", "آخرین بازدید: دیروز", R.drawable.avatar_ali));
        list.add(new Contact("سارا","+989393043585", "آنلاین", R.drawable.avatar_sara));
        list.add(new Contact("رضا","+989123456789" ,"آخرین بازدید: ۲ ساعت پیش", R.drawable.avatar_reza));
        return list;
    }

    private void showAddContactDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.dialog_add_contact, null);

        EditText editName = view.findViewById(R.id.edit_name);
        EditText phone = view.findViewById(R.id.phone_number);
        EditText editLastSeen = view.findViewById(R.id.edit_last_seen);
        Spinner spinnerAvatar = view.findViewById(R.id.spinner_avatar);

        // Fill spinner with avatar options
        String[] avatars = {"پیش‌فرض", "علی", "سارا", "رضا"};
        Integer[] avatarResIds = {
                R.drawable.ic_avatar_placeholder,
                R.drawable.avatar_ali,
                R.drawable.avatar_sara,
                R.drawable.avatar_reza
        };
        ArrayAdapter<String> avatarAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, avatars);
        avatarAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAvatar.setAdapter(avatarAdapter);

        new AlertDialog.Builder(getContext())
                .setTitle("Add New Contact")
                .setView(view)
                .setPositiveButton("Add", (dialog, which) -> {
                    String name = editName.getText().toString().trim();
                    String phoneNumber = phone.getText().toString().trim();
                    String lastSeen = editLastSeen.getText().toString().trim();
                    int avatarRes = avatarResIds[spinnerAvatar.getSelectedItemPosition()];
                    if (!name.isEmpty()) {
                        adapter.addContact(new Contact(name,phoneNumber, lastSeen, avatarRes));
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}


