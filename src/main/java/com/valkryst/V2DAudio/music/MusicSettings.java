package com.valkryst.V2DAudio.music;

import com.valkryst.V2DAudio.AudioSettings;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MusicSettings extends AudioSettings {
    @Override
    public MusicSettings deepCopy() {
        final var settings = new MusicSettings();
        settings.setBalance(super.balance);
        settings.setCycleCount(super.cycleCount);
        settings.setRate(super.rate);
        settings.setVolume(super.volume);
        return settings;
    }
}
