package hu.petrik.lancoltlista;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LancoltLista<Integer> lista = new LancoltLista<>();
        int elemekSzama = 690;
        int legkisebb = 1;
        int legnagyobb = 420;
        LocalDateTime startTime = LocalDateTime.now();
        for (int i = 0; i < elemekSzama; i++) {
            int ertek = (int)(Math.random() * (legnagyobb - legkisebb + 1) + legkisebb);
            lista.hozzaad(ertek);
        }
        LocalDateTime endTime = LocalDateTime.now();
        Duration elapsed = Duration.between(startTime, endTime);
        System.out.println("eltelt ido: " + elapsed.getNano());
        System.out.println(lista);
        System.out.println(lista.tartalmazzaE_nemRek(119));
        System.out.println(lista.tartalmazzaE_rek(119));
    }
}
