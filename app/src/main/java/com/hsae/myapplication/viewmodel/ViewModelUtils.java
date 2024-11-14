package com.hsae.myapplication.viewmodel;

import android.app.Application;


import com.hsae.myapplication.viewmodel.HomeViewModel;
import com.hsae.myapplication.viewmodel.VersionViewModel;

import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

/**
 * ViewModelUtils
 */
public class ViewModelUtils {

    private ViewModelUtils() { /* cannot be instantiated */ }

    @NonNull
    public static <T extends ViewModel> T getViewModel(@NonNull ComponentActivity activity,
            Class<T> cls) {
        ViewModelProvider.Factory factory = new ViewModelFactory(activity.getApplication(), activity);
        return new ViewModelProvider(activity.getViewModelStore(), factory).get(cls);
    }

    @NonNull
    public static <T extends ViewModel> T getViewModel(@NonNull Fragment frag, Class<T> cls) {
        ViewModelProvider.Factory f = new ViewModelFactory(frag.requireActivity().getApplication(), frag);
        return new ViewModelProvider(frag.getViewModelStore(), f).get(cls);
    }

    @NonNull
    public static <T extends ViewModel> T getGlobalVm(@NonNull ViewModelStoreOwner viewModelStore,
            @NonNull Class<T> cls) {
        return new ViewModelProvider(viewModelStore).get(cls);
    }

    private static class ViewModelFactory implements ViewModelProvider.Factory {

        private final LifecycleOwner lifecycle;
        private final Application app;

        public ViewModelFactory(Application app, LifecycleOwner lifecycle) {
            this.app = app;
            this.lifecycle = lifecycle;
        }

        @SuppressWarnings("unchecked")
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            if (modelClass.isAssignableFrom(HomeViewModel.class)) {
                return (T) new HomeViewModel(app);
            } else if (modelClass.isAssignableFrom(VersionViewModel.class)) {
                return (T) new VersionViewModel(app);
            }
            throw new IllegalArgumentException("Class that has not been registed: " + modelClass.getName());
        }

    }

}
