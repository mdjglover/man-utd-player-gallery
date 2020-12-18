package glover.mike.cs6314assignment1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Player> {
    public CustomAdapter(Context context, ArrayList<Player> players) {
        super(context, R.layout.player_list_item, players);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.player_list_item, parent, false);

        ImageView playerImage = (ImageView) customView.findViewById(R.id.playerImage);
        TextView playerName = (TextView) customView.findViewById(R.id.playerName);
        TextView playerPosition = (TextView) customView.findViewById(R.id.position);
        TextView playerSquadNumber = (TextView) customView.findViewById(R.id.squadNumber);

        Player currentPlayer = (Player) getItem(position);
        String curPlayerSquadNumber = currentPlayer.getSquadNumber();
        String curPlayerName = currentPlayer.getName();
        String curPlayerPosition = currentPlayer.getPosition();
        int curPlayerImageId = currentPlayer.getImageId();

        playerImage.setImageResource(curPlayerImageId);
        playerSquadNumber.setText(curPlayerSquadNumber);
        playerName.setText(curPlayerName);
        playerPosition.setText(curPlayerPosition);

        return customView;

    }
}
