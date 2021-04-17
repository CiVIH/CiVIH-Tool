import civih.app.views.MainView
import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.App
import tornadofx.launch

/**
 * The main class from where the application starts and loads all parts.
 */
class CivihApp : App(MainView::class) {

    override fun start(stage: Stage) {
        instance = this
        stage.width = 1280.0
        stage.height = 720.0
        stage.icons.add(Image(CivihApp::class.java.getResourceAsStream("icon.jpg")))
        super.start(stage)
    }

    companion object {
        lateinit var instance: CivihApp;
    }
}

fun main(args: Array<String>) {
    launch<CivihApp>(args)
}