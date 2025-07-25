package com.example.pajoheshgram.ui.verify;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.pajoheshgram.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VerifyCodeFragment extends Fragment {

    private EditText inputCode;
    private FloatingActionButton fabVerify;
    private FloatingActionButton fabSignUp;

    public VerifyCodeFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_verify_code, container, false);

        inputCode = root.findViewById(R.id.input_code);
        fabVerify = root.findViewById(R.id.fab_verify);
        fabSignUp = root.findViewById(R.id.fab_sign);

        fabVerify.setOnClickListener(v -> {
            String code = inputCode.getText().toString().trim();
            if (TextUtils.isEmpty(code) || code.length() < 5) {
                Toast.makeText(getContext(), "Please enter the full 5-digit code", Toast.LENGTH_SHORT).show();
                return;
            }
            Navigation.findNavController(v).navigate(R.id.nav_chats);
        });
        fabSignUp.setOnClickListener(v -> {
            String code = inputCode.getText().toString().trim();
            if (TextUtils.isEmpty(code) || code.length() < 5) {
                Toast.makeText(getContext(), "Please enter the full 5-digit code", Toast.LENGTH_SHORT).show();
                return;
            }
            Navigation.findNavController(v).navigate(R.id.nav_signup);
        });

        return root;
    }
}
