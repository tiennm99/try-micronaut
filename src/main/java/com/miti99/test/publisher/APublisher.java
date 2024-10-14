package com.miti99.test.publisher;

import com.miti99.test.event.GenericEvent;
import com.miti99.test.type.A;
import io.micronaut.context.event.ApplicationEventPublisher;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/A")
public class APublisher {

  private final ApplicationEventPublisher<GenericEvent<A>> eventPublisher;

  public APublisher(ApplicationEventPublisher<GenericEvent<A>> eventPublisher) {
    this.eventPublisher = eventPublisher;
  }

  @Get
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    GenericEvent<A> event = new GenericEvent<>(new A());
    eventPublisher.publishEvent(event);
    return "fired A event";
  }
}
