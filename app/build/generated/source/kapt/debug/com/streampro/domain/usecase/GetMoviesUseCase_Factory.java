package com.streampro.domain.usecase;

import com.streampro.domain.repository.MovieRepository;
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
public final class GetMoviesUseCase_Factory implements Factory<GetMoviesUseCase> {
  private final Provider<MovieRepository> repositoryProvider;

  public GetMoviesUseCase_Factory(Provider<MovieRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetMoviesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetMoviesUseCase_Factory create(Provider<MovieRepository> repositoryProvider) {
    return new GetMoviesUseCase_Factory(repositoryProvider);
  }

  public static GetMoviesUseCase newInstance(MovieRepository repository) {
    return new GetMoviesUseCase(repository);
  }
}
