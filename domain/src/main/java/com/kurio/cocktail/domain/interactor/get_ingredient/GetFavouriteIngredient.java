package com.kurio.cocktail.domain.interactor.get_ingredient;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.SingleUseCase;
import com.kurio.cocktail.domain.model.CacheIngredient;
import com.kurio.cocktail.domain.repository.IngredientRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetFavouriteIngredient extends SingleUseCase<List<CacheIngredient>, Void> {
    private final IngredientRepository ingredientRepository;

    @Inject
    GetFavouriteIngredient(IngredientRepository ingredientRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    protected Single<List<CacheIngredient>> buildUseCaseObservable(Void params) {
        return ingredientRepository.getFavouriteIngredientList();
    }

}
