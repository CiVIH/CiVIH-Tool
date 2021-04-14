package civih.app.i18n

import java.io.File
import java.nio.file.Files
import java.util.concurrent.ConcurrentHashMap

/**
 * @author DasDarki
 */
class Language(
    /**
     * The display name of the language.
     */
    val name: String,
    /**
     * The key of the language.
     */
    val key: String
) {

    /**
     * Whether the language was initialized successfully or not.
     */
    val isInitialized: Boolean

    private val contents: Map<String, String>

    init {
        this.contents = ConcurrentHashMap()
        val langPath: String = System.getProperty("user.dir") + "/langs/$key.lang"
        val langFile = File(langPath)
        if (langFile.exists()) {
            for (line in Files.readAllLines(langFile.toPath())) {
                if (line.startsWith("#")) continue;
                if (!line.contains("=")) continue;
                val parts: List<String> = line.split("=")
                val lkey: String = parts[0].trim()
                val value: String = parts[1].trim()
                this.contents[lkey] = value
            }
            this.isInitialized = true
        } else {
            this.isInitialized = false
            println("ERROR: Language File ${langFile.absolutePath} is not existing!")
        }
    }

    /**
     * Returns the translated text of the given key.
     */
    fun get(key: String): String = if (this.contents.containsKey(key)) this.contents[key] ?: key else key
}