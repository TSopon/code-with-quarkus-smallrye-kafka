package org.acme;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import io.smallrye.mutiny.Multi;

@ApplicationScoped
public class Provider {

    @Outgoing("source")
    public Multi<String> source() {
        
        return Multi.createFrom().iterable(ReadTextFile.main(null));
        // return Multi.createFrom().items("hello", "SoponNiyomwan", "SmallRye", "reactive", "messaging");
    }
}
