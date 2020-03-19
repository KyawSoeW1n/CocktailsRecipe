package com.kurio.cocktail.data.remote.response;

import com.google.gson.annotations.SerializedName;

public class ServerResponse {

    @SerializedName("drinks")
    public Object data;
}
