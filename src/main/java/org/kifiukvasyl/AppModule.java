package org.kifiukvasyl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.util.Scanner;

@Module
public class AppModule {

    @Singleton
    @Provides
    public ObjectMapper provideObjectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
