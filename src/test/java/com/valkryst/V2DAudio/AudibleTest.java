package com.valkryst.V2DAudio;

import com.valkryst.V2DAudio.music.Music;
import com.valkryst.V2DAudio.sfx.Effect;

import java.io.IOException;

public class AudibleTest {
    public static void main(final String[] args) throws IOException, InterruptedException {
        final AudioController controller = AudioController.getInstance();
        controller.initialize(SuiteHelper.getResourcePath("data-valid.json"));
        AudioController.debuggingEnabled = true;

        final Music music = controller.loadMusic("victory");
        music.play(null);

        Thread.sleep(5000);
        music.pause();

        Thread.sleep(2000);
        music.play(null);

        Thread.sleep(2000);
        music.stop();

        Thread.sleep(2000);
        Effect effect = controller.loadEffect("thunder 1");
        effect.play(null);

        Thread.sleep(2000);
        effect = controller.loadEffect("thunder 2");
        effect.play(null);

        Thread.sleep(2000);
        System.exit(0);
    }
}
