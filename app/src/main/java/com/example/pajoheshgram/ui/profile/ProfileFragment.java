package com.example.pajoheshgram.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pajoheshgram.R;

public class ProfileFragment extends Fragment {

    private TextView textName, textStatus, textPhone, textBio, textUsername, textDob, textUserId;
    private ImageView profileImage;
    private ImageButton btnEdit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        textName = view.findViewById(R.id.text_name);
        textStatus = view.findViewById(R.id.text_status);
        textPhone = view.findViewById(R.id.text_phone);
        textBio = view.findViewById(R.id.text_bio);
        textUsername = view.findViewById(R.id.text_username);
        textDob = view.findViewById(R.id.text_dob);
        textUserId = view.findViewById(R.id.text_user_id);
        profileImage = view.findViewById(R.id.profile_image);
        btnEdit = view.findViewById(R.id.btn_edit_profile);

        loadMockUser();

        btnEdit.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Edit profile clicked", Toast.LENGTH_SHORT).show();

        });

        return view;
    }

    private void loadMockUser() {
        textName.setText("Ali Developer");
        textStatus.setText("Last seen recently");
        textPhone.setText("+49 123 456789");
        textBio.setText("I love building apps with Java");
        textUsername.setText("@fakeali");
        textDob.setText("1999-06-21");
        textUserId.setText("123456789");
        profileImage.setImageResource(R.drawable.avatar_ali);
    }
}

