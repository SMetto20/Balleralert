package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.balleralert.PlayerDatum;
import com.moringaschool.balleralert.R;
import com.moringaschool.balleralert.Team;
import com.moringaschool.balleralert.TheTeams;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewholder> {
    Context context;
    List<Team> teams;
    int[] images;
    public TeamAdapter(Context context, List<Team> teams,   int[] images) {
        this.context = context;
        this.teams = teams;
        this.images= images;
    }

    @NonNull
    @Override
    public TeamAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.team_list_item,parent, false);
        return new TeamAdapter.MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.MyViewholder holder, int position) {
        Team team  = teams.get(position);
        holder.teamName.setText(team.getFullName());
        holder.conference.setText(team.getConference());
        holder.city.setText(team.getCity());
        holder.imageView.setImageResource(images[position]);


    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView teamName, conference, city;
        ImageView imageView;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            conference = itemView.findViewById(R.id.conference);
            teamName = itemView.findViewById(R.id.teamname);
//            team= itemView.findViewById(R.id.team);
            city = itemView.findViewById(R.id.city);
            imageView = itemView.findViewById(R.id.teamImage);
//
        }
    }
}
