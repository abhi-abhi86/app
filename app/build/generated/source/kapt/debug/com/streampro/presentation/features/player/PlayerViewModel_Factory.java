package com.streampro.presentation.features.player;

import androidx.media3.exoplayer.ExoPlayer;
import com.streampro.domain.usecase.GetSecureVideoUrlUseCase;
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
public final class PlayerViewModel_Factory implements Factory<PlayerViewModel> {
  private final Provider<GetSecureVideoUrlUseCase> getSecureVideoUrlUseCaseProvider;

  private final Provider<ExoPlayer> playerProvider;

  public PlayerViewModel_Factory(
      Provider<GetSecureVideoUrlUseCase> getSecureVideoUrlUseCaseProvider,
      Provider<ExoPlayer> playerProvider) {
    this.getSecureVideoUrlUseCaseProvider = getSecureVideoUrlUseCaseProvider;
    this.playerProvider = playerProvider;
  }

  @Override
  public PlayerViewModel get() {
    return newInstance(getSecureVideoUrlUseCaseProvider.get(), playerProvider.get());
  }

  public static PlayerViewModel_Factory create(
      Provider<GetSecureVideoUrlUseCase> getSecureVideoUrlUseCaseProvider,
      Provider<ExoPlayer> playerProvider) {
    return new PlayerViewModel_Factory(getSecureVideoUrlUseCaseProvider, playerProvider);
  }

  public static PlayerViewModel newInstance(GetSecureVideoUrlUseCase getSecureVideoUrlUseCase,
      ExoPlayer player) {
    return new PlayerViewModel(getSecureVideoUrlUseCase, player);
  }
}
