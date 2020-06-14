package com.kurio.cocktail.domain.interactor.get_alcoholic_drink;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.SingleUseCase;
import com.kurio.cocktail.domain.model.CocktailDetail;
import com.kurio.cocktail.domain.repository.DrinkRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class FetchDrinkDetail extends SingleUseCase<List<CocktailDetail>, FetchDrinkDetail.Params> {
    private final DrinkRepository drinkRepository;

    @Inject
    FetchDrinkDetail(DrinkRepository drinkRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.drinkRepository = drinkRepository;
    }

    @Override
    protected Single<List<CocktailDetail>> buildUseCaseObservable(Params params) {
        return drinkRepository.fetchDrinkDetail(params.id);
    }

    public class Params {
        String id;

        public Params(String id) {
            this.id = id;
        }
    }
}
