package com.kurio.cocktail.domain.interactor.get_drink;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.SingleUseCase;
import com.kurio.cocktail.domain.model.Drink;
import com.kurio.cocktail.domain.repository.DrinkRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class FetchAllDrink extends SingleUseCase<List<Drink>, FetchAllDrink.Params> {
    private final DrinkRepository drinkRepository;

    @Inject
    FetchAllDrink(DrinkRepository drinkRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.drinkRepository = drinkRepository;
    }

    @Override
    protected Single<List<Drink>> buildUseCaseObservable(Params params) {
        return drinkRepository.getAlcoholicDrinks(params.route);
    }

    public class Params {
        String route;

        public Params(String route) {
            this.route = route;
        }
    }
}
