package com.smallworldfs.descent;

import java.util.*;

class Player {
    public static void main(String args[]) {
        // game loop
        while (true) {
            Map<Integer, Integer> mountainHeights = processInput();
            bombPeak(highestPeak(mountainHeights));
        }
    }

    public static Map<Integer, Integer>  processInput(){
        Map<Integer, Integer> mountainHeights = new HashMap<>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 8; i++) {
            int mountainH = in.nextInt(); // represents the height of one mountain.
            mountainHeights.put(i, mountainH);
        }
        return mountainHeights;
    }

    public static Map.Entry<Integer, Integer> highestPeak(Map<Integer, Integer> map) {
        Map.Entry<Integer, Integer> maxEntry = map.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElse(null);
        return maxEntry;
    }

    public static void bombPeak(Map.Entry<Integer, Integer> maxEntry) {
        System.out.println(maxEntry.getKey());
    }
}