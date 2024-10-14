package com.miti99.test.publisher;

import com.miti99.test.event.GenericEvent;
import com.miti99.test.type.A;
import com.miti99.test.type.B;
import io.micronaut.context.event.ApplicationEventPublisher;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/B")
public class BPublisher {

  private final ApplicationEventPublisher<GenericEvent<B>> eventPublisher;

  public BPublisher(ApplicationEventPublisher<GenericEvent<B>> eventPublisher) {
    this.eventPublisher = eventPublisher;
  }

  @Get
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    GenericEvent<B> event = new GenericEvent<>(new B());
    eventPublisher.publishEvent(event);
    return "fired B event";
  }
}
