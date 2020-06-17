package com.kurio.cocktail.domain.interactor.get_drink;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.CompletableUseCase;
import com.kurio.cocktail.domain.repository.DrinkRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class DeleteAllDrink extends CompletableUseCase<Void> {
    private final DrinkRepository drinkRepository;

    @Inject
    DeleteAllDrink(DrinkRepository drinkRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.drinkRepository = drinkRepository;
    }

    @Override
    protected Completable buildUseCaseObservable(Void aVoid) {
       return drinkRepository.deleteDrinkAll();
    }
}