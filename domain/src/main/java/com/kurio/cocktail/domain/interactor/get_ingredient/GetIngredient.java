package com.kurio.cocktail.domain.interactor.get_ingredient;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.SingleUseCase;
import com.kurio.cocktail.domain.model.IngredientDetail;
import com.kurio.cocktail.domain.repository.IngredientRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetIngredient extends SingleUseCase<IngredientDetail, GetIngredient.Params> {
    private final IngredientRepository ingredientRepository;

    @Inject
    GetIngredient(IngredientRepository ingredientRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    protected Single<IngredientDetail> buildUseCaseObservable(Params params) {
        return ingredientRepository.getIngredientDetail(
                params.id);
    }

    public class Params {
        String id;

        public Params(String token) {
            this.id = id;
        }

    }
}
