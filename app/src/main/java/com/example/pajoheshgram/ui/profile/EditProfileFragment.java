package com.example.pajoheshgram.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pajoheshgram.R;
import com.example.pajoheshgram.databinding.FragmentEditProfileBinding;

public class EditProfileFragment extends Fragment {
    private FragmentEditProfileBinding binding;
    private Profile profile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEditProfileBinding.inflate(inflater, container, false);

        profile = getDummyProfile();

        binding.editName.setText(profile.getName());
        binding.editPhone.setText(profile.getPhoneNumber());
        binding.editBio.setText(profile.getBio());
        binding.editUsername.setText(profile.getUsername());
        binding.editBirthdate.setText(profile.getBirthday());
        binding.editUserId.setText(profile.getUserId());

        binding.btnSave.setOnClickListener(v -> {
            // Here you would normally update and maybe save via ViewModel
            NavHostFragment.findNavController(this).navigateUp();
        });

        return binding.getRoot();
    }

    private Profile getDummyProfile() {
        return new Profile(R.drawable.avatar_ali, "Ali Booresh", "Last seen recently",
                "+98 912 000 0000", "Java Developer", "ali_dev", "1378/01/13", "ID123456");
    }
}


