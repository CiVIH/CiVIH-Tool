package civih.app.views

import civih.app.i18n.I18n
import tornadofx.View
import tornadofx.hbox
import tornadofx.label

/**
 * @author DasDarki
 */
class MainView : View(I18n.get("app.title")) {

    override val root = hbox {
        label("Hallo Welt!")
    }
}