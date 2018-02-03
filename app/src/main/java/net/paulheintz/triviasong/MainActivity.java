package net.paulheintz.triviasong;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.jeopardy_song);
        mediaPlayer.start();

        final ImageButton playPauseBtn = (ImageButton)findViewById(R.id.play_pause_btn);
        playPauseBtn.setImageResource(R.drawable.pause);

        playPauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    playPauseBtn.setImageResource(R.drawable.play);
                    mediaPlayer.pause();
                } else {
                    playPauseBtn.setImageResource(R.drawable.pause);
                    mediaPlayer.start();
                }
            }
        });

        Button restartBtn = (Button)findViewById(R.id.restart_btn);

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(0);
                    mediaPlayer.start();
                } else {
                    mediaPlayer.seekTo(0);
                }
            }
        });
    }
}
