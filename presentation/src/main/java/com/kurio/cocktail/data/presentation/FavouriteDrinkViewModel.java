package com.kurio.cocktail.data.presentation;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.domain.interactor.get_drink.GetFavouriteDrink;
import com.kurio.cocktail.domain.interactor.get_drink.RemoveDrink;
import com.kurio.cocktail.domain.model.CacheDrink;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class FavouriteDrinkViewModel extends ViewModel {
    private GetFavouriteDrink getFavouriteDrink;
    private RemoveDrink removeDrink;
    private MutableLiveData<Resource<List<CacheDrink>>> favouriteDrinkLiveData = new MutableLiveData<>();
    private Resource<List<CacheDrink>> favouriteDrinkResource = new Resource<>();

    @Inject

    public FavouriteDrinkViewModel(GetFavouriteDrink getFavouriteDrink, RemoveDrink removeDrink) {
        this.getFavouriteDrink = getFavouriteDrink;
        this.removeDrink = removeDrink;
    }

    public MutableLiveData<Resource<List<CacheDrink>>> getFavouriteDrinkLiveData() {
        return favouriteDrinkLiveData;
    }

    public void getFavouriteDrink() {
        getFavouriteDrink.execute(new GetFavouriteDrinkSubscriber(), null);
    }

    public void removeDrink(String id) {
        removeDrink.execute(new RemoveDrinkSubscriber(), removeDrink.new Params(id));
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

    private class GetFavouriteDrinkSubscriber implements SingleObserver<List<CacheDrink>> {
        @Override
        public void onSubscribe(Disposable d) {
            Log.i("LOADING", "LOADING");
            favouriteDrinkLiveData.postValue(favouriteDrinkResource.loading());
        }

        @Override
        public void onSuccess(List<CacheDrink> cocktails) {
            Log.i("SUCCESS", "SUCCESS");
            favouriteDrinkLiveData.postValue(favouriteDrinkResource.success(cocktails));
        }

        @Override
        public void onError(Throwable e) {
            Log.e("ERROR", "ERROR" + e.getMessage());
            favouriteDrinkLiveData.postValue(favouriteDrinkResource.error(e));
        }
    }
}
