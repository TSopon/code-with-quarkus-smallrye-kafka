package org.acme;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.mutiny.Multi;

@ApplicationScoped
public class QuickStart {

    @Incoming("source")
    @Outgoing("processed-a")
    public String toUpperCase(String payload) {
        return payload.toUpperCase();
    }

    @Incoming("processed-a")
    @Outgoing("CBS-ST")
    public Multi<String> filter(Multi<String> input) {
        return input.select().where(item -> item.length() > 2);
    }

    @Incoming("CBS-ST")
    public void sink(String word) {
        System.out.println("CBS-ST >>" + word);
    }

}
