package com.valkryst.V2DAudio.sfx;

import com.valkryst.V2DAudio.AudioController;
import javafx.application.Platform;
import javafx.scene.media.AudioClip;
import lombok.NonNull;

import java.nio.file.Path;

public class Effect {
    /** The audio clip used to play the effect file. */
    private final AudioClip clip;

    /**
     * Constructs a new Effect object.
     *
     * @param path
     *          The path of the effect file.
     */
    public Effect(final @NonNull Path path) {
        clip = new AudioClip(path.toUri().toString());
    }

    /**
     * Starts playback.
     *
     * @see AudioClip#play()
     *
     * @param settings
     *          The settings to apply to the effect, before starting playback.
     */
    public void play(EffectSettings settings) {
        if (settings != null) {
            settings = settings.deepCopy();
            clip.setBalance(settings.getBalance());
            clip.setCycleCount(settings.getCycleCount());
            clip.setPan(settings.getPan());
            clip.setRate(settings.getRate());
            clip.setVolume(settings.getVolume());
        }

        Platform.runLater(() -> {
            if (AudioController.debuggingEnabled) {
                System.out.println("Playing Effect: " + clip.getSource());
            }

            clip.play();
        });
    }

    /**
     * Stops playback.
     *
     * @see AudioClip#stop()
     */
    public void stop() {
        Platform.runLater(() -> {
            if (AudioController.debuggingEnabled) {
                System.out.println("Stopping Effect: " + clip.getSource());
            }

            clip.stop();
        });
    }
}
