package com.example.pajoheshgram.ui.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.pajoheshgram.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class LoginFragment extends Fragment {

    private EditText inputPhone, inputCountry;
    private Spinner countrySpinner;
    private CheckBox checkSync;
    private FloatingActionButton fabNext;

    public LoginFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_login, container, false);
        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("Iran", "+98"));
        countryList.add(new Country("Germany", "+49"));
        countryList.add(new Country("United States", "+1"));
        countrySpinner = root.findViewById(R.id.input_country_code);

//        inputCountryCode = root.findViewById(R.id.input_country_code);
        inputPhone = root.findViewById(R.id.input_phone);
        checkSync = root.findViewById(R.id.check_sync_contacts);
        fabNext = root.findViewById(R.id.fab_next);
        Spinner countrySpinnerData = root.findViewById(R.id.input_country_code);
        ArrayAdapter<Country> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                countryList
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinnerData.setAdapter(adapter);
        fabNext.setOnClickListener(v -> {
            countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Country selectedCountry = (Country) parent.getItemAtPosition(position);
                    String code = selectedCountry.getCode();
                    inputCountry.setText(code);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
//            String code = inputCountry.getText().toString().trim();
            String phone = inputPhone.getText().toString().trim();
            boolean sync = checkSync.isChecked();

            if (TextUtils.isEmpty(phone)) {
                Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

//            Toast.makeText(getContext(), "Country: +" + code + "\nPhone: " + phone + "\nSync: " + sync, Toast.LENGTH_LONG).show();
            Navigation.findNavController(v).navigate(R.id.nav_verify_code);
        });

        return root;
    }
}
