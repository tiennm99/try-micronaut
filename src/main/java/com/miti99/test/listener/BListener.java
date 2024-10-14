package com.miti99.test.listener;

import com.miti99.test.event.GenericEvent;
import com.miti99.test.type.B;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;

@Singleton
public class BListener {

  @EventListener
  public void onApplicationEvent(GenericEvent<B> event) {
    System.out.println("BListener.onApplicationEvent: " + event.data().getClass());
  }
}
