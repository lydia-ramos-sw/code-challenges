package com.smallworldfs.tierramedia;

import com.smallworldfs.tierramedia.fighters.Luchador;
import com.smallworldfs.tierramedia.fighters.bueno.Peloso;
import com.smallworldfs.tierramedia.fighters.malo.Orco;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales a Sauron contra otras que no quieren que el mal reine sobre sus tierras.
Cada raza tiene asociado un "valor" entre 1 y 5:
	- Razas good: Pelosos (1), Sureños buenos (2), Enanos (3), Númenóreanos (4), Elfos (5)
	- Razas bad: Sureños malos (2), Orcos (2), Goblins (2), Huargos (3), Trolls (5)
Crea un programa que calcule el resultado de la batalla entre los 2 tipos de ejércitos:
	- El resultado puede ser que gane el bien, el mal, o exista un empate. Dependiendo de la suma del valor del ejército y el número de integrantes.
	- Cada ejército puede estar compuesto por un número de integrantes variable de cada raza.
	- Tienes total libertad para modelar los datos del ejercicio.
Ej: 1 Peloso pierde contra 1 Orco, 2 Pelosos empatan contra 1 Orco, 3 Pelosos ganan a 1 Orco.
 */
public class GuerraEnTierraMedia {
    public static void main(String args[]) {
        Ejercito lealesGandalf = new Ejercito();
        Ejercito lealesSauron = new Ejercito();

        List<Luchador> luchadoresGandalf = new ArrayList<>();
        luchadoresGandalf.add(new Peloso());
        lealesGandalf.setLuchadores(luchadoresGandalf);
        List<Luchador> luchadoresSauron = new ArrayList<>();
        luchadoresSauron.add(new Orco());
        lealesSauron.setLuchadores(luchadoresSauron);

        System.out.println("Ejercito Ganfald " + fight(lealesGandalf, lealesSauron) + " Ejercito Sauron");

        List<Luchador> luchadoresGandalf2 = new ArrayList<>();
        luchadoresGandalf2.add(new Peloso());
        luchadoresGandalf2.add(new Peloso());
        lealesGandalf.setLuchadores(luchadoresGandalf2);
        List<Luchador> luchadoresSauron2 = new ArrayList<>();
        luchadoresSauron2.add(new Orco());
        lealesSauron.setLuchadores(luchadoresSauron2);

        System.out.println("Ejercito Ganfald " + fight(lealesGandalf, lealesSauron) + " Ejercito Sauron");

        List<Luchador> luchadoresGandalf3 = new ArrayList<>();
        luchadoresGandalf3.add(new Peloso());
        luchadoresGandalf3.add(new Peloso());
        luchadoresGandalf3.add(new Peloso());
        lealesGandalf.setLuchadores(luchadoresGandalf3);
        List<Luchador> luchadoresSauron3 = new ArrayList<>();
        luchadoresSauron3.add(new Orco());
        lealesSauron.setLuchadores(luchadoresSauron3);

        System.out.println("Ejercito Ganfald " + fight(lealesGandalf, lealesSauron) + " Ejercito Sauron");
    }

    private static String fight(Ejercito e1, Ejercito e2) {
        if (e1.getValorEjercito() > e2.getValorEjercito()) {
            return "gana ";
        } else if (e1.getValorEjercito() == e2.getValorEjercito()) {
            return "empata";
        } else {
            return "pierde";
        }
    }
}


