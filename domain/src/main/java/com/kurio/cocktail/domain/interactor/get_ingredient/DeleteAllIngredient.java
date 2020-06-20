package com.kurio.cocktail.domain.interactor.get_ingredient;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.CompletableUseCase;
import com.kurio.cocktail.domain.repository.IngredientRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class DeleteAllIngredient extends CompletableUseCase<Void> {
    private final IngredientRepository ingredientRepository;

    @Inject
    DeleteAllIngredient(IngredientRepository ingredientRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    protected Completable buildUseCaseObservable(Void aVoid) {
        return ingredientRepository.deleteAllIngredient();
    }
}