package com.kurio.cocktail.domain.interactor.get_drink;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.CompletableUseCase;
import com.kurio.cocktail.domain.repository.DrinkRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class DeleteDrink extends CompletableUseCase< DeleteDrink.Params> {
    private final DrinkRepository drinkRepository;

    @Inject
    DeleteDrink(DrinkRepository drinkRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.drinkRepository = drinkRepository;
    }

    @Override
    protected Completable buildUseCaseObservable(Params params) {
        return drinkRepository.deleteDrinkDetail(params.id);
    }

    public class Params {
        String id;

        public Params(String id) {
            this.id = id;
        }
    }
}