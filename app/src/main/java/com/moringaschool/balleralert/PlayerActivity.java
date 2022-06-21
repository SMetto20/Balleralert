package com.moringaschool.balleralert;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

import Adapters.PlayerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import connection.NBAclient;
import fragments.StatisticsFragment;
import fragments.TeamFragment;
import interfaces.NbaApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView mrecyclerView;
    int[] playerImages ={ R.drawable.ike_anigbogu_removebg_preview,R.drawable.ronbaker_removebg_preview

    };
    BottomNavigationView bottomNavigationView;
    TeamFragment teamFragment;
    StatisticsFragment statisticsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);
//        bottomNavigationView.findViewById(R.id.bottomnavigation);
//        getSupportFragmentManager().beginTransaction().replace(R.id.container,teamFragment).commit();
//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected( MenuItem item) {
//                switch(item.getItemId()){
//                    case R.id.teams:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container,teamFragment).commit();
//                        return true;
//                    case R.id.stats:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container,statisticsFragment).commit();
//                        return true;
//
//                }
//                return false;
//            }
//        });

        NbaApi nbaApi = NBAclient.getClient();
        Call<Players> call = nbaApi.getPlayers("1", "100", "");
        Call<Team> call2 = nbaApi.getTeams("0", "30");
        call.enqueue(new Callback<Players>() {
            @Override
            public void onResponse(Call<Players> call, Response<Players> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(PlayerActivity.this, "success" + response.body().getData().size(), Toast.LENGTH_SHORT).show();

                    Players players = response.body();
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
                    PlayerAdapter playerAdapter = new PlayerAdapter(PlayerActivity.this, players.getData());
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PlayerActivity.this, LinearLayoutManager.VERTICAL, false);
                    mrecyclerView.setLayoutManager(linearLayoutManager);
                    mrecyclerView.setAdapter(playerAdapter);
                } else {
                    Log.d(TAG, "onResponse: " + response.code());

                }
            }

            @Override
            public void onFailure(Call<Players> call, Throwable t) {


                Toast.makeText(PlayerActivity.this, t.toString(), Toast.LENGTH_LONG).show();

//
//
            }

        });
    }
}