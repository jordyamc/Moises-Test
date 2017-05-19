package knf.moisestest.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import knf.moisestest.Fragments.avesFragment;
import knf.moisestest.Fragments.mamiferosFragment;

/**
 * Created by Jordy on 19/05/2017.
 */

public class mainPagerAdapter extends FragmentStatePagerAdapter {
    public mainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Aves";
            case 1:
                return "Mamiferos";
            default:
                return null;
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new avesFragment();
            case 1:
                return new mamiferosFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
