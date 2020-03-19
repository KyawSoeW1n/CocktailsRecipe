package com.kurio.cocktail.data.remote.service;

import com.kurio.cocktail.data.remote.response.ServerResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CocktailService {
    @GET("api/json/v1/1/filter.php")
    Single<ServerResponse> getNonAlcoholicDrinks(@Query("a") String route);
    @GET("api/json/v1/1/lookup.php")
    Single<ServerResponse> getDrinkDetail(@Query("i") String id);
}
