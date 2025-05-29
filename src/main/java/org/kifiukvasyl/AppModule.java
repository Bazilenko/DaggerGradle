package org.kifiukvasyl;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.util.Scanner;

@Module
public class AppModule {

    @Singleton
    @Provides
    public Menu provideMenu(MenuScan menuScan, Printer printer){
        return new Menu(menuScan, printer);
    }
}
