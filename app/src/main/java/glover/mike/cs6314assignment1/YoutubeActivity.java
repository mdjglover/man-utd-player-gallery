package glover.mike.cs6314assignment1;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity {
    Player player;
    String youtubeID;
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    private static final String API_KEY = "AIzaSyB9pwncgmBjVhFKkyRcrzJzeTiW7MG4jjw";

    Button playerInfoButton;
    Button statsButton;
    Button bioButton;
    Button skillsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        Intent intent = getIntent();
        player = intent.getParcelableExtra("player");
        youtubeID = player.getYoutubeId();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle(player.getName());

        playerInfoButton = (Button) findViewById(R.id.playerInfoButton);
        playerInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PlayerInfoActivity.class);
                intent.putExtra("player", player);
                startActivity(intent);
            }
        });

        statsButton = (Button) findViewById(R.id.statsButton);
        statsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MoreInfoActivity.class);
                intent.putExtra("player", player);
                startActivity(intent);
            }
        });

        bioButton = (Button) findViewById(R.id.bioButton);
        bioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WebInfoActivity.class);
                intent.putExtra("player", player);
                startActivity(intent);
            }
        });

        skillsButton = (Button) findViewById(R.id.skillsButton);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlayerView);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(youtubeID);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youTubePlayerView.initialize(API_KEY, onInitializedListener);
    }
}
