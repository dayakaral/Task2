package com.hddev.task2.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hddev.task2.R;
import com.hddev.task2.model.Item;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Item> itemList;
    private Context context;

    public RecyclerAdapter(Context context, List<Item> items) {
        this.context = context;
        this.itemList = items;
    }
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerAdapter.ViewHolder holder, final int position) {

        itemList.get(position).setItem1(holder.editText1.getText().toString());
        Log.d("THEBuG", "hj "+holder.editText1.getText().toString());
        itemList.get(position).setItem2(holder.editText2.getText().toString());
        itemList.get(position).setChecked(holder.checkBox.isChecked());
        holder.removeButton.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View v) {
                                                               itemList.remove(holder.getAdapterPosition());
                                                               notifyItemRemoved(holder.getAdapterPosition());

                                                           }
                                                       });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public List<Item> getItemList() {
        return itemList;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public EditText editText1;
        public EditText editText2;
        public CheckBox checkBox;
        public ImageButton removeButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            editText1 = itemView.findViewById(R.id.item_edit1);
            editText2 = itemView.findViewById(R.id.item_edit2);
            checkBox = itemView.findViewById(R.id.item_check);
            removeButton = itemView.findViewById(R.id.item_remove);

        }

    }
}
