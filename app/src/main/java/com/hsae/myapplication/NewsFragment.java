package com.hsae.myapplication;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hsae.myapplication.base.NavigationFragment;
import com.hsae.myapplication.databinding.FramentNewsBinding;
import com.hsae.myapplication.utils.NewsAdapter;
import com.hsae.myapplication.viewmodel.NewsViewModel;

import java.util.ArrayList;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * Description:
 *
 * @author: QianSheng
 * @date: 2024/11/15
 */
public class NewsFragment extends NavigationFragment<FramentNewsBinding> {
    private NewsViewModel viewModel;
    private NewsAdapter adapter;

    @Override
    protected FramentNewsBinding getViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FramentNewsBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initView() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new NewsAdapter(new ArrayList<>());
        binding.recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        viewModel.getNewsList().observe(this, newsItems -> adapter.updateData(newsItems));

        // Fetch news data
        viewModel.fetchNews();
        viewModel.getUsers();
    }
}
