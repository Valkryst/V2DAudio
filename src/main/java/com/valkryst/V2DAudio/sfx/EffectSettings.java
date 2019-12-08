package com.valkryst.V2DAudio.sfx;

import com.valkryst.V2DAudio.AudioSettings;
import lombok.Getter;

public class EffectSettings extends AudioSettings {
    /**
     * The relative "center" of the clip.
     *
     * A pan value of 0.0 plays the clip normally where a -1.0 pan shifts the clip entirely to the left channel
     * and 1.0 shifts entirely to the right channel.
     *
     * Unlike balance this setting mixes both channels so neither channel loses data. Setting pan on a mono
     * clip has the same effect as setting balance, but with a much higher cost in CPU overhead so this i
     * not recommended for mono clips.
     *
     * @see javafx.scene.media.AudioClip#pan
     */
    @Getter private double pan = 0.0;

    @Override
    public EffectSettings deepCopy()  {
        final var settings = new EffectSettings();
        settings.setBalance(super.balance);
        settings.setCycleCount(super.cycleCount);
        settings.setPan(pan);
        settings.setRate(super.rate);
        settings.setVolume(super.volume);
        return settings;
    }

    /**
     * Sets the pan to a value of the range [-1, 1].
     *
     * @param pan
     *          The new pan.
     */
    public void setPan(final double pan) {
        if (pan < -1) {
            this.pan = -1;
        } else if (pan > 1) {
            this.pan = 1;
        } else {
            this.pan = pan;
        }
    }
}
