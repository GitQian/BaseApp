package com.hsae.myapplication.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

//import com.hsae.engineer.MainActivity;
//import com.hsae.engineer.service.EngineerService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.AndroidViewModel;

/**
 * BaseViewModel
 */
public class BaseViewModel extends AndroidViewModel {

    private final String TAG = getClass().getSimpleName();
    private Fragment fragment;

    public BaseViewModel(@NonNull Application application) {
        this(application, null);
    }

    public BaseViewModel(@NonNull Application application, @Nullable Fragment fragment) {
        super(application);
        Log.d(TAG, "Construct()");
        this.fragment = fragment;
    }

    public void setFragment(Fragment f) {
        this.fragment = f;
    }

    @Override
    protected void onCleared() {
        Log.d(TAG, "onCleared()");
    }

    @NonNull
    public Context getContext() {
        return getApplication().getApplicationContext();
    }

    @NonNull
    public FragmentManager getChildFragmentManager() {
        if (fragment == null) throw new NullPointerException("The object fragment is null.");
        return fragment.getChildFragmentManager();
    }

    @NonNull
    public final String getString(@StringRes int resId) {
        return getContext().getString(resId);
    }

}
