package uz.tune.newsapp.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import uz.tune.newsapp.R;
import uz.tune.newsapp.adapters.MyViewPagerAdapter;
import uz.tune.newsapp.databinding.FragmentMyViewPagerBinding;

public class MyViewPagerFragment extends Fragment {

    private FragmentMyViewPagerBinding binding;
    private MyViewPagerAdapter pagerAdapter;

    private int vpCurrentIndex = 0;

    public MyViewPagerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyViewPagerBinding
                .inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> images = new ArrayList<>();
        images.add("https://daryo.uz/static/2023/zulfiya/photo_2023-09-13_16-26-13.jpg");
        images.add("https://daryo.uz/static/2023/surayyo2/photo_2023-09-13_10-39-11-xl.jpg");
        images.add("https://daryo.uz/static/bomb1.jpg");
        images.add("https://daryo.uz/static/ZZZZKyrgyz.jpg");

        pagerAdapter = new MyViewPagerAdapter(images);
        binding.vpMy.setAdapter(pagerAdapter);
        binding.tlMy.setupWithViewPager(binding.vpMy);

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.vpMy.setCurrentItem(++vpCurrentIndex);
            }
        });

        binding.vpMy.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                vpCurrentIndex = position;

                if (position == images.size() - 1) {
                    binding.btnNext.setText("Finish");
                } else {
                    binding.btnNext.setText("Next");
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}