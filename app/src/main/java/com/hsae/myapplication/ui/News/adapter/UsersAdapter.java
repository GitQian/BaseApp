package com.hsae.myapplication.ui.News.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hsae.myapplication.R;
import com.hsae.myapplication.model.bean.User;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Description:
 *
 * @author: QianSheng
 * @date: 2024/11/18
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private List<User> data = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = data.get(position);
        Log.i("qiansheng", "onBindViewHolder: " + position);
        holder.nameTv.setText(user.name);
        holder.ageTv.setText(user.email);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<User> data) {
        this.data = data;
        Log.i("qiansheng", "data size:" + data.size());
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTv, ageTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.tv_name);
            ageTv = itemView.findViewById(R.id.tv_age);
        }
    }

}
