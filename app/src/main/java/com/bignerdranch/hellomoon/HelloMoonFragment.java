package com.bignerdranch.hellomoon;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by dell on 2016/3/13.
 */
public class HelloMoonFragment extends android.support.v4.app.Fragment{
    private Button mPlayButton;
    private Button mStopButton;
    private AudioPlayer mPlayer = new AudioPlayer();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);
        mPlayButton=(Button) v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mPlayer.play(getActivity());
            }
        });
        mStopButton=(Button) v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mPlayer.stop();
            }
        });
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();//避免fragment被销毁后MediaPlayer不停播放
    }


}
