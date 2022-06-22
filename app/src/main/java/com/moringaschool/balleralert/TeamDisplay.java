package com.moringaschool.balleralert;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
    @BindView(R.id.floating)
    FloatingActionButton floating;
    int[] teamImages = {R.drawable.atlanta_hawks2_removebg_preview,R.drawable.celtics_removebg_preview,R.drawable.brooklyn_logo_removebg_preview, R.drawable.charlot_hornetts_logo_removebg_preview, R.drawable.chicago_bulls_logo_removebg_preview, R.drawable.cavslogo_removebg_preview,R.drawable.dallas_mavericks_logo_removebg_preview,R.drawable.denver_nuggets_logo_removebg_preview, R.drawable.detroit_pistons_removebg_preview,R.drawable.warriorslogo_removebg_preview,R.drawable.houston_rockets_removebg_preview, R.drawable.indiana_pacers_removebg_preview, R.drawable.la_clippers_removebg_preview,R.drawable.lakerslogo_removebg_preview};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_display);
        ButterKnife.bind(this);
        floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeamDisplay.this, StatisticsActivity.class);
                startActivity(intent);
            }
        });
        NbaApi nbaApi = NBAclient.getClient();

        Call<TheTeams> call = nbaApi.getTeams("0", "14");
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
                    TeamAdapter teamAdapter = new TeamAdapter(TeamDisplay.this, theTeams.getData(),teamImages);
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