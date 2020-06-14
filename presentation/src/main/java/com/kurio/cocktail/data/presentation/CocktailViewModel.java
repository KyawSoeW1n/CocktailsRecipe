package com.kurio.cocktail.data.presentation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.domain.interactor.get_drink.FetchAllDrink;
import com.kurio.cocktail.domain.model.Drink;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class CocktailViewModel extends ViewModel {
    private FetchAllDrink getDrink;
    private MutableLiveData<Resource<List<Drink>>> drinkListLiveData = new MutableLiveData<>();
    private Resource<List<Drink>> currencyResource = new Resource<>();

    @Inject
    CocktailViewModel(FetchAllDrink getDrink) {
        this.getDrink = getDrink;
    }


    public MutableLiveData<Resource<List<Drink>>> getDrinkListLiveData() {
        return drinkListLiveData;
    }

    public void fetchDrink(String route) {
        getDrink.execute(new GetDrinkSubscriber(), getDrink.new Params(route));
    }



    class GetDrinkSubscriber implements SingleObserver<List<Drink>> {

        @Override
        public void onSubscribe(Disposable d) {
            drinkListLiveData.postValue(currencyResource.loading());
        }

        @Override
        public void onSuccess(List<Drink> currencies) {
            drinkListLiveData.postValue(currencyResource.success(currencies));
        }

        @Override
        public void onError(Throwable e) {
            drinkListLiveData.postValue(currencyResource.error(e));
        }
    }
}
