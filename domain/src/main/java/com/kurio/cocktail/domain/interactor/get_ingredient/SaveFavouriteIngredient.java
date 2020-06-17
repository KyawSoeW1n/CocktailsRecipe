package com.kurio.cocktail.domain.interactor.get_ingredient;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.CompletableUseCase;
import com.kurio.cocktail.domain.model.CacheIngredient;
import com.kurio.cocktail.domain.model.IngredientDetail;
import com.kurio.cocktail.domain.repository.IngredientRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class SaveFavouriteIngredient extends CompletableUseCase<SaveFavouriteIngredient.Params> {
    private final IngredientRepository ingredientRepository;

    @Inject
    public SaveFavouriteIngredient(PostExecutionThread postExecutionThread, IngredientRepository ingredientRepository) {
        super(postExecutionThread);
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    protected Completable buildUseCaseObservable(Params params) {
        return this.ingredientRepository.saveIngredient(params.cacheIngredient);
    }


    public class Params {
        public CacheIngredient cacheIngredient;

        public Params(CacheIngredient cacheIngredient) {
            this.cacheIngredient = cacheIngredient;
        }
    }
}
