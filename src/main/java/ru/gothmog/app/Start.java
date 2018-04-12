package ru.gothmog.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gothmog.app.config.AppConfig;
import ru.gothmog.app.enumeration.EnumPath;

public class Start extends Application {

    private static final Logger LOG = LoggerFactory.getLogger(Start.class);

    private ApplicationContext context;

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        try {
            super.init();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    LOG.info("Inicializando o contexto do Spring...");
                    context = new AnnotationConfigApplicationContext(AppConfig.class);
                    LOG.info("Contexto do Spring inicializado");
                }
            });
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public void start(final Stage stage) throws Exception {
        LOG.info("Starting Application");

        LOG.debug("Loading FXML for main view from: {}", EnumPath.HOME.getPath());

        final FXMLLoader loader = new FXMLLoader();
        final Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(EnumPath.HOME.getPath()));

        final Scene scene = new Scene(rootNode, 800, 450);
        scene.getStylesheets().add("/styles/styles.css");

        stage.setResizable(false);
        stage.setTitle("Контроль Управления");
        stage.setScene(scene);
        stage.show();
    }
}
