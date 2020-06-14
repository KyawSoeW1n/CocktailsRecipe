package com.kurio.cocktail.data.presentation;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.domain.interactor.getalcoholicdrink.GetDrinkDetail;
import com.kurio.cocktail.domain.model.CocktailDetail;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class CocktailDetailViewModel extends ViewModel {
    private GetDrinkDetail getDrinkDetail;
    private MutableLiveData<Resource<List<CocktailDetail>>> drinkDetailLiveData = new MutableLiveData<>();
    private Resource<List<CocktailDetail>> cocktailDetailResource = new Resource<>();

    @Inject
    CocktailDetailViewModel(GetDrinkDetail getDrinkDetail) {
        this.getDrinkDetail = getDrinkDetail;
    }

    public MutableLiveData<Resource<List<CocktailDetail>>> getDrinkDetailLiveData() {
        return drinkDetailLiveData;
    }

    public void getDrinkDetail(String id) {
        getDrinkDetail.execute(new GetDrinkDetailSubscriber(), getDrinkDetail.new Params(id));
    }

    class GetDrinkDetailSubscriber implements SingleObserver<List<CocktailDetail>> {

        @Override
        public void onSubscribe(Disposable d) {
            Log.i("LOADING", "LOADING");
            drinkDetailLiveData.postValue(cocktailDetailResource.loading());
        }

        @Override
        public void onSuccess(List<CocktailDetail> cocktails) {
            Log.i("SUCCESS", "SUCCESS");
            drinkDetailLiveData.postValue(cocktailDetailResource.success(cocktails));
        }

        @Override
        public void onError(Throwable e) {
            Log.e("ERROR", "ERROR" + e.getMessage());
            drinkDetailLiveData.postValue(cocktailDetailResource.error(e));
        }
    }
}
