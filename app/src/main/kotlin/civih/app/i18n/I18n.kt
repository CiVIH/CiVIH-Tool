package civih.app.i18n

import java.io.File
import java.util.concurrent.CopyOnWriteArrayList
import kotlin.system.exitProcess

/**
 * The i18n class manages all languages and the translation of them.
 *
 * @author DasDarki
 */
object I18n {

    /**
     * All registered languages of the current running app.
     */
    var languages: List<Language> = CopyOnWriteArrayList()

    private var selectedLanguage: Language

    init {
        this.selectedLanguage = Language("en")
        if (!this.selectedLanguage.isInitialized) {
            exitProcess(1)
        } else {
            this.languages += this.selectedLanguage
            for (langFile in File(System.getProperty("user.dir") + "/langs").listFiles() ?: arrayOf()) {
                if (langFile.nameWithoutExtension == "en") continue
                this.registerLanguage(langFile.nameWithoutExtension)
            }
        }
    }

    /**
     * Returns the translated text of the wanted key.
     */
    fun get(key: String): String {
        return this.selectedLanguage.get(key)
    }

    /**
     * Registers a language in the i18n system.
     */
    fun registerLanguage(key: String) {
        val language = Language(key)
        if (!language.isInitialized) return
        this.languages += language
    }

    /**
     * Selects a new language. If the language does not exist, the language won't be updated.
     */
    fun selectLanguage(key: String) {
        val language: Language? = this.languages.stream().filter { x -> x.key == key }.findFirst().orElse(null)
        if (language != null) {
            this.selectedLanguage = language
        }
    }
}