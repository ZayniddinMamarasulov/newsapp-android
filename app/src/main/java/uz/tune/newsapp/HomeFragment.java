package uz.tune.newsapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import uz.tune.newsapp.adapters.HomeCategoryAdapter;
import uz.tune.newsapp.databinding.FragmentHomeBinding;
import uz.tune.newsapp.views.AuthorFragment;
import uz.tune.newsapp.views.NewsFragment;
import uz.tune.newsapp.views.TopicsFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeCategoryAdapter homeCategoryAdapter;

    List<Fragment> fragmentList;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new NewsFragment());
        fragmentList.add(new TopicsFragment());
        fragmentList.add(new AuthorFragment());

        homeCategoryAdapter = new HomeCategoryAdapter(
                fragmentList,
                getChildFragmentManager(),
                getLifecycle()
        );

        binding.vpHome.setAdapter(homeCategoryAdapter);

        new TabLayoutMediator(binding.tlHome, binding.vpHome, (tab, position) -> {
            switch (position) {
                case 0: {
                    tab.setText("News");
                    return;
                }
                case 1: {
                    tab.setText("Topics");
                    return;
                }
                case 2: {
                    tab.setText("Author");
                    return;
                }
                default: {

                }
            }
        }).attach();
    }
}