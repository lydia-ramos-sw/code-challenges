package com.smallworldfs.socksLaundering;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SocksLaundering {
    public static void main (String args[]){
        System.out.println(solution(2,new int[] {1, 2, 1, 1},new int[] {1, 4, 3, 2, 4}));
    }
    public static int solution(int K, int[] C, int[] D) {
        Map<Integer, Integer> cleanSocks = processInput(C);
        Map<Integer, Integer> dirtySocks = processInput(D);
        for (int k=0; k < K; k++) {
            for (int i = 0; i < cleanSocks.size(); i++) {
                if (!areSocksPaired(cleanSocks.get(i + 1).intValue())) {
                    cleanADirtyOne(i + 1, cleanSocks, dirtySocks);
                }
            }
        }
        return processCleanPairs(cleanSocks);
    }

    private static Map<Integer, Integer> processInput(int[] C){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Arrays.stream(C).forEach(x -> map.put(x , map.computeIfAbsent(x, s -> 0) + 1));
        return map;
    }

    private static boolean areSocksPaired(int socksAmount){
        if (socksAmount % 2 > 0) {
            return false;
        } else {
            return true;
        }
    }

    private static int countPairs(int socksAmount){
        return (int) socksAmount / 2;
    }

    private static void cleanADirtyOne(int position, Map<Integer, Integer> cleanSocks, Map<Integer, Integer> dirtySocks) {
        if (dirtySocks.get(position)!= null && dirtySocks.get(position).intValue() > 0){
            cleanSocks.put(position, cleanSocks.get(position).intValue() + 1);
            dirtySocks.put(position, dirtySocks.get(position).intValue() - 1);
        }
    }

    private static int processCleanPairs(Map<Integer, Integer> cleanSocks){
        int pairs = 0;
        for (int i = 0; i < cleanSocks.size(); i++) {
            if (areSocksPaired(cleanSocks.get(i + 1).intValue())) {
                pairs= pairs + countPairs(cleanSocks.get(i + 1).intValue()) ;
            }
        }
        return pairs;
    }
}