package ru.dav.qigongapp.controllers;

import java.io.File;
import java.net.URL;
import java.util.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import ru.dav.qigongapp.models.Navigation;
import ru.dav.qigongapp.models.NavigationImpl;

public class MeditationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView backHome;

    @FXML
    private AnchorPane meditationPane;

    @FXML
    private Button playButton, pauseButton, resetButton, previousButton, nextButton, stopButton;

    @FXML
    private final Navigation navigation = new NavigationImpl();


    @FXML
    private Label songLabel;

    @FXML
    ProgressBar songProgressBar;

    @FXML
    ComboBox<String> speedBox;

    @FXML
    Slider volumeSlider;

    private Media media;
    MediaPlayer mediaPlayer;

    ArrayList<File> songs;

    int songNumber;
    private double[] speeds = {0.25, 0.5, 0.75, 1, 1.25, 1.5, 1.75, 2.0};

    private Timer timer;
    private TimerTask task;
    private boolean running;



    public void songsList() {
        songs = new ArrayList<File>();
//        System.out.println("Текущий рабочий каталог: " + System.getProperty("user.dir"));
        File directory = new File("C:/Users/ElenaD/Documents/001_GB_Dev/0000_DIPLOMA/qigongApp/src/main/resources/sounds");
        File[] files = directory.listFiles();
//        System.out.println("Files in folder: " + Arrays.toString(files));
        if (files != null) {
            songs.addAll(Arrays.asList(files));
        }
//        System.out.println("Songs: " + songs);
    }

        @FXML
        void playMedia() {
            beginTimer();
            changeSpeed(null);
            mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
            mediaPlayer.play();
        }

    @FXML
    void pauseMedia() {
        cancelTimer();
        mediaPlayer.pause();
    }

    @FXML
    void stopMedia() {
        mediaPlayer.stop();
    }

    @FXML
    void resetMedia() {
        songProgressBar.setProgress(0);
        mediaPlayer.seek(Duration.seconds(0));
    }

    @FXML
    void previousMedia() {
        if (songNumber > 0) {
            songNumber--;
            stopMedia();

            if (running) {
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            songLabel.setText(songs.get(songNumber).getName());
            playMedia();
        } else {
            songNumber = songs.size() - 1;
            stopMedia();

            if (running) {
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            songLabel.setText(songs.get(songNumber).getName());
            playMedia();
        }
    }

    @FXML
    void nextMedia() {
        if (songNumber < songs.size() - 1) {
            songNumber++;
            stopMedia();

            if (running) {
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            songLabel.setText(songs.get(songNumber).getName());
            playMedia();
        } else {
            songNumber = 0;
            stopMedia();

            if (running) {
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            songLabel.setText(songs.get(songNumber).getName());
            playMedia();
        }
    }

    @FXML
    void scaleSpeed() {
        for (double speed : speeds) {
            speedBox.getItems().add(String.valueOf(speed));
        }
    }

    @FXML
    void changeSpeed(ActionEvent event) {
        if (speedBox.getValue() == null) {
            mediaPlayer.setRate(1);
        } else {
            mediaPlayer.setRate(Double.parseDouble(speedBox.getValue()) + 0.25);
        }
    }


    public void changeVolume() {
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number t1) {
                mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
            }
        });
    }

    public void beginTimer() {
        timer = new Timer();

        task = new TimerTask() {
            @Override
            public void run() {
                running = true;
                double current = mediaPlayer.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();

                songProgressBar.setProgress(current / end);

                if (current / end == 1) {
                    cancelTimer();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void cancelTimer() {
        running = false;
        timer.cancel();
    }

    @FXML
    void initialize() {
        backHome.setOnMouseClicked(mouseEvent -> navigation
                .switchToHomePage(meditationPane, "/ru/dav/qigongapp/qigong-view.fxml"));

        songsList();
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        songLabel.setText(songs.get(songNumber).getName());
        scaleSpeed();
        speedBox.setOnAction(this::changeSpeed);
        changeVolume();
        songProgressBar.setStyle("-fx-accent: #301796;");
    }
}


