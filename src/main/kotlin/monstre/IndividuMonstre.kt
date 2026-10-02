package monstre

import dresseur.Entraineur
import kotlin.math.pow
import kotlin.math.roundToInt

class IndividuMonstre(
    var id: Int,
    var nom: String,
    expInit: Double,
    var espece: EspeceMonstre,
    var entraineur: Entraineur? = null,
) {
    var niveau: Int = 1
    var attaque: Int = espece.baseAttaque + (-2..2).random()
    var defense: Int = espece.baseDefense + (-2..2).random()
    var vitesse: Int = espece.baseVitesse + (-2..2).random()
    var attaqueSpe: Int = espece.baseAttaqueSpe + (-2..2).random()
    var defenseSpe: Int = espece.baseDefenseSpe + (-2..2).random()
    var pvMax: Int = espece.basePv + (-5..5).random()
    val potentiel: Double = (5..20).random() / 10.0

    var exp: Double = 0.0
        get() = field
        set(value) {
            field = value
            val estNiveau1 = if (niveau == 1) true else false
            while (field >= palierExp(niveau)) {
                levelUp()
                if (estNiveau1 == false) {
                    println("Le monstre $nom est maintenant niveau $niveau !")
                }
            }
        }

    /**
     * @property pv Points de vie actuels.
     * Ne peut pas être inférieur à 0 ni supérieur à [pvMax].
     */
    var pv: Int = pvMax
        get() = field
        set(nouveauPv) {
            if (nouveauPv < 0) {
                field = 0
            } else if (nouveauPv > pvMax) {
                field = pvMax
            } else {
                field = nouveauPv
            }
        }

    init {
        this.exp = expInit // applique le setter et déclenche un éventuel level-up
    }

    /**
     * Calcule l'expérience totale nécessaire pour atteindre un niveau donné.
     *
     * @param niveau Niveau cible.
     * @return Expérience cumulée nécessaire pour atteindre ce niveau.
     */
    fun palierExp(niveau: Int): Double {
        return 100 * (niveau - 1).toDouble().pow(2.0)
    }

    /**
     * Fait monter le monstre d'un niveau et augmente ses caractéristiques.
     */
    fun levelUp() {
        niveau += 1
        attaque += (espece.modAttaque * potentiel).roundToInt() + (-2..2).random()
        defense += (espece.modDefense * potentiel).roundToInt() + (-2..2).random()
        vitesse += (espece.modVitesse * potentiel).roundToInt() + (-2..2).random()
        attaqueSpe += (espece.modAttaqueSpe * potentiel).roundToInt() + (-2..2).random()
        defenseSpe += (espece.modDefenseSpe * potentiel).roundToInt() + (-2..2).random()
        val gainPv = (espece.modPv * potentiel).roundToInt() + (-5..5).random()
        pvMax += gainPv
        pv += gainPv
    }
}