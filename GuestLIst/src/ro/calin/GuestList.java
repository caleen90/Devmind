package ro.calin;

import java.io.Serializable;
import java.util.ArrayList;


public class GuestList implements Serializable {
    private String numeEveniment;
    private int nrTotalLocuri;
    private ArrayList<Guest> listaParticipanti;
    private ArrayList<Guest> listaAsteptare;
    private static final long serialVersionUID = 1L;

    public ArrayList<Guest> getListaParticipanti() {
        return listaParticipanti;
    }

    public ArrayList<Guest> getListaAsteptare() {
        return listaAsteptare;
    }

    public GuestList(String numeEveniment, int nrTotalLocuri) {
        this.nrTotalLocuri = nrTotalLocuri;
        this.listaParticipanti = new ArrayList<>();
        this.listaAsteptare = new ArrayList<>();
    }

    public int addToList (String lastName, String firstName, String email, String phoneNumber) {
        if (isAlreadyInList(lastName, firstName, email, phoneNumber)) {
            return -1;
        }
        if (this.listaParticipanti.size() < this.nrTotalLocuri) {
            this.listaParticipanti.add(new Guest(lastName, firstName, email, phoneNumber));
            return 0;
        }
        this.listaAsteptare.add(new Guest(lastName, firstName, email, phoneNumber));
        return this.listaAsteptare.size() ;
    }

    private boolean isAlreadyInList(String lastName, String firstName, String email, String phoneNumber) {
        for (Guest guest : this.listaParticipanti) {
            if (guest.hasSameName(lastName, firstName) || guest.getEmail().equalsIgnoreCase(email)
                    || guest.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public int checkByName(String lastName,String firstName) {
        for (Guest guest: this.listaParticipanti) {
            if(guest.hasSameName(lastName,firstName)) {
                return -1;
            }
        }
        for(int i = 0; i < this.listaAsteptare.size(); i++) {
            if(this.listaAsteptare.get(i).hasSameName(lastName,firstName)) {
                return i;
            }
        }
        return -2;
    }

    public int checkByEmail(String email) {
        for(Guest guest:this.listaParticipanti) {
            if(guest.getEmail().equalsIgnoreCase(email)){
                return -1;
            }
        }
        for(int i = 0; i < this.listaAsteptare.size(); i++) {
            if(this.listaAsteptare.get(i).getEmail().equalsIgnoreCase(email)) {
                return i;
            }
        }
        return -2;
    }

    public int checkByPhoneNumber(String phoneNumber) {
        for(Guest guest:this.listaParticipanti) {
            if(guest.getPhoneNumber().equalsIgnoreCase(phoneNumber)){
                return -1;
            }
        }
        for(int i = 0; i < this.listaAsteptare.size(); i++) {
            if(this.listaAsteptare.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                return i;
            }
        }
        return -2;
    }

    public boolean removeByName(String lastName, String firstName) {
        for (int i = 0; i < this.listaParticipanti.size(); i++) {
            if(this.listaParticipanti.get(i).hasSameName(lastName,firstName)) {
                removeParticipantByIndex(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeByEmail(String email) {
        for (int i = 0; i < this.listaParticipanti.size(); i++) {
            if (this.listaParticipanti.get(i).getEmail().equalsIgnoreCase(email)) {
                removeParticipantByIndex(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < this.listaParticipanti.size(); i++) {
            if (this.listaParticipanti.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                removeParticipantByIndex(i);
                return true;
            }
        }
        return false;
    }

    private  void removeParticipantByIndex(int i) {
        if(this.listaAsteptare.size() > 0) {
            this.listaParticipanti.remove(i);
            this.listaParticipanti.add(this.listaAsteptare.get(0));
            this.listaAsteptare.remove(0);
        } else {
            this.listaParticipanti.remove(i);
        }
    }

    public Guest searchByName(String lastName, String firstName) {
        for(Guest guest: this.listaParticipanti) {
            if (guest.hasSameName(lastName,firstName)) {
                return guest;
            }
        }
        for(Guest guest:this.listaAsteptare) {
            if(guest.hasSameName(lastName,firstName)) {
                return guest;
            }
        }
        return null;
    }

    public Guest searchByEmail(String email) {
        for(Guest guest: this.listaParticipanti) {
            if (guest.getEmail().equalsIgnoreCase(email)) {
                return guest;
            }
        }
        for(Guest guest: this.listaAsteptare) {
            if (guest.getEmail().equalsIgnoreCase(email)) {
                return guest;
            }
        }
        return null;
    }

    public Guest searchByPhoneNumber(String phoneNumber) {
        for(Guest guest: this.listaParticipanti) {
            if (guest.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                return guest;
            }
        }
        for(Guest guest: this.listaAsteptare) {
            if (guest.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                return guest;
            }
        }
        return null;
    }

    public void modifyGuest(Guest guest, int option, String newValue) {
        switch(option) {
            case 1:
                guest.setLastName(newValue);
                break;
            case 2:
                guest.setFirstName(newValue);
                break;
            case 3:
                guest.setEmail(newValue);
                break;
            case 4:
                guest.setPhoneNumber(newValue);
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }

    }

    public int availableSeats() {
        return this.nrTotalLocuri - this.listaParticipanti.size();
    }

    public int nrParticipanti() {
        return this.listaParticipanti.size();
    }

    public int waitingListNumber() {
        return this.listaAsteptare.size();
    }

    public int nrTotalPersoane() {
        return this.listaAsteptare.size() + this.listaParticipanti.size();
    }

    public ArrayList<Guest> partialSearchArr(String key) {
        ArrayList<Guest> partialSearchList = new ArrayList<>();
        for (Guest guest: listaParticipanti) {
            if(guestContains(key, guest)) {
                partialSearchList.add(guest);
            }
        }
        for (Guest guest: listaAsteptare) {
            if(guestContains(key, guest)) {
                partialSearchList.add(guest);
            }
        }
        return partialSearchList;
    }

    private boolean guestContains(String key, Guest guest) {
        return guest.partialSearch(key).getLastName() != null ||
                guest.partialSearch(key).getFirstName() != null ||
                guest.partialSearch(key).getEmail() != null ||
                guest.partialSearch(key).getPhoneNumber() != null;
    }



}

