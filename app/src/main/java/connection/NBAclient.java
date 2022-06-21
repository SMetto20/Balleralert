package connection;

import com.moringaschool.balleralert.Constants;

import interfaces.NbaApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NBAclient {
    private static Retrofit retrofit = null;

    public static NbaApi getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.NBA_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit.create(NbaApi.class);
    }
}
