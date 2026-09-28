package monstre

import java.io.File

/**
 * Représente une espèce de monstre (et pas un individu).
 *
 * @property id Numéro de l'espèce.
 * @property nom Nom de l'espèce.
 * @property type Type de l'espèce.
 * @property baseAttaque Statistique d'attaque de base de l'espèce.
 * @property baseDefense Statistique de défense de base de l'espèce.
 * @property baseVitesse Statistique de vitesse de base de l'espèce.
 * @property baseAttaqueSpe Statistique d'attaque spéciale de base de l'espèce.
 * @property baseDefenseSpe Statistique de défense spéciale de base de l'espèce.
 * @property basePv Points de vie de base de l'espèce.
 * @property modAttaque Multiplicateur d'attaque : sert à augmenter l'attaque quand le monstre monte de niveau.
 * @property modDefense Multiplicateur de défense : sert à augmenter la défense quand le monstre monte de niveau.
 * @property modVitesse Multiplicateur de vitesse : sert à augmenter la vitesse quand le monstre monte de niveau.
 * @property modAttaqueSpe Multiplicateur d'attaque spéciale : sert à augmenter l'attaque spéciale quand le monstre monte de niveau.
 * @property modDefenseSpe Multiplicateur de défense spéciale : sert à augmenter la défense spéciale quand le monstre monte de niveau.
 * @property modPv Multiplicateur de PV : sert à augmenter les points de vie max quand le monstre monte de niveau.
 * @property description Description de l'espèce.
 * @property particularites Particularités de l'espèce.
 * @property caractères Traits de caractère de l'espèce.
 */

class EspeceMonstre(
    var id: Int,
    var nom: String,
    var type: String,
    val baseAttaque: Int,
    val baseDefense: Int,
    val baseVitesse: Int,
    val baseAttaqueSpe: Int,
    val baseDefenseSpe: Int,
    val basePv: Int,
    val modAttaque: Double,
    val modDefense: Double,
    val modVitesse: Double,
    val modAttaqueSpe: Double,
    val modDefenseSpe: Double,
    val modPv: Double,
    val description: String = "",
    val particularites: String = "",
    val caractères: String = "",
) {

/**
 * Affiche la représentation artistique ASCII du monstre.
 *
 * @param deFace Détermine si l'art affiché est de face (true) ou de dos (false).
 *               La valeur par défaut est true.
 * @return Une chaîne de caractères contenant l'art ASCII du monstre avec les codes couleur ANSI.
 *         L'art est lu à partir d'un fichier texte dans le dossier resources/art.
 */
fun afficheArt(deFace: Boolean=true): String{
    val nomFichier = if(deFace) "front" else "back";
    val art=  File("src/main/resources/art/${this.nom.lowercase()}/$nomFichier.txt").readText()
    val safeArt = art.replace("/", "∕")
    return safeArt.replace("\\u001B", "\u001B")
}
}