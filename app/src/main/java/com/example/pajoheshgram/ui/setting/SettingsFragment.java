package com.example.pajoheshgram.ui.setting;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pajoheshgram.R;

import java.util.Arrays;
import java.util.List;

public class SettingsFragment extends Fragment {

    private RecyclerView recyclerView;
    private SettingsAdapter adapter;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.settings_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        List<SettingsItem> settingsItems = Arrays.asList(
                new SettingsItem(R.drawable.ic_chat, "Chat Setting"),
                new SettingsItem(R.drawable.ic_lock, "Privacy And Security"),
                new SettingsItem(R.drawable.ic_notifications, "Notifications"),
                new SettingsItem(R.drawable.ic_data_usage, "Data And Storage"),
                new SettingsItem(R.drawable.ic_battery_saver, "Power Saving"),
                new SettingsItem(R.drawable.ic_folder, "Folder Setting"),
                new SettingsItem(R.drawable.ic_devices, "Devices"),
                new SettingsItem(R.drawable.ic_language, "Language")
        );

        adapter = new SettingsAdapter(settingsItems);
        recyclerView.setAdapter(adapter);
    }
}
