package com.kurio.cocktail.domain.interactor.getalcoholicdrink;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.SingleUseCase;
import com.kurio.cocktail.domain.model.Cocktail;
import com.kurio.cocktail.domain.repository.CocktailRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetDrink extends SingleUseCase<List<Cocktail>, GetDrink.Params> {
    private final CocktailRepository alcoholicRepository;

    @Inject
    GetDrink(CocktailRepository alcoholicRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.alcoholicRepository = alcoholicRepository;
    }

    @Override
    protected Single<List<Cocktail>> buildUseCaseObservable(Params params) {
        return alcoholicRepository.getAlcoholicDrinks(params.route);
    }

    public class Params {
        String route;

        public Params(String route) {
            this.route = route;
        }
    }
}
