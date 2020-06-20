package com.kurio.cocktail.domain.interactor.get_ingredient;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.SingleUseCase;
import com.kurio.cocktail.domain.model.IngredientDetail;
import com.kurio.cocktail.domain.repository.IngredientRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class FetchIngredientDetail extends SingleUseCase<List<IngredientDetail>, FetchIngredientDetail.Params> {
    private final IngredientRepository ingredientRepository;

    @Inject
    FetchIngredientDetail(IngredientRepository ingredientRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    protected Single<List<IngredientDetail>> buildUseCaseObservable(Params params) {
        return ingredientRepository.fetchIngredientDetail(params.name);
    }

    public class Params {
        String name;

        public Params(String name) {
            this.name = name;
        }
    }
}
