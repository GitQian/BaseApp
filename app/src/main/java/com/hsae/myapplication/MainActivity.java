package com.hsae.myapplication;

import android.view.View;

import com.hsae.myapplication.base.BaseActivity;
import com.hsae.myapplication.base.NavigationActivity;
import com.hsae.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends NavigationActivity<ActivityMainBinding> {
    @Override
    protected ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
    }

    @Override
    protected int getFragmentContainer() {
        return R.id.main_fragment_host;
    }
}