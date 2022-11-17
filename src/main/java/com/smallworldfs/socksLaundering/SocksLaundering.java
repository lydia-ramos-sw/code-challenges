package com.smallworldfs.socksLaundering;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*https://app.codility.com/programmers/trainings/3/socks_laundering/start/*/
class SocksLaundering {
    public static void main (String args[]){
        System.out.println(solution(2,new int[] {1, 2, 1, 1},new int[] {1, 4, 3, 2, 4}));
        System.out.println(solution(2,new int[] {1},new int[] { 3, 2, 5, 5}));
        System.out.println(solution(3, new int[] {1, 2}, new int[] {8, 8, 8, 8, 9}));
    }
    public static int solution(int K, int[] C, int[] D) {
        Map<Integer, Integer> cleanSocks = processInput(C);
        Map<Integer, Integer> dirtySocks = processInput(D);
        for (int k=0; k < K; k++) {
            Iterator it = cleanSocks.keySet().iterator();
            boolean aSockWasCleaned = false;
            while (it.hasNext() && !aSockWasCleaned) {
                int key = ((Integer) it.next()).intValue();
                if (!areSocksPaired(cleanSocks.get(key).intValue())) {
                    aSockWasCleaned = cleanADirtyOne(key, cleanSocks, dirtySocks);
                }
            }
            if(!aSockWasCleaned){
                Iterator it2 = dirtySocks.keySet().iterator();
                while (it2.hasNext() && !aSockWasCleaned) {
                    int key = ((Integer) it2.next()).intValue();
                    if (areSocksPaired(dirtySocks.get(key).intValue())) {
                        aSockWasCleaned = cleanADirtyOne(key, cleanSocks, dirtySocks);
                    }
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

    private static boolean cleanADirtyOne(int position, Map<Integer, Integer> cleanSocks, Map<Integer, Integer> dirtySocks) {
        if (dirtySocks.get(position)!= null && dirtySocks.get(position).intValue() > 0){
            cleanSocks.put(position, ((cleanSocks.get(position)!=null)?cleanSocks.get(position).intValue():0) + 1);
            dirtySocks.put(position, dirtySocks.get(position).intValue() - 1);
            return true;
        } else {
            return false;
        }
    }

    private static int processCleanPairs(Map<Integer, Integer> cleanSocks){
        int pairs = 0;
        Iterator it = cleanSocks.keySet().iterator();
        while (it.hasNext()) {
            int key = ((Integer) it.next()).intValue();
            if (areSocksPaired(cleanSocks.get(key).intValue())) {
                pairs= pairs + countPairs(cleanSocks.get(key).intValue()) ;
            }
        }
        return pairs;
    }
}