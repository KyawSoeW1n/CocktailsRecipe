package com.kurio.cocktail.data.remote.service;

import com.kurio.cocktail.data.remote.response.DrinkResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CocktailService {
    @GET("api/json/v1/1/filter.php")
    Single<DrinkResponse> getNonAlcoholicDrinks(@Query("a") String route);

    @GET("api/json/v1/1/lookup.php")
    Single<DrinkResponse> getDrinkDetail(@Query("i") String id);

    @GET("api/json/v1/1/search.php")
    Single<DrinkResponse> getIngredientByName(@Query("i") String name);
}
