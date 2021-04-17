package civih.app

import com.google.gson.Gson
import com.google.gson.GsonBuilder

/**
 * @author DasDarki
 */
object Constants {

    val GSON: Gson = GsonBuilder().setPrettyPrinting().create()
}