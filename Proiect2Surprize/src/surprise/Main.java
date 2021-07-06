package surprise;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        AbstractGiveSurprises giveSurprises = new GiveSurpriseAndApplause("RANDOM", 1);
        System.out.println("Obiect 1 instantiat de tip Random /give surprise and applause");
        AbstractGiveSurprises giveSurprises2 = new GiveSurpriseAndHug("FIFO", 1);
        System.out.println("Obiect 2 instantiat de tip FIFO /give surprise and hug");
        AbstractGiveSurprises giveSurprises3 = new GiveSurpriseAndSing("LIFO", 1);
        System.out.println("Obiect 1 instantiat de tip LIFO /give surprise and sing");
        AbstractGiveSurprises giveSurprises4 = new GiveSurpriseAndSing("RANDOM", 1);
        System.out.println("Obiect 1 instantiat de tip Random /give surprise and sing");
        //4 obiecte create

        //popularea obiectelor cu surprize
        ArrayList<ISurprise> surprises = GatherSurprises.gather(5);
        System.out.println("Obiectul 1 a primit in tolba prin metoda .put(Isurprise), 5 surprize aleatorii create cu metoda statica ArrayList<Isurprise> gather(int)");
            for (ISurprise surprise : surprises) {
                giveSurprises.put(surprise);
            }

        ArrayList<ISurprise> surprises2 = GatherSurprises.gather(5);
        System.out.println("Obiectul 2 a primit in tolba prin metoda .put(Isurprise), 5 surprize aleatorii create cu metoda statica ArrayList<Isurprise> gather(int)");
        for (ISurprise surprise : surprises2) {
            giveSurprises2.put(surprise);
        }


        ArrayList<ISurprise> surprises3 = GatherSurprises.gather(3);
        System.out.println("Obiectul 3 a primit in tolba prin metoda .put(Isurprise), 3 surprize aleatorii create cu metoda statica ArrayList<Isurprise> gather(int)");
        for (ISurprise surprise : surprises3) {
            giveSurprises3.put(surprise);
        }

        ArrayList<ISurprise> surprises4 = GatherSurprises.gather(6);
        System.out.println("Obiectul 4 a primit in tolba prin metoda .put(Isurprise), 6 surprize random creata cu metoda statica ArrayList<Isurprise> gather(int)");
        for (ISurprise surprise : surprises4) {
            giveSurprises4.put(surprise);
        }
        System.out.println();
        System.out.println("Se printeaza continutul obiectului 1");
        System.out.println();

        giveSurprises.printAll();

        System.out.println();
        System.out.println("Se daruieste continutul tolbei 1(random)");
        System.out.println();

        giveSurprises.giveAll();

        System.out.println();
        System.out.println("Se printeaza continutul obiectului 2");
        System.out.println();

        giveSurprises2.printAll();

        System.out.println();
        System.out.println("Se daruieste continutul tolbei 2(FIFO)");
        System.out.println();

        giveSurprises2.giveAll();

        System.out.println();
        System.out.println("Se printeaza continutul obiectului 3");
        System.out.println();

        giveSurprises3.printAll();

        System.out.println();
        System.out.println("Se daruieste continutul tolbei 3(LIFO)");
        System.out.println();

        giveSurprises3.giveAll();

        System.out.println();
        System.out.println("Se printeaza continutul obiectului 4 de tip random");
        System.out.println();

        giveSurprises4.printAll();

        System.out.println();
        System.out.println("Se adauga obiectul 4 de tip random la continutul obiectului 3 de tip LIFO(cu metoda put(IBag) si printam apoi obiectul 3");
        System.out.println();

        giveSurprises3.put(giveSurprises4.moveBag());
        giveSurprises3.printAll();

        System.out.println();
        System.out.println("Continutul va fi daruit in mod LIFO nu RANDOM cum a fost initial obiectul pe care l-am adaugat");
        System.out.println();
        giveSurprises3.giveAll();







        }

    }

