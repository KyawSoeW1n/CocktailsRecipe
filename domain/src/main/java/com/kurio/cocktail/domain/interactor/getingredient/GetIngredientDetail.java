package com.kurio.cocktail.domain.interactor.getingredient;

import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.domain.interactor.SingleUseCase;
import com.kurio.cocktail.domain.model.CocktailDetail;
import com.kurio.cocktail.domain.model.IngredientDetail;
import com.kurio.cocktail.domain.repository.CocktailRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetIngredientDetail extends SingleUseCase<IngredientDetail, GetIngredientDetail.Params> {
    private final CocktailRepository alcoholicRepository;

    @Inject
    GetIngredientDetail(CocktailRepository alcoholicRepository, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.alcoholicRepository = alcoholicRepository;
    }

    @Override
    protected Single<IngredientDetail> buildUseCaseObservable(Params params) {
        return alcoholicRepository.getIngredientDetail(params.name);
    }

    public class Params {
        String name;

        public Params(String name) {
            this.name = name;
        }
    }
}
