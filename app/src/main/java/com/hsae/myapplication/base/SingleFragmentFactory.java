package com.hsae.myapplication.base;

import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

/**
 * SingleFragmentFactory
 *
 * <p>存在已初始化的 fragment 对象时，复用该对象</p>
 */
public class SingleFragmentFactory extends FragmentFactory {

    /**
     * 已初始化的Fragment对象
     */
    private final SimpleArrayMap<String, Fragment> mInitialized = new SimpleArrayMap<>();

    @NonNull
    @Override
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {
        Fragment f = mInitialized.get(className);
        if (f == null) {
            f = super.instantiate(classLoader, className);
            mInitialized.put(className, f);
        }
        return f;
    }

    public void clear() {
        mInitialized.clear();
    }

}
