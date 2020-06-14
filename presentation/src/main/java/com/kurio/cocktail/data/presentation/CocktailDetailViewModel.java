package com.kurio.cocktail.data.presentation;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.domain.interactor.get_drink.FetchDrinkDetail;
import com.kurio.cocktail.domain.interactor.get_drink.GetDrinkDetail;
import com.kurio.cocktail.domain.interactor.get_drink.RemoveDrink;
import com.kurio.cocktail.domain.interactor.get_drink.SaveFavouriteDrink;
import com.kurio.cocktail.domain.model.CacheDrink;
import com.kurio.cocktail.domain.model.DrinkDetail;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class CocktailDetailViewModel extends ViewModel {
    private FetchDrinkDetail fetchDrinkDetail;
    private SaveFavouriteDrink saveFavouriteDrink;
    private RemoveDrink removeDrink;
    private GetDrinkDetail getDrinkDetail;
    private MutableLiveData<Resource<List<DrinkDetail>>> drinkDetailLiveData = new MutableLiveData<>();
    private MutableLiveData<Resource<CacheDrink>> cacheDrinkLiveData = new MutableLiveData<>();
    private Resource<List<DrinkDetail>> drinkDetailResource = new Resource<>();
    private Resource<CacheDrink> cacheDrinkResource = new Resource<>();
    private String drinkId;

    @Inject
    CocktailDetailViewModel(FetchDrinkDetail fetchDrinkDetail,
                            SaveFavouriteDrink saveFavouriteDrink,
                            GetDrinkDetail getDrinkDetail,
                            RemoveDrink removeDrink) {
        this.fetchDrinkDetail = fetchDrinkDetail;
        this.saveFavouriteDrink = saveFavouriteDrink;
        this.removeDrink = removeDrink;
        this.getDrinkDetail = getDrinkDetail;
    }

    public MutableLiveData<Resource<List<DrinkDetail>>> getDrinkDetailLiveData() {
        return drinkDetailLiveData;
    }

    public MutableLiveData<Resource<CacheDrink>> getCacheDrinkLiveData() {
        return cacheDrinkLiveData;
    }

    public void fetchDrinkDetail(String id) {
        this.drinkId = id;
        fetchDrinkDetail.execute(new FetchDrinkDetailSubscriber(), fetchDrinkDetail.new Params(drinkId));
    }

    public void saveDrink(CacheDrink drink) {
        saveFavouriteDrink.execute(new SaveFavouriteDrinkSubscriber(), saveFavouriteDrink.new Params(drink));
    }

    public void getCacheDrink(String id) {
        getDrinkDetail.execute(new GetCacheDrinkDetailSubscriber(), getDrinkDetail.new Params(id));
    }

    public void removeDrink(String id) {
        removeDrink.execute(new RemoveDrinkSubscriber(), removeDrink.new Params(id));
    }

    class FetchDrinkDetailSubscriber implements SingleObserver<List<DrinkDetail>> {

        @Override
        public void onSubscribe(Disposable d) {
            Log.i("LOADING", "LOADING");
            drinkDetailLiveData.postValue(drinkDetailResource.loading());
        }

        @Override
        public void onSuccess(List<DrinkDetail> cocktails) {
            Log.i("SUCCESS", "SUCCESS");
            drinkDetailLiveData.postValue(drinkDetailResource.success(cocktails));
        }

        @Override
        public void onError(Throwable e) {
            Log.e("ERROR", "ERROR" + e.getMessage());
            drinkDetailLiveData.postValue(drinkDetailResource.error(e));
        }
    }

    class SaveFavouriteDrinkSubscriber implements CompletableObserver {

        @Override
        public void onSubscribe(Disposable d) {
            Log.e("favourite drink", "loading");
        }

        @Override
        public void onComplete() {
            Log.e("favourite drink", "save");
        }

        @Override
        public void onError(Throwable e) {
            Log.e("favourite drink", "error");
        }
    }

    class RemoveDrinkSubscriber implements CompletableObserver {

        @Override
        public void onSubscribe(Disposable d) {
            Log.e("drink", "loading");
        }

        @Override
        public void onComplete() {
            Log.e("drink", "remove");
        }

        @Override
        public void onError(Throwable e) {
            Log.e("drink", "error");
        }
    }

    class GetCacheDrinkDetailSubscriber implements SingleObserver<CacheDrink> {

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onSuccess(CacheDrink drink) {
            cacheDrinkLiveData.postValue(cacheDrinkResource.success(drink));
        }

        @Override
        public void onError(Throwable e) {
            cacheDrinkLiveData.postValue(cacheDrinkResource.error(e));
        }
    }
}
