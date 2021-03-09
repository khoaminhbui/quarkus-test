package org.kb.reactive;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReactiveService {
    public String getFromStream() {
        return "Stream content";
    }
}
