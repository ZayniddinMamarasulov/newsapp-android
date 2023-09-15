package uz.tune.newsapp.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class HomeCategoryAdapter extends FragmentStateAdapter {

    private List<Fragment> fragmentList;

    public HomeCategoryAdapter(List<Fragment> fragmentList,
                               FragmentManager childFragmentManager,
                               Lifecycle lifecycle) {
        super(childFragmentManager, lifecycle);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }


}
