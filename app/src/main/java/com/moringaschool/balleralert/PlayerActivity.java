package com.moringaschool.balleralert;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

import Adapters.PlayerAdapter;
import Adapters.TeamAdapter;
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
    @BindView(R.id.floating)
    FloatingActionButton floating;

    int[] playerImages ={ R.drawable.ike_anigbogu_removebg_preview,R.drawable.ronbaker_removebg_preview,R.drawable.jabaribird_removebg_preview,R.drawable.marshonbrooks_removebg_preview,R.drawable.lorenzobrown_removebg_preview,R.drawable.omricaspi_removebg_preview,
    R.drawable.alexabrines_removebg_preview,R.drawable.tylerdavis_removebg_preview,R.drawable.keenan_evans_removebg_preview,
    };

    TeamFragment teamFragment = new TeamFragment();
    StatisticsFragment statisticsFragment = new StatisticsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);

        floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayerActivity.this, TeamDisplay.class);
                startActivity(intent);
            }
        });

//       BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        getSupportFragmentManager().beginTransaction().replace(R.id.container,teamFragment).commit();
//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected( MenuItem item) {
//                Fragment selectedFragment = null;
//                switch(item.getItemId()){
//
//                    case R.id.teams:
//                        selectedFragment =new TeamFragment();
//                        break;
//
//                    case R.id.stats:
//                        selectedFragment =new StatisticsFragment();
//                        break;
//
//                }
//              getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
//                return true;
//            }
//        });

        NbaApi nbaApi = NBAclient.getClient();
        Call<Players> call = nbaApi.getPlayers("1", "7", "");
//
        call.enqueue(new Callback<Players>() {
            @Override
            public void onResponse(Call<Players> call, Response<Players> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(PlayerActivity.this, "success" + response.body().getData().size(), Toast.LENGTH_SHORT).show();

                    Players players = response.body();
//
                    PlayerAdapter playerAdapter = new PlayerAdapter(PlayerActivity.this, players.getData(),playerImages);
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
//
    }
}