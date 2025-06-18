package org.kifiukvasyl;

public class Main {
    public static void main(String[] args){
        AppComponent appComponent = DaggerAppComponent.create();
        var menu = appComponent.getMenu();
        menu.menu();
    }
}