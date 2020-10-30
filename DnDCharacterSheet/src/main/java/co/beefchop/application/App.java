package co.beefchop.application;

import co.beefchop.controller.Controller;
import co.beefchop.repository.repository.Repository;
import co.beefchop.view.LoadView;

public class App {
    public static void main( String[] args ) {
        App app = new App();
    }

    public App() {
        Repository repository = new Repository();
        Controller controller = new Controller(repository);
        LoadView loadView = new LoadView(controller);
    }
}