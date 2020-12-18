package glover.mike.cs6314assignment1;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class PlayerInfoActivity extends AppCompatActivity {

    Player player;

    TextView playerName;
    TextView playerPosition;
    TextView playerSquadNumber;
    TextView playerDoB;
    ImageView playerImage;

    Button playerInfoButton;
    Button statsButton;
    Button bioButton;
    Button skillsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        playerName = (TextView) findViewById(R.id.playerName);
        playerPosition = (TextView) findViewById(R.id.playerPosition);
        playerSquadNumber = (TextView) findViewById(R.id.playerSquadNumber);
        playerImage = (ImageView) findViewById(R.id.playerImage);
        playerDoB = (TextView) findViewById(R.id.playerDoB);

        playerInfoButton = (Button) findViewById(R.id.playerInfoButton);

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
                Log.i("bioButton", "bioButton OnClick");
                Intent intent = new Intent(getApplicationContext(), WebInfoActivity.class);
                intent.putExtra("player", player);
                startActivity(intent);
            }
        });

        skillsButton = (Button) findViewById(R.id.skillsButton);
        skillsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), YoutubeActivity.class);
                intent.putExtra("player", player);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        player = intent.getParcelableExtra("player");

        setTitle(player.getName());

        playerName.setText(player.getName());
        playerPosition.setText(player.getPosition());
        playerSquadNumber.setText(player.getSquadNumber());
        playerDoB.setText(player.getDob());
        playerImage.setImageResource(player.getImageId());

    }
}
