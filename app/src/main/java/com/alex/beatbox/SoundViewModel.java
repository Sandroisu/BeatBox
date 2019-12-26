package com.alex.beatbox;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class SoundViewModel extends BaseObservable {
    private Sound mSound;
    private BeatBox mBeatBox;

    @Bindable
    public float getSpeed() {
        return speed;
    }

    @Bindable
    public void setSpeed(float speed) {
        this.speed = speed;
        notifyChange();
    }

    float speed = 1;


    public SoundViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
        notifyChange();
    }

    @Bindable
    public Sound getSound() {
        return mSound;
    }

    @Bindable
    public void setSound(Sound sound) {
        mSound = sound;
        notifyChange();
    }

    @Bindable
    public String getTitle() {
        return mSound.getName();
    }

    public void onButtonClicked() {
        mBeatBox.play(mSound,speed);
        notifyChange();
    }
}
