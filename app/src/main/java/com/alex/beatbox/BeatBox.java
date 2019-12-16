package com.alex.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUND_FOLDER = "sample_sounds";
    private static final int MAX_SOUNDS = 5;
    private List<Sound> mSounds = new ArrayList<>();
    private AssetManager mAssets;
    private SoundPool mSoundPool;

    public BeatBox (Context context) {
        mAssets = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        loadSounds();
    }

    private void loadSounds(){
        String[] soundNames;
        try{
            soundNames = mAssets.list(SOUND_FOLDER);
            Log.i(TAG, "Found " + soundNames.length + " sounds");
        }catch(IOException ioe){
            Log.e(TAG, "Could not list assets", ioe);
            return;
        }
        for (String fileName : soundNames) {
            String assetPath = SOUND_FOLDER + "/"+ fileName;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }

    private void load (Sound sound) throws IOException{
        AssetFileDescriptor afd = mAssets.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(afd,1);
        sound.setSoundId(soundId);
    }

    public List<Sound> getSounds(){
        return mSounds;
    }
}
