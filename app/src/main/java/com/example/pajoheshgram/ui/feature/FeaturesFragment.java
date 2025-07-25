package com.example.pajoheshgram.ui.feature;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pajoheshgram.R;

import java.util.Arrays;
import java.util.List;

public class FeaturesFragment extends Fragment {

    private RecyclerView featuresRecyclerView;
    private FeaturesAdapter adapter;

    public FeaturesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_features, container, false);

        featuresRecyclerView = view.findViewById(R.id.featuresRecyclerView);
        featuresRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> features = Arrays.asList(
                "✅ ورود با شماره تلفن و تأیید کد",
                "👤 پروفایل و ویرایش اطلاعات کاربر",
                "📋 لیست مخاطبین با جستجو و افزودن",
                "💬 لیست چت‌ها با آخرین پیام و زمان",
                "🔍 جستجو در چت‌ها و مخاطبین",
                "➕ افزودن چت جدید، گروه یا کانال",
                "⚙️ تنظیمات با بخش‌بندی مختلف (چت، امنیت، نوتیف و...)",
                "🌓 تم دارک و گلس‌مورفیسم",
                "🌐 پشتیبانی از زبان‌های مختلف",
                "📱 طراحی به سبک Telegram UI"
        );

        adapter = new FeaturesAdapter(features);
        featuresRecyclerView.setAdapter(adapter);

        return view;
    }
}

