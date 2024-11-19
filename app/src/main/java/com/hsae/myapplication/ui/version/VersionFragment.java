package com.hsae.myapplication.ui.version;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsae.myapplication.R;
import com.hsae.myapplication.base.NavigationFragment;
import com.hsae.myapplication.model.bean.VersionBean;
import com.hsae.myapplication.databinding.FragmentVersionBinding;
import com.hsae.myapplication.utils.ViewModelUtils;

/**
 * Description:
 *
 * @author: QianSheng
 * @date: 2024/11/13
 */
public class VersionFragment extends NavigationFragment<FragmentVersionBinding> implements View.OnClickListener {
    private VersionViewModel mViewModel;
    private VersionBean versionBean;

    @Override
    protected FragmentVersionBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentVersionBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initView() {
        mViewModel = ViewModelUtils.getViewModel(this, VersionViewModel.class);
        binding.btnBack.setOnClickListener(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                versionBean = new VersionBean();
                versionBean.setSoftVersion("1.0.9");
                binding.setVersionBean(versionBean);
                binding.setHwversion("S01");
            }
        }).start();
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
