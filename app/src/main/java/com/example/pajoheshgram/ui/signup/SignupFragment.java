package com.example.pajoheshgram.ui.signup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pajoheshgram.R;
import com.example.pajoheshgram.databinding.FragmentEditProfileBinding;
import com.example.pajoheshgram.databinding.FragmentSignupBinding;
import com.example.pajoheshgram.ui.profile.Profile;

public class SignupFragment extends Fragment {
    private FragmentSignupBinding binding;
    private Profile profile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignupBinding.inflate(inflater, container, false);

        binding.btnSignupSave.setOnClickListener(v -> {
            // Here you would normally update and maybe save via ViewModel
            Navigation.findNavController(v).navigate(R.id.nav_chats);
        });

        return binding.getRoot();
    }

}


