package com.bignerdranch.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by dell on 2016/3/13.
 */
public class AudioPlayer {
    public int currentState=0;
    private MediaPlayer mPlayer;

    public void stop(){
        if (mPlayer!=null){
            mPlayer= null;
            mPlayer.release();
            currentState=0;
        }
    }

    public void play(Context c){
        stop();  //避免用户多次单击Play按钮创建多个MediaPlayer实例的情况
        mPlayer=MediaPlayer.create(c, R.raw.one_small_step);
        mPlayer.setOnCompletionListener (new MediaPlayer.OnCompletionListener(){
            public void onCompletion(MediaPlayer mp){
                //音频文件完成播放后，立即调用stop()方法，尽可能快地释放MediaPlayer实例
                stop();
            }
        });
        mPlayer.start();
        currentState++;
    }

    public void pause(){
        mPlayer.pause();
    }

    public void resume(){
        mPlayer.setOnCompletionListener (new MediaPlayer.OnCompletionListener(){
            public void onCompletion(MediaPlayer mp){
                //音频文件完成播放后，立即调用stop()方法，尽可能快地释放MediaPlayer实例
                stop();
            }
        });
        mPlayer.start();
    }

    public boolean isPlaying() {
        return mPlayer.isPlaying();
    }

}
