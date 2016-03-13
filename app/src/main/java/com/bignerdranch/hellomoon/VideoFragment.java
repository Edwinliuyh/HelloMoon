package com.bignerdranch.hellomoon;

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
public class VideoFragment extends android.support.v4.app.Fragment{
    private VideoView mVideoView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_video, parent, false);

        mVideoView=(VideoView) v.findViewById(R.id.videoView);
        MediaController mediaController=new MediaController(getActivity());
        Uri resouceUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.apollo_17_stroll);
        mVideoView.setVideoURI(resouceUri);
        mVideoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(mVideoView);
        mVideoView.requestFocus();
        mVideoView.start();
        
        return v;
    }



}
