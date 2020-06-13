package com.kurio.cocktail.data.presentation;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.domain.interactor.getingredient.GetIngredientDetail;
import com.kurio.cocktail.domain.model.CocktailDetail;
import com.kurio.cocktail.domain.model.IngredientDetail;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class IngredientDetailViewModel extends ViewModel {
    private GetIngredientDetail getIngredientDetail;
    private MutableLiveData<Resource<IngredientDetail>> ingredientDetailLiveData = new MutableLiveData<>();
    private Resource<IngredientDetail> ingredientDetailResource = new Resource<>();

    @Inject
    IngredientDetailViewModel(GetIngredientDetail getIngredientDetail) {
        this.getIngredientDetail = getIngredientDetail;
    }

    public MutableLiveData<Resource<IngredientDetail>> getIngredientDetailLiveData() {
        return ingredientDetailLiveData;
    }

//    public MutableLiveData<List<String>> getIngredientListLiveData() {
//        return ingredientListLiveData;
//    }

    public void getIngredientDetail(String name) {
        getIngredientDetail.execute(new GetIngredientDetailSubscriber(), getIngredientDetail.new Params(name));
    }

    class GetIngredientDetailSubscriber implements SingleObserver<IngredientDetail> {

        @Override
        public void onSubscribe(Disposable d) {
            Log.i("LOADING", "LOADING");
            ingredientDetailLiveData.postValue(ingredientDetailResource.loading());
        }

        @Override
        public void onSuccess(IngredientDetail cocktails) {
            Log.i("SUCCESS", "SUCCESS");
            ingredientDetailLiveData.postValue(ingredientDetailResource.success(cocktails));
        }

        @Override
        public void onError(Throwable e) {
            Log.e("ERROR", "ERROR" + e.getMessage());
            ingredientDetailLiveData.postValue(ingredientDetailResource.error(e));
        }
    }
}
