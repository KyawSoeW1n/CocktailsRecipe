package com.kurio.cocktail.data.presentation;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.domain.interactor.get_ingredient.DeleteAllIngredient;
import com.kurio.cocktail.domain.interactor.get_ingredient.GetFavouriteIngredient;
import com.kurio.cocktail.domain.interactor.get_ingredient.RemoveIngredient;
import com.kurio.cocktail.domain.model.CacheIngredient;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class FavouriteIngredientViewModel extends ViewModel {
    private GetFavouriteIngredient getFavouriteIngredient;
    private RemoveIngredient removeIngredient;
    private DeleteAllIngredient deleteAllIngredient;
    private MutableLiveData<Resource<List<CacheIngredient>>> favouriteIngredientLiveData = new MutableLiveData<>();
    private Resource<List<CacheIngredient>> favouriteIngredientResource = new Resource<>();

    @Inject


    public FavouriteIngredientViewModel(GetFavouriteIngredient getFavouriteIngredient,
                                        RemoveIngredient removeIngredient,
                                        DeleteAllIngredient deleteAllIngredient) {
        this.getFavouriteIngredient = getFavouriteIngredient;
        this.removeIngredient = removeIngredient;
        this.deleteAllIngredient = deleteAllIngredient;
    }

    public MutableLiveData<Resource<List<CacheIngredient>>> getFavouriteIngredientLiveData() {
        return favouriteIngredientLiveData;
    }

    public void getFavouriteIngredient() {
        getFavouriteIngredient.execute(new GetFavouriteIngredientSubscriber(), null);
    }

    public void deleteAllIngredient() {
        deleteAllIngredient.execute(new RemoveAllIngredientSubscriber(), null);
    }

    public void deleteIngredient(String ingredientId) {
        removeIngredient.execute(new RemoveIngredientSubscriber(), removeIngredient.new Params(ingredientId));
    }

    class RemoveAllIngredientSubscriber implements CompletableObserver {

        @Override
        public void onSubscribe(Disposable d) {
            Log.e("Ingredient", "loading");
        }

        @Override
        public void onComplete() {
            Log.e("All Ingredient", "remove");
        }

        @Override
        public void onError(Throwable e) {
            Log.e("Ingredient", "error");
        }
    }

    class RemoveIngredientSubscriber implements CompletableObserver {

        @Override
        public void onSubscribe(Disposable d) {
            Log.e("Ingredient", "loading");
        }

        @Override
        public void onComplete() {
            Log.e("Ingredient", "remove");
        }

        @Override
        public void onError(Throwable e) {
            Log.e("Ingredient", "error");
        }
    }

    private class GetFavouriteIngredientSubscriber implements SingleObserver<List<CacheIngredient>> {
        @Override
        public void onSubscribe(Disposable d) {
            Log.i("LOADING", "LOADING");
            favouriteIngredientLiveData.postValue(favouriteIngredientResource.loading());
        }

        @Override
        public void onSuccess(List<CacheIngredient> ingredients) {
            favouriteIngredientLiveData.postValue(favouriteIngredientResource.success(ingredients));
        }

        @Override
        public void onError(Throwable e) {
            Log.e("ERROR", "ERROR" + e.getMessage());
            favouriteIngredientLiveData.postValue(favouriteIngredientResource.error(e));
        }
    }
}
