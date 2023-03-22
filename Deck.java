
package com.mycompany.card;

/**
 *
 * @author seOxn
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cartas;

    public Deck() {
        this.cartas = new ArrayList<>();
        String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] colores = {"Negro", "Rojo"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String palo : palos) {
            String color;
            if (palo.equals("Corazones") || palo.equals("Diamantes")) {
                color = "Rojo";
            } else {
                color = "Negro";
            }
            for (String valor : valores) {
                Card card = new Card(palo, color, valor);
                this.cartas.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cartas);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        Card card = this.cartas.remove(0);
        System.out.println(card);
        System.out.println("Quedan " + cartas.size() + " cartas en el deck.");
    }

    public void pick() {
        int randomIndex = (int) (Math.random() * this.cartas.size());
        Card card = this.cartas.remove(randomIndex);
        System.out.println(card);
        System.out.println("Quedan " + cartas.size() + " cartas en el deck.");
    }

    public void hand() {
        if (cartas.size() < 5) {
            System.out.println("No hay suficientes cartas en el deck.");
            return;
        }

        for (int i = 0; i < 5; i++) {
            Card card = this.cartas.remove(0);
            System.out.println(card);
        }

        System.out.println("Quedan " + cartas.size() + " cartas en el deck.");
    }
}
