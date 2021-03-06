package com.bignerdranch.hellomoon;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by dell on 2016/3/13.
 */
public class HelloMoonFragment extends android.support.v4.app.Fragment{
    private Button mPlayButton;
    private Button mStopButton;
    private Button mVideoButton;
    private AudioPlayer mPlayer = new AudioPlayer();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);
        mPlayButton=(Button) v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (mPlayer.currentState==0){
                    mPlayer.play(getActivity());
                    mPlayButton.setText(R.string.hellomoon_pause);
                }
                else if (mPlayer.isPlaying()){
                    mPlayer.pause();
                    mPlayButton.setText(R.string.hellomoon_play);
                }else {
                    mPlayer.resume();
                    mPlayButton.setText(R.string.hellomoon_pause);
                }

            }
        });
        mStopButton=(Button) v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mPlayer.stop();
            }
        });

        mVideoButton=(Button) v.findViewById(R.id.hellomoon_videoButton);
        mVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),VideoActivity.class);
                startActivity(i);
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
