package uz.tune.newsapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

import uz.tune.newsapp.databinding.ItemGalleryBinding;

public class MyViewPagerAdapter extends PagerAdapter {

    private List<String> list;

    public MyViewPagerAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public View instantiateItem(@NonNull ViewGroup container, int position) {
        ItemGalleryBinding binding = ItemGalleryBinding
                .inflate(LayoutInflater.from(container.getContext()), container, false);

        Glide.with(container).load(list.get(position)).into(binding.ivInfo);
        binding.tvTitle.setText(position + 1 + " Page");


        container.addView(binding.getRoot());

        return binding.getRoot();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "TabTabTab - " + (position + 1);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
