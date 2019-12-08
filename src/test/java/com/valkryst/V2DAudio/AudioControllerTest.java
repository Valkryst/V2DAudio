package com.valkryst.V2DAudio;

import com.valkryst.V2DAudio.music.Music;
import com.valkryst.V2DAudio.sfx.Effect;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.MissingFormatArgumentException;

public class AudioControllerTest {
    @Test (expected = NullPointerException.class)
    public void testInitialize_withNullPath() throws IOException {
        final AudioController controller = AudioController.getInstance();
        controller.initialize(null);
    }

    @Test
    public void testInitialize_withValidData() throws IOException {
        final AudioController controller = AudioController.getInstance();
        controller.initialize(SuiteHelper.getResourcePath("data-valid.json"));
    }

    @Test (expected = MissingFormatArgumentException.class)
    public void testInitialize_withInvalidData_withMissingType() throws IOException {
        final AudioController controller = AudioController.getInstance();
        controller.initialize(SuiteHelper.getResourcePath("data-missing-type.json"));
    }

    @Test (expected = MissingFormatArgumentException.class)
    public void testInitialize_withInvalidData_withMissingName() throws IOException {
        final AudioController controller = AudioController.getInstance();
        controller.initialize(SuiteHelper.getResourcePath("data-missing-name.json"));
    }

    @Test (expected = MissingFormatArgumentException.class)
    public void testInitialize_withInvalidData_withMissingPath() throws IOException {
        final AudioController controller = AudioController.getInstance();
        controller.initialize(SuiteHelper.getResourcePath("data-missing-path.json"));
    }

    @Test (expected = MissingFormatArgumentException.class)
    public void testInitialize_withInvalidData_withMissingFilesystem() throws IOException {
        final AudioController controller = AudioController.getInstance();
        controller.initialize(SuiteHelper.getResourcePath("data-missing-filesystem.json"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInitialize_withInvalidData_withUnsupportedType() throws IOException {
        final AudioController controller = AudioController.getInstance();
        controller.initialize(SuiteHelper.getResourcePath("data-unsupported-type.json"));
    }

    @Test
    public void testGetInstance() {
        final AudioController controllerA = AudioController.getInstance();
        final AudioController controllerB = AudioController.getInstance();
        Assert.assertSame(controllerA, controllerB);
    }

    @Test (expected = NullPointerException.class)
    public void testLoadEffect_withNullName() {
        AudioController.getInstance().loadEffect(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLoadEffect_withEmptyName() {
        AudioController.getInstance().loadEffect("");
    }

    @Test
    public void testLoadEffect_fromDisk() throws IOException {
        final AudioController controller = AudioController.getInstance();
        controller.initialize(SuiteHelper.getResourcePath("data-valid.json"));
        Assert.assertNotNull(controller.loadEffect("thunder 1"));
    }

    @Test
    public void testLoadEffect_fromCache() throws IOException {
        final AudioController controller = AudioController.getInstance();
        controller.initialize(SuiteHelper.getResourcePath("data-valid.json"));

        final Effect effectA = controller.loadEffect("thunder 1");
        final Effect effectB = controller.loadEffect("thunder 1");
        Assert.assertSame(effectA, effectB);
    }

    @Test (expected = NullPointerException.class)
    public void testLoadMusic_withNullName() {
        final AudioController controller = AudioController.getInstance();
        controller.loadMusic(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLoadMusic_withEmptyName() {
        final AudioController controller = AudioController.getInstance();
        controller.loadMusic("");
    }

    @Test
    public void testLoadMusic_fromDisk() throws IOException {
        final AudioController controller = AudioController.getInstance();
        controller.initialize(SuiteHelper.getResourcePath("data-valid.json"));
        Assert.assertNotNull(controller.loadMusic("victory"));
    }

    @Test
    public void testLoadMusic_fromCache() throws IOException {
        final AudioController controller = AudioController.getInstance();
        controller.initialize(SuiteHelper.getResourcePath("data-valid.json"));

        final Music musicA = controller.loadMusic("victory");
        final Music musicB = controller.loadMusic("victory");
        Assert.assertSame(musicA, musicB);
    }
}
