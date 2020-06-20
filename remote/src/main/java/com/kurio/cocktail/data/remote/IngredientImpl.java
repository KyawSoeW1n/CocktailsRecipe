package com.kurio.cocktail.data.remote;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kurio.cocktail.data.remote.mapper.IngredientDetailResponseMapper;
import com.kurio.cocktail.data.remote.response.IngredientResponse;
import com.kurio.cocktail.data.remote.service.CocktailService;
import com.kurio.cocktail.data.repository.IngredientRemote;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class IngredientImpl implements IngredientRemote {
    private CocktailService drinkService;
    private IngredientDetailResponseMapper ingredientDetailResponseMapper;

    @Inject
    IngredientImpl(CocktailService drinkService,
                   IngredientDetailResponseMapper ingredientDetailResponseMapper) {
        this.drinkService = drinkService;
        this.ingredientDetailResponseMapper = ingredientDetailResponseMapper;
    }

    @Override
    public Single<List<IngredientDetailEntity>> getIngredientDetail(String name) {
        return drinkService.getIngredientByName(name)
                .onErrorResumeNext(new Function<Throwable, SingleSource<? extends IngredientResponse>>() {
                    @Override
                    public SingleSource<? extends IngredientResponse> apply(Throwable throwable) throws Exception {
                        HttpException exception = (HttpException) throwable;
                        ResponseBody responseBody = exception.response().errorBody();
                        if (responseBody != null) {
                            String errorBody = responseBody.string();

                            JsonParser jsonParser = new JsonParser();
                            JsonObject jsonObject = jsonParser.parse(errorBody).getAsJsonObject();

                            if (jsonObject.get("ErrorID").getAsInt() == 401) {
                                Exception eID = new Exception(jsonObject.get("ErrorID").getAsString());
                                Exception e = new Exception(jsonObject.get("ErrorMsg").getAsString(), eID);
                                return Single.error(e);
                            }

                            return Single.error(new Exception(jsonObject.get("ErrorMsg").getAsString()));
                        } else {
                            return Single.error(throwable);
                        }
                    }
                })
                .map(new Function<IngredientResponse, List<IngredientDetailEntity>>() {
                    @Override
                    public List<IngredientDetailEntity> apply(IngredientResponse ingredientResponse) throws Exception {
                        return ingredientDetailResponseMapper.mapFromResponse(ingredientResponse);
                    }
                });

    }
}