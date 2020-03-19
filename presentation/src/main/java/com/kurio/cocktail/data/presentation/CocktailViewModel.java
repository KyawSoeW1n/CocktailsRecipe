package com.kurio.cocktail.data.presentation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.domain.interactor.getalcoholicdrink.GetDrink;
import com.kurio.cocktail.domain.model.Cocktail;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class CocktailViewModel extends ViewModel {
    private GetDrink getDrink;
    private MutableLiveData<Resource<List<Cocktail>>> drinkListLiveData = new MutableLiveData<>();
    private Resource<List<Cocktail>> currencyResource = new Resource<>();

    @Inject
    CocktailViewModel(GetDrink getDrink) {
        this.getDrink = getDrink;
    }


    public MutableLiveData<Resource<List<Cocktail>>> getDrinkListLiveData() {
        return drinkListLiveData;
    }

    public void getDrink(String route) {
        getDrink.execute(new GetDrinkSubscriber(), getDrink.new Params(route));
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
}
