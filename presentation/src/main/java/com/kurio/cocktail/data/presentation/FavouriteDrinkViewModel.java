package com.kurio.cocktail.data.presentation;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.domain.interactor.get_drink.DeleteAllDrink;
import com.kurio.cocktail.domain.interactor.get_drink.DeleteDrink;
import com.kurio.cocktail.domain.interactor.get_drink.GetFavouriteDrink;
import com.kurio.cocktail.domain.model.CacheDrink;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.subscribers.DisposableSubscriber;

public class FavouriteDrinkViewModel extends ViewModel {
    private GetFavouriteDrink getFavouriteDrink;
    private DeleteDrink deleteDrink;
    private DeleteAllDrink deleteAllDrink;
    private MutableLiveData<Resource<List<CacheDrink>>> favouriteDrinkLiveData = new MutableLiveData<>();
    private Resource<List<CacheDrink>> favouriteDrinkResource = new Resource<>();

    @Inject

    public FavouriteDrinkViewModel(GetFavouriteDrink getFavouriteDrink,
                                   DeleteDrink deleteDrink,
                                   DeleteAllDrink deleteAllDrink) {
        this.getFavouriteDrink = getFavouriteDrink;
        this.deleteDrink = deleteDrink;
        this.deleteAllDrink = deleteAllDrink;
    }

    public MutableLiveData<Resource<List<CacheDrink>>> getFavouriteDrinkLiveData() {
        return favouriteDrinkLiveData;
    }

    public void getFavouriteDrink() {
        getFavouriteDrink.execute(new GetFavouriteDrinkSubscriber(), null);
    }

    public void deleteDrink(String id) {
        deleteDrink.execute(new RemoveDrinkSubscriber(), deleteDrink.new Params(id));
    }

    public void deleteAllDrink() {
        deleteAllDrink.execute(new RemoveAllDrinkSubscriber(), null);
    }

    class RemoveDrinkSubscriber implements CompletableObserver {

        @Override
        public void onSubscribe(Disposable d) {
            Log.e("drink", "loading");
        }

        @Override
        public void onComplete() {
//            getFavouriteDrink();
        }

        @Override
        public void onError(Throwable e) {
            Log.e("drink", "error");
        }
    }

    class RemoveAllDrinkSubscriber implements CompletableObserver {

        @Override
        public void onSubscribe(Disposable d) {
            Log.e("drink", "loading");
        }

        @Override
        public void onComplete() {
            Log.e("All Drink", "remove");
        }

        @Override
        public void onError(Throwable e) {
            Log.e("drink", "error");
        }
    }

    private class GetFavouriteDrinkSubscriber extends DisposableSubscriber<List<CacheDrink>> {
        @Override
        public void onNext(List<CacheDrink> cacheDrinks) {
            favouriteDrinkLiveData.postValue(favouriteDrinkResource.success(cacheDrinks));
        }

        @Override
        public void onError(Throwable t) {

        }

        @Override
        public void onComplete() {
        }
    }
}
