package com.firefly.v2ex.net;

/**
 * Created by jason on 8/24/17.
 */


import android.util.Log;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Api {

    private static OkHttpClient client = new OkHttpClient.Builder().retryOnConnectionFailure(true).build();

    private static final String V2EX_HOTS_URL = "https://www.v2ex.com/api/topics/hot.json";

    public String getHots() throws IOException {
        Request request = new Request.Builder()
                .url(V2EX_HOTS_URL)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body().string();
    }
}
