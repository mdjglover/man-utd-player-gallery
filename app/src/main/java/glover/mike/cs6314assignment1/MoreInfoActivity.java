package glover.mike.cs6314assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MoreInfoActivity extends AppCompatActivity {

    Player player;

    TextView joined;
    TextView joinedFrom;
    TextView debut;
    TextView appearances;
    TextView premAppearances;
    TextView premWins;
    TextView premLosses;
    TextView premSigStatTitle;
    TextView premSigStat;

    Button playerInfoButton;
    Button statsButton;
    Button bioButton;
    Button skillsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        Intent intent = getIntent();
        player = intent.getParcelableExtra("player");

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
        skillsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), YoutubeActivity.class);
                intent.putExtra("player", player);
                startActivity(intent);
            }
        });

        joined = (TextView) findViewById(R.id.joinedTextView);
        joinedFrom = (TextView) findViewById(R.id.joinedFromTextView);
        debut = (TextView) findViewById(R.id.debutTextView);
        appearances = (TextView) findViewById(R.id.appearancesTextView);
        premAppearances = (TextView) findViewById(R.id.premAppearancesTextView);
        premWins = (TextView) findViewById(R.id.premWinsTextView);
        premLosses = (TextView) findViewById(R.id.premLossesTextView);
        premSigStatTitle = (TextView) findViewById(R.id.sigStatTitle);
        premSigStat = (TextView) findViewById(R.id.sigStatValue);

        joined.setText(player.getJoined());
        joinedFrom.setText(player.getJoinedFrom());
        debut.setText(player.getUnitedDebut());
        appearances.setText(player.getAppearances());
        premAppearances.setText(player.getPremAppearances());
        premWins.setText(player.getPremWins());
        premLosses.setText(player.getPremLosses());

        if (player.getPosition() == "Goalkeeper"){
            premSigStatTitle.setText("Clean Sheets");
        } else {
            premSigStatTitle.setText("Goals");
        }

        premSigStat.setText(player.getPremSignificantStat());
    }
}
