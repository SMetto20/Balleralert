package com.moringaschool.balleralert;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import Adapters.PlayerAdapter;
import Adapters.TeamAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import connection.NBAclient;
import interfaces.NbaApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamDisplay extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView mrecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_display);
        ButterKnife.bind(this);

        NbaApi nbaApi = NBAclient.getClient();

        Call<TheTeams> call = nbaApi.getTeams("0", "30");
        call.enqueue(new Callback<TheTeams>() {
            @Override
            public void onResponse(Call<TheTeams> call, Response<TheTeams> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(TeamDisplay.this, "success" + response.body().getData().size(), Toast.LENGTH_SHORT).show();

                    TheTeams theTeams = response.body();
//               String[] play = new String[players.size()];
//               String[] Teams = new String[players.size()];
//               for(int i =0; i< play.length; i++){
//                   play[i] = players.get(i).getFirstName();
//                   play[i] = players.get(i).getLastName();
//
//               }
//               for(int i =0; i< Teams.length; i++){
//                  Team team = players.get(i).getTeam();
//
//               }
                    TeamAdapter teamAdapter = new TeamAdapter(TeamDisplay.this, theTeams.getData());
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(TeamDisplay.this, LinearLayoutManager.VERTICAL, false);
                    mrecyclerView.setLayoutManager(linearLayoutManager);
                    mrecyclerView.setAdapter(teamAdapter);
                } else {
                    Log.d(TAG, "onResponse: " + response.code());

                }
            }

            @Override
            public void onFailure(Call<TheTeams> call, Throwable t) {


                Toast.makeText(TeamDisplay.this, t.toString(), Toast.LENGTH_LONG).show();

//
//
            }

        });

    }
   }