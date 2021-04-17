package civih.app.controller

import civih.app.Constants
import civih.app.model.Civilization
import java.io.File
import java.nio.file.Files

/**
 * @author DasDarki
 */
object CivilizationController {

    val civilizations: MutableList<Civilization> = mutableListOf()

    fun initialize() {
        val civsPath: String = System.getProperty("user.dir") + "/data/civs"
        for (civFile in File(civsPath).listFiles() ?: arrayOf()) {
            val content = String(Files.readAllBytes(civFile.toPath()))
            this.civilizations.add(Constants.GSON.fromJson(content, Civilization::class.java))
        }
    }
}