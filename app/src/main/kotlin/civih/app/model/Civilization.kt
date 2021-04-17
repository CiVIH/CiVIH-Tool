package civih.app.model

import civih.app.i18n.I18n

/**
 * @author DasDarki
 */
class Civilization(
    /**
     * The key of the civilization identifying it.
     */
    var key: String,
    /**
     * The icon of the civilization.
     */
    var icon: String,
    /**
     * The count of leaders the civilization contains.
     */
    var leaders: Int,
    /**
     * The affiliation of the civilization.
     */
    var affiliation: Affiliation
) {

    /**
     * Returns a list containing all names of all leaders of the civilization.
     */
    fun getLeaderNames(): MutableList<String> {
        val list: MutableList<String> = mutableListOf()
        for (i in 0 until leaders) {
            list.add(I18n.get("civilization.${this.key}.leader.$i"))
        }
        return list
    }

    /**
     * Returns the translated name of the civilization.
     */
    fun getName(): String {
        return I18n.get("civilization.${this.key}.name")
    }
}