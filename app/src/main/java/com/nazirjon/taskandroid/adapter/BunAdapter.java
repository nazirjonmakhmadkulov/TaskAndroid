package com.nazirjon.taskandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.nazirjon.taskandroid.R;
import com.nazirjon.taskandroid.model.Bun;

import java.text.DecimalFormat;
import java.util.List;

public class BunAdapter extends RecyclerView.Adapter<BunAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<Bun> buns;

    public BunAdapter(Context context, List<Bun> buns) {
        this.buns = buns;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public BunAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BunAdapter.ViewHolder holder, int position) {
        Bun bun = buns.get(position);
        holder.nameView.setText(bun.getName());
        holder.timeView.setText(bun.getTime());
        holder.countView.setText(String.valueOf(bun.getCount()));
        if (bun.getCount() != 0) {
            holder.priceView.setText(new DecimalFormat("#0.00").format(bun.getPrice()));
        }else {
            holder.priceView.setText(new DecimalFormat("#0.00").format(bun.getCount()));
        }
    }

    @Override
    public int getItemCount() {
        return buns.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameView, timeView, countView, priceView;
        ViewHolder(View view){
            super(view);
            nameView = (TextView)view.findViewById(R.id.text_name);
            timeView = (TextView) view.findViewById(R.id.text_time);
            countView = (TextView) view.findViewById(R.id.text_count);
            priceView = (TextView) view.findViewById(R.id.text_price);
        }
    }
}