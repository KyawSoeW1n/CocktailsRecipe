package com.kurio.cocktail.data.presentation;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.domain.interactor.get_alcoholic_drink.GetDrink;
import com.kurio.cocktail.domain.interactor.get_alcoholic_drink.SaveFavouriteDrink;
import com.kurio.cocktail.domain.model.CacheDrink;
import com.kurio.cocktail.domain.model.Cocktail;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class CocktailViewModel extends ViewModel {
    private GetDrink getDrink;
    private SaveFavouriteDrink saveFavouriteDrink;
    private MutableLiveData<Resource<List<Cocktail>>> drinkListLiveData = new MutableLiveData<>();
    private Resource<List<Cocktail>> currencyResource = new Resource<>();

    @Inject
    CocktailViewModel(GetDrink getDrink, SaveFavouriteDrink saveFavouriteDrink) {
        this.getDrink = getDrink;
        this.saveFavouriteDrink = saveFavouriteDrink;
    }


    public MutableLiveData<Resource<List<Cocktail>>> getDrinkListLiveData() {
        return drinkListLiveData;
    }

    public void fetchDrink(String route) {
        getDrink.execute(new GetDrinkSubscriber(), getDrink.new Params(route));
    }

    public void saveDrink(CacheDrink drink) {
        saveFavouriteDrink.execute(new SaveFavouriteDrinkSubscriber(), saveFavouriteDrink.new Params(drink));
    }

    class GetDrinkSubscriber implements SingleObserver<List<Cocktail>> {

        @Override
        public void onSubscribe(Disposable d) {
            drinkListLiveData.postValue(currencyResource.loading());
        }

        @Override
        public void onSuccess(List<Cocktail> currencies) {
            drinkListLiveData.postValue(currencyResource.success(currencies));
        }

        @Override
        public void onError(Throwable e) {
            drinkListLiveData.postValue(currencyResource.error(e));
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
}
