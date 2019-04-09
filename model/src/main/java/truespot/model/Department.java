package truespot.model;

import lombok.Getter;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@Table(name="department", schema="public")
public enum Department implements Serializable {

    Ain(1, "Ain"),
    Aisne(2, "Aisne"),
    Allier(3, "Allier"),
    AlpesDeHautesProvence(4, "Alpes de Hautes-Provence"),
    HautesAlpes(5, "Hautes-Alpes"),
    AlpesMaritimes(6, "Alpes-Maritimes"),
    Ardeche(7, "Ardèche"),
    Ardennes(8, "Ardennes"),
    Ariege(9, "Ariege"),
    Aube(10, "Aube"),
    Aude(11, "Aude"),
    Aveyron(12, "Aveyron"),
    BouchesDuRhone(13, "Bouches-Du-Rhône"),
    Calvados(14, "Calvados"),
    Cantal(15, "Cantal"),
    Charente(16, "Charente"),
    CharenteMaritime(17, "Charente-Maritime"),
    Cher(18, "Cher"),
    Correze(19, "Correze"),
    CorseDuSud(20, "Corse-du-Sud"),
    HauteCorse(20, "HauteCorse"),
    CoteDOr(21, "Cöte-d'Or"),
    CotesDArmor(22, "Côtes d'Armor"),
    Creuse(23, "Creuse"),
    Dordogne(24, "Dordogne"),
    Doubs(25, "Doubs"),
    Drome(26, "Drôme"),
    Eure(27, "Eure"),
    EureEtLoir(28, "Eure-et-Loir"),
    Finistere(29, "Finistere"),
    Gard(30, "Gard"),
    HauteGaronne(31, "Haute-Garonne"),
    Gers(32, "Gers"),
    Gironde(33, "Gironde"),
    Herault(34, "Hérault"),
    IlleEtVilaine(35, "Ille-et-Vilaine"),
    Indre(36, "Indre"),
    IndreEtLoire(37, "Indre-et-Loire"),
    Isere(38, "Isère"),
    Jura(39, "Jura"),
    Landes(40, "Landes"),
    LoirEtCher(41, "Loir-er-Cher"),
    Loire(42, "Loire"),
    HauteLoire(43, "Haute-Loire"),
    LoireAtlantique(44, "Loire-Atlantique"),
    Loiret(45, "Loiret"),
    Lot(46, "Lot"),
    LotEtGaronne(47, "Lot-et-Garonne"),
    Lozere(48, "Lozère"),
    MaineEtLoire(49, "Maine-et-Loire"),
    Manche(50, "Manche"),
    Marne(51, "Marne"),
    HauteMarnes(52, "Haute-Marne"),
    Mayenne(53, "Mayenne"),
    MeurtheEtMoselle(54, "Meurthe-et-Moselle"),
    Meuse(55, "Meuse"),
    Morbihan(55, "Morbihan"),
    Moselle(57, "Moselle"),
    Nièvre(58, "Nièvre"),
    Nord(59, "Nord"),
    Oise(60, "Oise"),
    Orne(61, "Orne"),
    PasDeCalais(62, "Pas-de-Calais"),
    PuyDeDome(63, "Puy-de-Dôme"),
    PyreneesAtlantiques(64, "Pyrénées-Atlantique"),
    HautesPyrenees(65, "Hautes-Pyrénées"),
    PyreneesOrientales(66, "Pyrénées-Orientales"),
    BasRhin(67, "Bas-Rhin"),
    HautRhin(68, "Haut-Rhin"),
    Rhone(69, "Rhône"),
    HauteSâone(70, "Haute-Sâone"),
    SaoneEtLoire(71, "Sâone-et-Loire"),
    Sarthes(72, "Sarthes"),
    Savoie(73, "Savoie"),
    HauteSavoie(74, "Haute-Savoie"),
    Paris(75, "Paris"),
    SeineMaritime(76, "Seine-Maritime"),
    SeineEtMarne(77, "Seine-et-Marne"),
    Yvelines(78, "Yvelines"),
    DeuxSevres(79, "Deux-Sèvres"),
    Somme(80, "Somme"),
    Tarn(81, "Tarn"),
    TarnEtGaronne(82, "Tarn-et-Garonne"),
    Var(83, "Var"),
    Vaucluse(84, "Vaucluse"),
    Vendee(85, "Vendée"),
    Viennes(86, "Viennes"),
    HauteVienne(87, "Haute-Vienne"),
    Vosges(88, "Vosges"),
    Yonne(89, "Yonne"),
    TerritoireDeBelfort(90, "Territoire-de-Belfort"),
    Essone(91, "Essonne"),
    HautsDeSeine(92, "Hauts-de-Seine"),
    SeineSaintDenis(93, "Seine-Saint-Denis"),
    ValDeMarne(94, "Val-de-marne"),
    ValDOise(95, "Val-d'oise");





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="deparment_number")
    private Integer number;

    @Column(name="department_name")
    private String name;

    Department(Integer number, String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" + "number=" + number + ", name='" + name + '\'' + '}';
    }
}