package com.hsae.myapplication.ui.home;

import android.app.Application;
import android.util.Log;

import com.hsae.myapplication.base.BaseViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeViewModel extends BaseViewModel {
    private final String TAG = getClass().getSimpleName();
    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public HomeViewModel(@NonNull Application application, @Nullable Fragment fragment) {
        super(application, fragment);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "qiansheng onCleared");
    }
}