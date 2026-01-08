package com.streampro.data.network;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class NetworkConnectivityObserver_Factory implements Factory<NetworkConnectivityObserver> {
  private final Provider<Context> contextProvider;

  public NetworkConnectivityObserver_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NetworkConnectivityObserver get() {
    return newInstance(contextProvider.get());
  }

  public static NetworkConnectivityObserver_Factory create(Provider<Context> contextProvider) {
    return new NetworkConnectivityObserver_Factory(contextProvider);
  }

  public static NetworkConnectivityObserver newInstance(Context context) {
    return new NetworkConnectivityObserver(context);
  }
}
