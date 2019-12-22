package com.alex.beatbox;

import android.media.SoundPool;

public class Sound {

    private Integer mSoundId;
    private String mAssetPath;
    private String mName;

    public Sound(String assetPath){
        mAssetPath = assetPath;
        String [] components = assetPath.split("/");
        String fileName = components[components.length - 1];
        mName = fileName.replace(".wav","");
    }

    public String getAssetPath(){
        return mAssetPath;
    }

    public String getName(){
        return mName;
    }
    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }
}
