package com.hsae.myapplication.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

/**
 * Description:
 *
 * @author: QianSheng
 * @date: 2024/11/12
 */
public abstract class BaseActivity<VB extends ViewBinding> extends AppCompatActivity {
    protected final String TAG = getClass().getSimpleName();
    protected VB binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewBinding();
        setContentView(binding.getRoot());
        initView();
        onActivityCreated();
    }

    protected void onActivityCreated() {
    }

    protected void onActivityDestroyed() {
    }

    protected abstract VB getViewBinding(); // 子类需实现此方法并传入具体的 ViewBinding

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onActivityDestroyed();
    }
}
