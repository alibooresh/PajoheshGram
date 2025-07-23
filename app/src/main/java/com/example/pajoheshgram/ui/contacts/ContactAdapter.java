package com.example.pajoheshgram.ui.contacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pajoheshgram.R;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private List<Contact> contactList;
    private List<Contact> fullList;

    public ContactAdapter(List<Contact> contacts) {
        this.contactList = contacts;
        this.fullList = new ArrayList<>(contacts); // for search
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageAvatar;
        TextView textName, textLastSeen;

        public ViewHolder(View view) {
            super(view);
            imageAvatar = view.findViewById(R.id.image_avatar);
            textName = view.findViewById(R.id.text_name);
            textLastSeen = view.findViewById(R.id.text_last_seen);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.imageAvatar.setImageResource(contact.getAvatarResId());
        holder.textName.setText(contact.getName());
        holder.textLastSeen.setText(contact.getStatus());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public void filter(String query) {
        contactList.clear();
        if (query.isEmpty()) {
            contactList.addAll(fullList);
        } else {
            for (Contact contact : fullList) {
                if (contact.getName().toLowerCase().contains(query.toLowerCase())) {
                    contactList.add(contact);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void addContact(Contact contact) {
        contactList.add(0, contact);
        fullList.add(0, contact);
        notifyItemInserted(0);
    }
}



