package ru.dav.qigongapp.controllers;

import javafx.scene.control.Slider;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.scene.media.MediaPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.File;
import java.util.ArrayList;

public class MeditationControllerTest {

    private MeditationController controller;
    private MediaPlayer mediaPlayer;
    private ArrayList<File> songs;

    @Before
    public void setUp() {
        controller = new MeditationController();
        mediaPlayer = mock(MediaPlayer.class);
        controller.mediaPlayer = mediaPlayer;
        controller.volumeSlider = mock(Slider.class);

        // Create a mock list of songs
         songs = new ArrayList<>();
         songs.add(new File("song1.mp3"));
         songs.add(new File("song2.mp3"));
         controller.songs = songs;
    }

    @Test
    public void testPlayMedia() {
        when(controller.volumeSlider.getValue()).thenReturn(50.0);
        controller.playMedia();
        verify(mediaPlayer).setVolume(0.5);
        verify(mediaPlayer).play();
    }

    @Test
    public void testPauseMedia() {
        controller.pauseMedia();
        verify(mediaPlayer).pause();
    }

    @Test
    public void testStopMedia() {
        controller.stopMedia();
        verify(mediaPlayer).stop();
    }

    @Test
    public void testResetMedia() {
        controller.resetMedia();
        assertEquals(0, controller.songProgressBar.getProgress(), 0.0);
        verify(mediaPlayer).seek(Duration.seconds(0));
    }

    @Test
    public void testPreviousMedia() {
        controller.songNumber = 1;
        controller.previousMedia();
        assertEquals(0, controller.songNumber);
        verify(mediaPlayer).stop();
        verify(mediaPlayer).play();
    }

    @Test
    public void testNextMedia() {
        controller.songNumber = 0;
        controller.nextMedia();
        assertEquals(1, controller.songNumber);
        verify(mediaPlayer).stop();
        verify(mediaPlayer).play();
    }

    @Test
    public void testChangeSpeed() {
        when(controller.speedBox.getValue()).thenReturn("1.25");
        controller.changeSpeed(mock(ActionEvent.class));
        verify(mediaPlayer).setRate(1.5); }
}
