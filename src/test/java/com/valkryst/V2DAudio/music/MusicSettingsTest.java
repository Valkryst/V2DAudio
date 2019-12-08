package com.valkryst.V2DAudio.music;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class MusicSettingsTest {
    @Test
    public void testDeepCopy() {
        final var settingsA = new MusicSettings();
        settingsA.setBalance(1);
        settingsA.setCycleCount(5);
        settingsA.setRate(0.75);
        settingsA.setVolume(0.85);

        final var settingsB = settingsA.deepCopy();

        Assert.assertNotNull(settingsB);
        Assert.assertNotSame(settingsA, settingsB);
    }

    @Test
    public void testSetBalance_withValueBelowMinimum() {
        final var settings = new MusicSettings();
        settings.setBalance(-2);
        Assert.assertEquals(settings.getBalance(), -1.0, 0.0);
    }

    @Test
    public void testSetBalance_withValuesInRange() {
        final var settings = new MusicSettings();
        for (double i = -1 ; i < 1 ; i += 0.1) {
            settings.setBalance(i);
            Assert.assertEquals(settings.getBalance(), i, 0.0);
        }
    }

    @Test
    public void testSetBalance_withValueAboveMaximum() {
        final var settings = new MusicSettings();
        settings.setBalance(2);
        Assert.assertEquals(settings.getBalance(), 1.0, 0.0);
    }

    @Test
    public void testSetCycleCount_withValueBelowMinimum() {
        final var settings = new MusicSettings();
        settings.setCycleCount(-2);
        Assert.assertEquals(settings.getCycleCount(), -1);
    }

    @Test
    public void testSetCycleCount_withValuesInRange() {
        final var settings = new MusicSettings();
        for (int i = 0 ; i < 10 ; i++) {
            final var tmp = ThreadLocalRandom.current().nextInt(-1, Integer.MAX_VALUE);
            settings.setCycleCount(tmp);
            Assert.assertEquals(settings.getCycleCount(), tmp);
        }
    }

    @Test
    public void testSetRate_withValueBelowMinimum() {
        final var settings = new MusicSettings();
        settings.setRate(0.124);
        Assert.assertEquals(settings.getRate(), 0.125, 0.0);
    }

    @Test
    public void testSetRate_withValuesInRange() {
        final var settings = new MusicSettings();
        for (double i = 0.125 ; i < 8 ; i += 0.025) {
            settings.setRate(i);
            Assert.assertEquals(settings.getRate(), i, 0.0);
        }
    }

    @Test
    public void testSetRate_withValueAboveMaximum() {
        final var settings = new MusicSettings();
        settings.setRate(8.1);
        Assert.assertEquals(settings.getRate(), 8, 0.0);
    }

    @Test
    public void testSetVolume_withValueBelowMinimum() {
        final var settings = new MusicSettings();
        settings.setVolume(-1);
        Assert.assertEquals(settings.getVolume(), 0, 0.0);
    }

    @Test
    public void testSetVolume_withValuesInRange() {
        final var settings = new MusicSettings();
        for (double i = 0 ; i < 1 ; i += 0.1) {
            settings.setVolume(i);
            Assert.assertEquals(settings.getVolume(), i, 0.0);
        }
    }

    @Test
    public void testSetVolume_withValueAboveMaximum() {
        final var settings = new MusicSettings();
        settings.setVolume(2);
        Assert.assertEquals(settings.getVolume(), 1, 0.0);
    }
}
