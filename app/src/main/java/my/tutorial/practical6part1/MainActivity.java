package my.tutorial.practical6part1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = null;
    Integer stopPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPlay = (Button) findViewById(R.id.playbutton);
        buttonPlay.setOnClickListener(v -> {
            mp = MediaPlayer.create(MainActivity.this, R.raw.sample);

            if(stopPosition > 0)
            {
                mp.seekTo(stopPosition);
                mp.start();
                stopPosition = 0;
            }
            else
            {
                mp.start();
            }
        });

        Button buttonStop = (Button) findViewById(R.id.stopButton);
        buttonStop.setOnClickListener(v -> {
            if (mp != null) {
                stopPosition = mp.getCurrentPosition(); //stopPosition is an int
                mp.pause();
                //mp.stop();

            }
        });
    }

}