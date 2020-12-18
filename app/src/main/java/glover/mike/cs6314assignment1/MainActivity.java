package glover.mike.cs6314assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView playerListView;
    private ListAdapter adapter = null;
    private ArrayList<Player> players = null;
    private XMLPlayerParser parser = null;
    private Player[] data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerListView = (ListView) findViewById(R.id.playerListView);

        players = new ArrayList<Player>();
        parser = new XMLPlayerParser(getApplicationContext());
        data = parser.getData();

        for (int i = 0; i < data.length; i++){
            players.add(data[i]);
        }

        adapter = new CustomAdapter(this, players);
        playerListView = (ListView) findViewById(R.id.playerListView);
        playerListView.setAdapter(adapter);

        playerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), PlayerInfoActivity.class);
                intent.putExtra("player", data[i]);
                startActivity(intent);
            }
        });




    }
}
