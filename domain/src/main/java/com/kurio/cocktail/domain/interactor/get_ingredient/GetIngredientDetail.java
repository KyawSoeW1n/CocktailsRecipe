package com.kurio.cocktail.domain.interactor.get_ingredient;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.SingleUseCase;
import com.kurio.cocktail.domain.model.CacheDrink;
import com.kurio.cocktail.domain.model.CacheIngredient;
import com.kurio.cocktail.domain.model.IngredientDetail;
import com.kurio.cocktail.domain.repository.DrinkRepository;
import com.kurio.cocktail.domain.repository.IngredientRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetIngredientDetail extends SingleUseCase<CacheIngredient, GetIngredientDetail.Params> {
    private final IngredientRepository ingredientRepository;

    @Inject
    GetIngredientDetail(IngredientRepository ingredientRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    protected Single<CacheIngredient> buildUseCaseObservable(Params params) {
        return ingredientRepository.getIngredientDetail(params.id);
    }

    public class Params {
        String id;

        public Params(String id) {
            this.id = id;
        }
    }
}
