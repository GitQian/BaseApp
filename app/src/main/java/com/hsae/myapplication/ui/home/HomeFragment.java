package com.hsae.myapplication.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsae.myapplication.R;
import com.hsae.myapplication.base.NavigationFragment;
import com.hsae.myapplication.databinding.FragmentHomeBinding;
import com.hsae.myapplication.utils.ViewModelUtils;

import androidx.lifecycle.ViewModel;

public class HomeFragment extends NavigationFragment<FragmentHomeBinding> implements View.OnClickListener {

    private ViewModel mViewModel;

    @Override
    protected FragmentHomeBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentHomeBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initView() {
        mViewModel = ViewModelUtils.getViewModel(this, HomeViewModel.class);

        binding.btnVersion.setOnClickListener(this);
        binding.btnUsbTest.setOnClickListener(this);
        binding.btnDiag.setOnClickListener(this);
        binding.btnNews.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_version:
                navigate(R.id.versionFragment);
                break;
            case R.id.btn_usb_test:

                break;
            case R.id.btn_diag:

                break;

            case R.id.btn_news:
                navigate(R.id.usersFragment);
                break;
            default:
                break;
        }
    }
}