package com.kurio.cocktail.domain.interactor.get_alcoholic_drink;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.CompletableUseCase;
import com.kurio.cocktail.domain.model.CacheDrink;
import com.kurio.cocktail.domain.model.Cocktail;
import com.kurio.cocktail.domain.repository.DrinkRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class SaveFavouriteDrink extends CompletableUseCase<SaveFavouriteDrink.Params> {
    private final DrinkRepository drinkRepository;

    @Inject
    public SaveFavouriteDrink(PostExecutionThread postExecutionThread, DrinkRepository drinkRepository) {
        super(postExecutionThread);
        this.drinkRepository = drinkRepository;
    }

    @Override
    protected Completable buildUseCaseObservable(Params params) {
        return this.drinkRepository.saveDrink(params.drink);
    }


    public class Params {
        public CacheDrink drink;

        public Params(CacheDrink drink) {
            this.drink = drink;
        }
    }
}
