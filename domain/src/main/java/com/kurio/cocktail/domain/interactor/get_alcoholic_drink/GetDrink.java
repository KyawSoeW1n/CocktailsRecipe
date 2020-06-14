package com.kurio.cocktail.domain.interactor.get_alcoholic_drink;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.SingleUseCase;
import com.kurio.cocktail.domain.model.Cocktail;
import com.kurio.cocktail.domain.repository.DrinkRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetDrink extends SingleUseCase<List<Cocktail>, GetDrink.Params> {
    private final DrinkRepository drinkRepository;

    @Inject
    GetDrink(DrinkRepository drinkRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.drinkRepository = drinkRepository;
    }

    @Override
    protected Single<List<Cocktail>> buildUseCaseObservable(Params params) {
        return drinkRepository.getAlcoholicDrinks(params.route);
    }

    public class Params {
        String route;

        public Params(String route) {
            this.route = route;
        }
    }
}
