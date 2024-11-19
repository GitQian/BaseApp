package com.hsae.myapplication.ui.News;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hsae.myapplication.base.NavigationFragment;
import com.hsae.myapplication.databinding.FramentNewsBinding;
import com.hsae.myapplication.ui.News.adapter.NewsAdapter;
import com.hsae.myapplication.ui.News.adapter.UsersAdapter;

import java.util.ArrayList;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * Description:
 *
 * @author: QianSheng
 * @date: 2024/11/15
 */
public class UsersFragment extends NavigationFragment<FramentNewsBinding> {
    private UsersViewModel viewModel;
    private NewsAdapter adapter;
    private UsersAdapter usersAdapter;

    @Override
    protected FramentNewsBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FramentNewsBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initView() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new NewsAdapter(new ArrayList<>());
        binding.recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(UsersViewModel.class);
        viewModel.getNewsList().observe(this, newsItems -> adapter.updateData(newsItems));

        binding.recyclerViewUser.setLayoutManager(new LinearLayoutManager(getActivity()));
        //写一个适配器
        usersAdapter = new UsersAdapter();
        //设置适配器
        binding.recyclerViewUser.setAdapter(usersAdapter);
        //监听数据变化
        viewModel.getUsersList().observe(this, users -> usersAdapter.setData(users));

        // Fetch news data
        viewModel.fetchNews();
        viewModel.getUsers();


    }
}
