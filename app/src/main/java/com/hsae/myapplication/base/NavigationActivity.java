package com.hsae.myapplication.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

/**
 * NavigationActivity
 */
public abstract class NavigationActivity<VB extends ViewBinding> extends BaseActivity<VB> {
    protected NavController controller;
    private NavOptions options;
    private SingleFragmentFactory fragmentFactory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        fragmentFactory = new SingleFragmentFactory();
        getSupportFragmentManager().setFragmentFactory(fragmentFactory);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onActivityCreated() {
        controller = Navigation.findNavController(this, getFragmentContainer());
        options = createOptions();
    }

    protected abstract int getFragmentContainer();

    protected final boolean navigate(@IdRes int resId) {
        return navigate(resId, null);
    }

    protected final boolean navigate(@IdRes int resId, @Nullable Bundle bun) {
        if (controller == null) return false;
        controller.navigate(resId, bun, options);
        return true;
    }

    protected NavOptions createOptions() {
        return new NavOptions.Builder()
                .setEnterAnim(androidx.navigation.ui.R.anim.nav_default_enter_anim)
                .setExitAnim(androidx.navigation.ui.R.anim.nav_default_exit_anim)
                .setPopEnterAnim(androidx.navigation.ui.R.anim.nav_default_pop_enter_anim)
                .setPopExitAnim(androidx.navigation.ui.R.anim.nav_default_pop_exit_anim)
                .build();
    }

    @Override
    public void onBackPressed() {
        if (controller != null && controller.navigateUp()) {
            return;
        }
        Log.i(TAG, "supportFinishAfterTransition()");
        supportFinishAfterTransition();
    }

    @Override
    protected void onActivityDestroyed() {
        super.onActivityDestroyed();
        if (fragmentFactory != null) {
            fragmentFactory.clear();
            fragmentFactory = null;
        }
    }

}
