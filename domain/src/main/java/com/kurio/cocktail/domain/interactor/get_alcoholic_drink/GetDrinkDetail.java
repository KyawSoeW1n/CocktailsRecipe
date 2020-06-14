package com.kurio.cocktail.domain.interactor.get_alcoholic_drink;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.SingleUseCase;
import com.kurio.cocktail.domain.model.CacheDrink;
import com.kurio.cocktail.domain.repository.DrinkRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetDrinkDetail extends SingleUseCase<CacheDrink, GetDrinkDetail.Params> {
    private final DrinkRepository drinkRepository;

    @Inject
    GetDrinkDetail(DrinkRepository drinkRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.drinkRepository = drinkRepository;
    }

    @Override
    protected Single<CacheDrink> buildUseCaseObservable(Params params) {
        return drinkRepository.getDrinkDetail(params.id);
    }

    public class Params {
        String id;

        public Params(String id) {
            this.id = id;
        }
    }
}
