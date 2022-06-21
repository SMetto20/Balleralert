package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.balleralert.R;
import com.moringaschool.balleralert.PlayerDatum;
import com.moringaschool.balleralert.Team;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.MyViewholder> {

      Context context;
    List<PlayerDatum> playersList;
    int[] images;

    public PlayerAdapter(Context context, List<PlayerDatum> playersList) {
        this.context = context;
        this.playersList = playersList;
//        this.images=images;
    }



    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.player_list_item,parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        Team teams = new Team();
        PlayerDatum playerDatum = playersList.get(position);
     holder.playerfirstname.setText(playerDatum.getFirstName());
        holder.secondname.setText(playerDatum.getLastName());
//        holder.team.setText(teams.getName());
        holder.position.setText(playerDatum.getPosition());
//        holder.imageView.setImageResource(images[position]);
//        holder.height.setText((Integer) playerDatum.getHeightFeet());
    }

    @Override
    public int getItemCount() {
        return playersList.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView playerfirstname ,secondname, team, position, height;
        ImageView imageView;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            playerfirstname = itemView.findViewById(R.id.playername);
            secondname = itemView.findViewById(R.id.secondname);
//            team= itemView.findViewById(R.id.team);
            position = itemView.findViewById(R.id.position);
//            height = itemView.findViewById(R.id.height);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
