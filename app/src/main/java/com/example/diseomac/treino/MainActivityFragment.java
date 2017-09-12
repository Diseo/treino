package com.example.diseomac.treino;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.diseomac.treino.Adapter.TreinoAdapter;
import com.example.diseomac.treino.Model.Treino;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Realm realm;
    private ListView mListView;
    private TreinoAdapter mAdapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

//        RealmQuery<Treino> query = realm.where(Treino.class);
//        RealmResults<Treino> result1 = query.findAll();

        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.deleteRealm(config);
        realm = Realm.getInstance(config);

        mListView = (ListView) view.findViewById(R.id.list_view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

        final List<Treino> treinos = new ArrayList<Treino>(realm.where(Treino.class).findAll());
        mAdapter = new TreinoAdapter(this.getActivity());
        mAdapter.setData(treinos);

        mListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mListView.invalidate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close(); // Remember to close Realm when done.
    }

    public void updateTreinos() {
        RealmResults<Treino> treinos = realm.where(Treino.class).findAll();

        mAdapter.setData(treinos);
        mAdapter.notifyDataSetChanged();
        mListView.invalidate();
    }
}
