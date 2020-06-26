package com.kurio.cocktail.domain.interactor.get_drink;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.FlowableUseCase;
import com.kurio.cocktail.domain.model.CacheDrink;
import com.kurio.cocktail.domain.repository.DrinkRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GetFavouriteDrink extends FlowableUseCase<List<CacheDrink>, Void> {
    private final DrinkRepository drinkRepository;

    @Inject
    GetFavouriteDrink(DrinkRepository drinkRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.drinkRepository = drinkRepository;
    }

    @Override
    protected Flowable<List<CacheDrink>> buildUseCaseObservable(Void aVoid) {
        return drinkRepository.getFavouriteDrink();
    }
}
