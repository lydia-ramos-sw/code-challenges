package com.smallworldfs.anagram;

import java.util.Arrays;

/**
 * Escribe una función que reciba dos String y retorne true o false según sean o no anagramas.
 * * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * * NO hace falta comprobar que ambas palabras existan.
 * * Dos palabras exactamente iguales no son anagrama.
 */
public class Challenge {
    public static void main (String args[]){
        System.out.println(isAnagrama("caca", "acac"));
        System.out.println(isAnagrama("hola", "halo"));
        System.out.println(isAnagrama("agranda", "Granada"));
        System.out.println(isAnagrama("delira", "LIDERA"));
    }

    public static boolean isAnagrama(String palabra1, String palabra2) {
        if (!checkLengths(palabra1, palabra2))
            return false;
        if (checkEqual(palabra1, palabra2))
            return false;

        return checkAnagram(palabra1, palabra2);
    }

    private static boolean checkLengths(String palabra1, String palabra2) {
        return palabra1.length() == palabra2.length();
    }

    private static boolean checkEqual(String palabra1, String palabra2) {
        return palabra1.equalsIgnoreCase(palabra2);
    }

    private static boolean checkAnagram(String palabra1, String palabra2) {
        char[] cPalabra1 = palabra1.toLowerCase().toCharArray();
        char[] cPalabra2 = palabra2.toLowerCase().toCharArray();
        Arrays.sort(cPalabra1);
        Arrays.sort(cPalabra2);
        return Arrays.equals(cPalabra1,cPalabra2) ;
    }
}
