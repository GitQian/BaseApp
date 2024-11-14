package com.hsae.myapplication.viewmodel;

import android.app.Application;
import android.util.Log;

import com.hsae.myapplication.base.BaseViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Description:
 *
 * @author: QianSheng
 * @date: 2024/11/13
 */
public class VersionViewModel extends BaseViewModel {
    private final String TAG = getClass().getSimpleName();
    public VersionViewModel(@NonNull Application application) {
        super(application);
    }

    public VersionViewModel(@NonNull Application application, @Nullable Fragment fragment) {
        super(application, fragment);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "qiansheng onCleared");
    }
}
