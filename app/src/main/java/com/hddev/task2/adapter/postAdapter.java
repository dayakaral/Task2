package com.hddev.task2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hddev.task2.R;
import com.hddev.task2.model.Item;

import java.util.List;

public class postAdapter extends RecyclerView.Adapter<postAdapter.ViewHolder> {
    List<Item> itemList;
    public postAdapter(List<Item> items) {
        this.itemList = items;
    }
    @NonNull
    @Override
    public postAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull postAdapter.ViewHolder holder, int position) {
        if (itemList.get(position) != null) {
            holder.item1.setText(itemList.get(position).getItem1());
            holder.item2.setText(itemList.get(position).getItem2());
            holder.checkBox.setChecked(itemList.get(position).isChecked());
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item1;
        TextView item2;
        CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item1 = itemView.findViewById(R.id.post_item1);
            item2 = itemView.findViewById(R.id.post_item2);
            checkBox = itemView.findViewById(R.id.post_checkbox);
        }
    }
}
