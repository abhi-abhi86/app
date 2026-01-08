package com.streampro.presentation.features.player.service;

import androidx.media3.exoplayer.ExoPlayer;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class StreamProService_MembersInjector implements MembersInjector<StreamProService> {
  private final Provider<ExoPlayer> playerProvider;

  public StreamProService_MembersInjector(Provider<ExoPlayer> playerProvider) {
    this.playerProvider = playerProvider;
  }

  public static MembersInjector<StreamProService> create(Provider<ExoPlayer> playerProvider) {
    return new StreamProService_MembersInjector(playerProvider);
  }

  @Override
  public void injectMembers(StreamProService instance) {
    injectPlayer(instance, playerProvider.get());
  }

  @InjectedFieldSignature("com.streampro.presentation.features.player.service.StreamProService.player")
  public static void injectPlayer(StreamProService instance, ExoPlayer player) {
    instance.player = player;
  }
}
