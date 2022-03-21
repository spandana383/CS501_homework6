package com.zeyu.w6_p1;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment_bottom extends Fragment {
    private fragmentBottomListener listener;
    private TextView Text;
    private ImageView IV_animals;
    private MediaPlayer mediaPlayer;

    public interface fragmentBottomListener {
        void onMsgSent(CharSequence cs);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bottom, container, false);
        Text = v.findViewById(R.id.Text);
        IV_animals = v.findViewById(R.id.IV_animals);
        return v;
    }


    public void updateTV(CharSequence cs){
        Text.setText(cs);
        int drawableResId = this.getResources().getIdentifier(cs+"", "drawable", getActivity().getPackageName());
        int rawResId = this.getResources().getIdentifier(cs+"", "raw", getActivity().getPackageName());
        mediaPlayer = MediaPlayer.create(getContext(), rawResId);
        mediaPlayer.start();
        IV_animals.setImageResource(drawableResId);
        Text.bringToFront();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof fragment_top.fragmentTopListener) {
            listener = (fragment_bottom.fragmentBottomListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
