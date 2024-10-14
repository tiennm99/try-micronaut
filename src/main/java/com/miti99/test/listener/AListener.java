package com.miti99.test.listener;

import com.miti99.test.event.GenericEvent;
import com.miti99.test.type.A;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;

@Singleton
public class AListener {

  @EventListener
  public void onApplicationEvent(GenericEvent<A> event) {
    System.out.println("AListener.onApplicationEvent: " + event.data().getClass());
  }
}
