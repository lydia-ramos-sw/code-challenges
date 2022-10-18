package com.smallworldfs.tierramedia;

import com.smallworldfs.tierramedia.fighters.Luchador;

import java.util.ArrayList;
import java.util.List;

public class Ejercito {
    List<Luchador> luchadores = new ArrayList<>();

    public List<Luchador> getLuchadores() {
        return luchadores;
    }

    public void setLuchadores(List<Luchador> luchadores) {
        this.luchadores = luchadores;
    }

    public int getValorEjercito() {
        return luchadores.stream().mapToInt(l -> l.getValue()).sum();
    }
}
