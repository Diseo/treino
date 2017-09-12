package com.example.diseomac.treino.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.diseomac.treino.Model.Treino;
import com.example.diseomac.treino.R;

import java.util.List;

/**
 * Created by diseomac on 12/09/17.
 */

public class TreinoAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    private List<Treino> treinos = null;

    public TreinoAdapter(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<Treino> details) {
        this.treinos = details;
    }

    @Override
    public int getCount() {
        if (treinos == null) {
            return 0;
        }
        return treinos.size();
    }

    @Override
    public Object getItem(int position) {
        if (treinos == null || treinos.get(position) == null) {
            return null;
        }
        return treinos.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent) {
        if (currentView == null) {
            currentView = inflater.inflate(R.layout.adapter_treino, parent, false);
        }

        Treino treino = treinos.get(position);

        if (treino != null) {
            ((TextView) currentView.findViewById(R.id.name)).setText(treino.getName());
            ((TextView) currentView.findViewById(R.id.descr)).setText(treino.getDescr());
        }

        return currentView;
    }
}
