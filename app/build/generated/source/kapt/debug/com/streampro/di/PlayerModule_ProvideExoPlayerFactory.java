package com.streampro.di;

import android.content.Context;
import androidx.media3.common.AudioAttributes;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class PlayerModule_ProvideExoPlayerFactory implements Factory<ExoPlayer> {
  private final Provider<Context> contextProvider;

  private final Provider<AudioAttributes> audioAttributesProvider;

  private final Provider<CacheDataSource.Factory> cacheDataSourceFactoryProvider;

  public PlayerModule_ProvideExoPlayerFactory(Provider<Context> contextProvider,
      Provider<AudioAttributes> audioAttributesProvider,
      Provider<CacheDataSource.Factory> cacheDataSourceFactoryProvider) {
    this.contextProvider = contextProvider;
    this.audioAttributesProvider = audioAttributesProvider;
    this.cacheDataSourceFactoryProvider = cacheDataSourceFactoryProvider;
  }

  @Override
  public ExoPlayer get() {
    return provideExoPlayer(contextProvider.get(), audioAttributesProvider.get(), cacheDataSourceFactoryProvider.get());
  }

  public static PlayerModule_ProvideExoPlayerFactory create(Provider<Context> contextProvider,
      Provider<AudioAttributes> audioAttributesProvider,
      Provider<CacheDataSource.Factory> cacheDataSourceFactoryProvider) {
    return new PlayerModule_ProvideExoPlayerFactory(contextProvider, audioAttributesProvider, cacheDataSourceFactoryProvider);
  }

  public static ExoPlayer provideExoPlayer(Context context, AudioAttributes audioAttributes,
      CacheDataSource.Factory cacheDataSourceFactory) {
    return Preconditions.checkNotNullFromProvides(PlayerModule.INSTANCE.provideExoPlayer(context, audioAttributes, cacheDataSourceFactory));
  }
}
