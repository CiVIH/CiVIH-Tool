package civih.app.model

/**
 * @author DasDarki
 */
class Affiliation(
    /**
     * The type of affiliation.
     */
    var type: Type,
    /**
     * The value - if there is one - of the affiliation.
     */
    var value: String = ""
) {

    enum class Type {

        MOD, DLC, GAME
    }
}