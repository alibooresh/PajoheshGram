package com.example.pajoheshgram.ui.setting;

public class SettingsItem {
    private final int iconResId;
    private final String title;

    public SettingsItem(int iconResId, String title) {
        this.iconResId = iconResId;
        this.title = title;
    }

    public int getIconResId() {
        return iconResId;
    }

    public String getTitle() {
        return title;
    }
}

