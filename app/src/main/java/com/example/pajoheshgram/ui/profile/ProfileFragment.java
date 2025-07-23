package com.example.pajoheshgram.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pajoheshgram.R;
import com.example.pajoheshgram.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);

        Profile profile = getDummyProfile(); // Mock data

        binding.textName.setText(profile.getName());
        binding.textStatus.setText(profile.getStatus());
        binding.profileImage.setImageResource(profile.getAvatarResId());

        binding.textPhone.setText(profile.getPhoneNumber());
        binding.textBio.setText(profile.getBio());
        binding.textUsername.setText(profile.getUsername());
        binding.textDob.setText(profile.getBirthday());
        binding.textUserId.setText(profile.getUserId());

        binding.btnEditProfile.setOnClickListener(v -> {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_profileFragment_to_editProfileFragment);
        });

        return binding.getRoot();
    }

    private Profile getDummyProfile() {
        return new Profile(R.drawable.avatar_ali, "Ali Booresh", "Last seen recently",
                "+98 912 000 0000", "Java Developer", "ali_dev", "1378/01/13", "ID123456");
    }
}
