package org.kifiukvasyl;

import dagger.Component;

import javax.inject.Singleton;


@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    Menu getMenu();
}
