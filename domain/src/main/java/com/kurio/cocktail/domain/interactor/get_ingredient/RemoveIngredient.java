package com.kurio.cocktail.domain.interactor.get_ingredient;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.CompletableUseCase;
import com.kurio.cocktail.domain.repository.IngredientRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class RemoveIngredient extends CompletableUseCase<RemoveIngredient.Params> {
    private final IngredientRepository ingredientRepository;

    @Inject
    RemoveIngredient(IngredientRepository ingredientRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    protected Completable buildUseCaseObservable(Params params) {
        return ingredientRepository.deleteIngredientDetail(params.id);
    }

    public class Params {
        String id;

        public Params(String id) {
            this.id = id;
        }
    }
}