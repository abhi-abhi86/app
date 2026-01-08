package com.streampro.presentation.features.home;

import com.streampro.domain.usecase.GetMoviesUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<GetMoviesUseCase> getMoviesUseCaseProvider;

  public HomeViewModel_Factory(Provider<GetMoviesUseCase> getMoviesUseCaseProvider) {
    this.getMoviesUseCaseProvider = getMoviesUseCaseProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(getMoviesUseCaseProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<GetMoviesUseCase> getMoviesUseCaseProvider) {
    return new HomeViewModel_Factory(getMoviesUseCaseProvider);
  }

  public static HomeViewModel newInstance(GetMoviesUseCase getMoviesUseCase) {
    return new HomeViewModel(getMoviesUseCase);
  }
}
