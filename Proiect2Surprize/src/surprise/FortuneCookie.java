package surprise;

import java.util.Random;

public class FortuneCookie implements ISurprise{
    private String fortune;
    private static String[] zicale = {"Norocul vine când ai cel mai tare nevoie de el.",
            " Ochiul altuia vede mai exigent decât al tău. ",
            " Cum îţi vei aşterne, aşa vei dormi. ",
            " Vântul doboară copacul cu rădacina mai slabă! ",
            " Tot ce se bate de la obisnuit, deranjeaza. neobisnuitul e intotdeauna suspect pana ce lumea se familiarizeaza cu el, banalizandu-l ",
            " Indrazneala omului superior o numim cutezanta, si o pretuim. indrazneala prostului o numim tupeu, si o dispretuim. dar cand aceasta din urma e incununata de succes, orice comentariu e de prisos: ramanem fara replica ",
            " Un an dintr-o viata este o viata rezumata intr-un an. caci an dupa an repetam, o data cu aceleasi anotimpuri, aceleasi idei despre lume si viata. ",
            " Cu cat suntem mai stersi si mai timizi, cu atat ne aratam mai trufasi, cu cat suntem mai vulnerabili, cu atat suntem iritabili, pentru ca nu ne-am putut afirma, pretindem ca am ales anonimatul. ",
            " Indoiala e o moneda cu doua fete: cine o priveste trebuie sa le aiba in vedere pe amandoua. ",
            "Cei ce intreaba primesc raspunsuri.",
            "Tot ce ii doresti vecinului o sa se intoarca impotriva ta.",
            "Varsta aduce expreienta si par carunt.",
            "Pentru orice lucru de care te ocupi cu seriozitate o sa fii rasplatit.",
            "Vrei să ştii ce îţi rezervă anul viitor? Mănâncă şi nu cerceta, oricum nu îl poţi schimba!",
            " O sa fii surprins de ce ascunde in spatele unor masti.",
            "Esti un master in pornirea problemelor.",
            "Fa-ti timp pentru hobby-urile tale.",
            "O discutie calma evita neintelegerile.",
            "Ideile tale sunt nepretuite.",
            "Dragostea incepe cu ochii.",
            "Ti-ai caldit o casa,\n" +
                    "Bogata, frumoasa,\n" +
                    "Dar vezi ca-n ea sa fie\n" +
                    "Si ceva armonie"};

    private FortuneCookie(String zicala) {
        this.fortune = zicala;
    }

    public static FortuneCookie generate() {
        FortuneCookie fortuneCookie = new FortuneCookie(zicale[random.nextInt(zicale.length)]);
        return fortuneCookie;
    }

    @Override
    public void enjoy() {
        System.out.println("Felicitari, ai primit fortune cookie cu mesajul: " + this.fortune);
    }
}
