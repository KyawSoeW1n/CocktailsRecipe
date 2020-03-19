package com.kurio.cocktail.data.remote;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.data.model.CocktailEntity;
import com.kurio.cocktail.data.remote.mapper.CocktailListResponseMapper;
import com.kurio.cocktail.data.remote.mapper.CocktailDetailResponseMapper;
import com.kurio.cocktail.data.remote.response.ServerResponse;
import com.kurio.cocktail.data.remote.service.CocktailService;
import com.kurio.cocktail.data.repository.CocktailRemote;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class CocktailImpl implements CocktailRemote {
    private CocktailListResponseMapper drinkResponseMapper;
    private CocktailDetailResponseMapper drinkDetailResponseMapper;
    private CocktailService drinkService;

    @Inject
    CocktailImpl(CocktailService drinkService,
                 CocktailDetailResponseMapper drinkDetailResponseMapper,
                 CocktailListResponseMapper drinkResponseMapper) {
        this.drinkResponseMapper = drinkResponseMapper;
        this.drinkDetailResponseMapper = drinkDetailResponseMapper;
        this.drinkService = drinkService;
    }

    @Override
    public Single<List<CocktailEntity>> getAlcoholicDrinks(String route) {
        return drinkService.getNonAlcoholicDrinks(route)
                .onErrorResumeNext(new Function<Throwable, SingleSource<? extends ServerResponse>>() {
                    @Override
                    public SingleSource<? extends ServerResponse> apply(Throwable throwable) throws Exception {
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
                .map(new Function<ServerResponse, List<CocktailEntity>>() {
                    @Override
                    public List<CocktailEntity> apply(ServerResponse serverResponse) throws Exception {
                        return drinkResponseMapper.mapFromResponse(serverResponse);
                    }
                });
    }

    @Override
    public Single<CocktailDetailEntity> getDrinkDetail(String id) {
        return drinkService.getDrinkDetail(id)
                .onErrorResumeNext(new Function<Throwable, SingleSource<? extends ServerResponse>>() {
                    @Override
                    public SingleSource<? extends ServerResponse> apply(Throwable throwable) throws Exception {
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
                .map(new Function<ServerResponse, CocktailDetailEntity>() {
                    @Override
                    public CocktailDetailEntity apply(ServerResponse serverResponse) throws Exception {
                        return drinkDetailResponseMapper.mapFromResponse(serverResponse);
                    }
                });
    }
}
