package uz.tune.newsapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import uz.tune.newsapp.R;

public class MyNewPagerAdapter extends RecyclerView.Adapter<MyNewPagerAdapter.ViewHolder> {
    private List<String> list;

    public MyNewPagerAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyNewPagerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(position + 1 + " Page");
        Glide.with(holder.itemView).load(list.get(position)).into(holder.ivInfo);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivInfo;
        TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ivInfo = itemView.findViewById(R.id.iv_info);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }

    }
}
