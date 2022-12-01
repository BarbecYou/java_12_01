package hu.petrik.rekurzio2;

public class BinarisFa<T extends Comparable<T>> {
    private BiFaElem<T> fej;

    public BinarisFa() {
        this.fej = null;
    }

    public void beszur(T ertek){
        if (this.fej == null){
            this.fej = new BiFaElem<>(ertek);
        } else {
            fej.beszur(ertek);
        }
    }

    @Override
    public String toString() {
        if (this.fej == null){
            return "";
        }
        return fej.toString();
    }

    private class BiFaElem<T extends Comparable<T>> {
        private T ertek;
        private BiFaElem<T> bal;
        private BiFaElem<T> jobb;

        public BiFaElem(T ertek) {
            this.ertek = ertek;
            this.bal = null;
            this.jobb = null;
        }

        public T getErtek() {
            return ertek;
        }

        public BiFaElem<T> getBal() {
            return bal;
        }

        public BiFaElem<T> getJobb() {
            return jobb;
        }

        public void setErtek(T ertek) {
            this.ertek = ertek;
        }

        public void setBal(BiFaElem<T> bal) {
            this.bal = bal;
        }

        public void setJobb(BiFaElem<T> jobb) {
            this.jobb = jobb;
        }

        public void beszur(T ertek) {
            if (ertek.compareTo(this.ertek) < 0){
                if (this.bal == null){
                    this.bal = new BiFaElem<>(ertek);
                }else {
                    this.bal.beszur(ertek);
                }

            } else {
                if (this.jobb == null){
                    this.jobb = new BiFaElem<>(ertek);
                } else {
                    this.jobb.beszur(ertek);
                }
            }
        }

        @Override
        public String toString() {
           String s = "";
           if (this.bal != null){
               s += this.bal.toString() + ", ";
           }
           s += ertek;
           if (this.jobb != null){
               s += ", " + this.jobb;
           }
           return s;
        }
    }
}
