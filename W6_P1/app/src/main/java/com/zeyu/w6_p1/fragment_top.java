package com.zeyu.w6_p1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class fragment_top extends Fragment {
    private fragmentTopListener listener;
    private ListView LV_animals;
    private ArrayAdapter<String> adapter;

    public interface fragmentTopListener {
        void onMsgSent(CharSequence cs);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_top, container, false);
        LV_animals = v.findViewById(R.id.LV_animals);
        ArrayList<String> list = new ArrayList<>();
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, list);
        LV_animals.setAdapter(adapter);
        list.add("cow");
        list.add("corgi");
        list.add("dragon");
        list.add("racoon");
        list.add("penguin");
        adapter.notifyDataSetChanged();
        LV_animals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                listener.onMsgSent(LV_animals.getItemAtPosition(position).toString());
            }
        });
        return v;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof fragmentTopListener) {
            listener = (fragmentTopListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
