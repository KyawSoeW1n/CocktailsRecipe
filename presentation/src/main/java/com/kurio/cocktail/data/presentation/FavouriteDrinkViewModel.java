package com.kurio.cocktail.data.presentation;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.domain.interactor.get_drink.GetFavouriteDrink;
import com.kurio.cocktail.domain.model.CacheDrink;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class FavouriteDrinkViewModel extends ViewModel {
    GetFavouriteDrink getFavouriteDrink;
    private MutableLiveData<Resource<List<CacheDrink>>> favouriteDrinkLiveData = new MutableLiveData<>();
    private Resource<List<CacheDrink>> favouriteDrinkResource = new Resource<>();

    @Inject

    public FavouriteDrinkViewModel(GetFavouriteDrink getFavouriteDrink) {
        this.getFavouriteDrink = getFavouriteDrink;
    }

    public MutableLiveData<Resource<List<CacheDrink>>> getFavouriteDrinkLiveData() {
        return favouriteDrinkLiveData;
    }

    public void getFavouriteDrink() {
        getFavouriteDrink.execute(new GetFavouriteDrinkSubscriber(), null);
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
