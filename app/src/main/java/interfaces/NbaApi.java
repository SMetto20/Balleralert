package interfaces;

import com.moringaschool.balleralert.PlayerDatum;
import com.moringaschool.balleralert.Players;
import com.moringaschool.balleralert.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NbaApi {
    @GET("api/v1/players")
    Call<Players> getPlayers(
            @Query("page") String page,
            @Query("per_page") String perPage,
            @Query("search") String search
    );
    @GET("api/v1/teams")
    Call<Team> getTeams(
            @Query("page") String page,
            @Query("per_page") String perPage
    );
}
