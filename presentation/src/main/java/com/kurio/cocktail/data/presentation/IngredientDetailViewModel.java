package com.kurio.cocktail.data.presentation;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.domain.interactor.get_ingredient.FetchIngredientDetail;
import com.kurio.cocktail.domain.interactor.get_ingredient.GetIngredientDetail;
import com.kurio.cocktail.domain.interactor.get_ingredient.RemoveIngredient;
import com.kurio.cocktail.domain.interactor.get_ingredient.SaveFavouriteIngredient;
import com.kurio.cocktail.domain.model.CacheIngredient;
import com.kurio.cocktail.domain.model.IngredientDetail;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class IngredientDetailViewModel extends ViewModel {
    private FetchIngredientDetail fetchIngredientDetail;
    private SaveFavouriteIngredient saveFavouriteIngredient;
    private RemoveIngredient removeIngredient;
    private GetIngredientDetail getIngredientDetail;
    private MutableLiveData<Resource<List<IngredientDetail>>> ingredientDetailLiveData = new MutableLiveData<>();
    private MutableLiveData<Resource<CacheIngredient>> cacheIngredientLiveData = new MutableLiveData<>();
    private Resource<List<IngredientDetail>> ingredientDetailResource = new Resource<>();
    private Resource<CacheIngredient> cacheIngredientDetailResource = new Resource<>();

    @Inject
    IngredientDetailViewModel(FetchIngredientDetail fetchIngredientDetail,
                              SaveFavouriteIngredient saveFavouriteIngredient,
                              RemoveIngredient removeIngredient,
                              GetIngredientDetail getIngredientDetail) {
        this.fetchIngredientDetail = fetchIngredientDetail;
        this.saveFavouriteIngredient = saveFavouriteIngredient;
        this.removeIngredient = removeIngredient;
        this.getIngredientDetail = getIngredientDetail;
    }

    public MutableLiveData<Resource<List<IngredientDetail>>> getIngredientDetailLiveData() {
        return ingredientDetailLiveData;
    }

    public MutableLiveData<Resource<CacheIngredient>> getCacheIngredientLiveData() {
        return cacheIngredientLiveData;
    }

    public void fetchIngredientDetail(String name) {
        fetchIngredientDetail.execute(new FetchIngredientDetailSubscriber(), fetchIngredientDetail.new Params(name));
    }

    public void saveDrink(CacheIngredient cacheIngredient) {
        saveFavouriteIngredient.execute(new SaveFavouriteIngredientSubscriber(), saveFavouriteIngredient.new Params(cacheIngredient));
    }

    public void removeDrink(String ingredientId) {
        removeIngredient.execute(new RemoveIngredientSubscriber(), removeIngredient.new Params(ingredientId));
    }

    public void getCacheIngredient(String id) {
        getIngredientDetail.execute(new GetCacheIngredientDetailSubscriber(), getIngredientDetail.new Params(id));
    }

    class FetchIngredientDetailSubscriber implements SingleObserver<List<IngredientDetail>> {

        @Override
        public void onSubscribe(Disposable d) {
            Log.i("LOADING", "LOADING");
            ingredientDetailLiveData.postValue(ingredientDetailResource.loading());
        }

        @Override
        public void onSuccess(List<IngredientDetail> cocktails) {
            Log.i("SUCCESS", "SUCCESS");
            ingredientDetailLiveData.postValue(ingredientDetailResource.success(cocktails));
            getCacheIngredient(cocktails.get(0).getIdIngredient());
        }

        @Override
        public void onError(Throwable e) {
            Log.e("ERROR", "ERROR" + e.getMessage());
            ingredientDetailLiveData.postValue(ingredientDetailResource.error(e));
        }
    }

    class SaveFavouriteIngredientSubscriber implements CompletableObserver {

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

    class RemoveIngredientSubscriber implements CompletableObserver {

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

    class GetCacheIngredientDetailSubscriber implements SingleObserver<CacheIngredient> {

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onSuccess(CacheIngredient cacheIngredient) {
            cacheIngredientLiveData.postValue(cacheIngredientDetailResource.success(cacheIngredient));
        }

        @Override
        public void onError(Throwable e) {
            cacheIngredientLiveData.postValue(cacheIngredientDetailResource.error(e));
        }
    }

}
