package com.hsae.myapplication.base;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

/**
 * NavigationFragment
 */
public abstract class NavigationFragment<VB extends ViewBinding> extends BaseFragment<VB> {

    protected final String TAG = getClass().getSimpleName();

    protected NavController controller;
    private NavOptions options;

//    public NavigationFragment(int layoutId) {
//        super(layoutId);
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        controller = Navigation.findNavController(requireView());
        options = newNavOptions();
        super.onViewCreated(view, savedInstanceState);
    }

    public void setBundle(@NonNull Bundle bun) {
    }

    protected final boolean navigate(@IdRes int resId) {
        return navigate(resId, null);
    }

    protected final boolean navigate(@IdRes int resId, @Nullable Bundle bun) {
        if (controller == null) return false;
        controller.navigate(resId, bun, options);
        return true;
    }

    protected NavOptions newNavOptions() {
        return new NavOptions.Builder()
                .setEnterAnim(androidx.navigation.ui.R.anim.nav_default_enter_anim)
                .setExitAnim(androidx.navigation.ui.R.anim.nav_default_exit_anim)
                .setPopEnterAnim(androidx.navigation.ui.R.anim.nav_default_pop_enter_anim)
                .setPopExitAnim(androidx.navigation.ui.R.anim.nav_default_pop_exit_anim)
                .setPopUpTo(getBackId(), false)
                .build();
    }

    /**
     * 给 "Navi 切换的目的地 fragment" 指定他在出栈时回退的界面
     *
     * @return fragment id
     */
    @IdRes
    protected int getBackId() {
        return 0;
    }

    protected void setTitle(@StringRes int idRes) {
        requireActivity().setTitle(idRes);
    }

    // Tool method
    protected void setChildButtonClickListener(ViewGroup group, View.OnClickListener listener) {
        int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            View itemView = group.getChildAt(i);
            if (itemView instanceof Button) {
                itemView.setOnClickListener(listener);
            } else if (itemView instanceof ViewGroup) {
                setChildButtonClickListener((ViewGroup) itemView, listener);
            }
        }
    }

}
