package knf.moisestest.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import knf.moisestest.Adapters.AnimalListAdapter;
import knf.moisestest.R;
import knf.moisestest.Utils.ContentFactory;

/**
 * Created by Jordy on 19/05/2017.
 */

public class avesFragment extends Fragment {
    public avesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_generic, container, false);
        setUpViews(view);
        return view;
    }

    private void setUpViews(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new AnimalListAdapter(getActivity(), ContentFactory.AnimalType.AVES));
    }
}
