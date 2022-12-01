package hu.petrik.lancoltlista;

public class LancoltLista<T> {
    private ListaElem elsoElem = null;
    private ListaElem utolsoElem = null;

    public void hozzaad(T ertek) {
        ListaElem ujElem = new ListaElem(ertek);
        ujElem.setElozo(this.utolsoElem);
        if (this.elsoElem == null) {
            this.elsoElem = ujElem;
        } else {
            this.utolsoElem.setKovetkezo(ujElem);
        }
        this.utolsoElem = ujElem;
    }

    public boolean tartalmazzaE_nemRek(T ertek){
        ListaElem jelenlegi = this.elsoElem;
        while (jelenlegi != null){
            if (jelenlegi.ertek == ertek){
                return true;
            }
            jelenlegi = jelenlegi.kovetkezo;
        }
        return false;
    }

    public boolean tartalmazzaE_rek(T ertek){
        if (this.elsoElem.egyenlo(ertek)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       ListaElem jelenlegiElem = this.elsoElem;
       if (jelenlegiElem != null){
           sb.append(" ").append(jelenlegiElem);
           jelenlegiElem = jelenlegiElem.kovetkezo;
       }
       while (jelenlegiElem != null){
           sb.append(", ").append(jelenlegiElem);
           jelenlegiElem = jelenlegiElem.kovetkezo;
       }
       return sb.toString();
    }

    private class ListaElem {
        private T ertek;
        private ListaElem kovetkezo = null;
        private ListaElem elozo = null;

        public ListaElem(T ertek) {
            this.ertek = ertek;
        }

        public ListaElem getKovetkezo() {
            return kovetkezo;
        }

        public ListaElem getElozo() {
            return elozo;
        }

        public void setKovetkezo(ListaElem kovetkezo) {
            this.kovetkezo = kovetkezo;
        }

        public void setElozo(ListaElem elozo) {
            this.elozo = elozo;
        }

        public boolean egyenlo(T ertek){
            boolean contains = false;
            if (this.ertek == ertek){
                contains = true;
            } else {
                if (this.kovetkezo != null){
                    contains = this.kovetkezo.egyenlo(ertek);
                }
            }
            return contains;
        }

        @Override
        public String toString() {
            return this.ertek.toString();
        }
    }
}
