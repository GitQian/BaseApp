package com.hsae.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsae.myapplication.base.NavigationFragment;
import com.hsae.myapplication.databinding.FragmentVersionBinding;
import com.hsae.myapplication.viewmodel.VersionViewModel;
import com.hsae.myapplication.viewmodel.ViewModelUtils;

import androidx.lifecycle.ViewModel;

/**
 * Description:
 *
 * @author: QianSheng
 * @date: 2024/11/13
 */
public class VersionFragment extends NavigationFragment<FragmentVersionBinding> implements View.OnClickListener {
    private ViewModel mViewModel;
    @Override
    protected FragmentVersionBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentVersionBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initView() {
        mViewModel = ViewModelUtils.getViewModel(this, VersionViewModel.class);
        binding.btnBack.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                getActivity().onBackPressed();
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("qiansheng", "VersionFragment onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i("qiansheng", "VersionFragment onDestroy");
    }
}
