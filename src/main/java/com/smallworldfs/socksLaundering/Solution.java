package com.smallworldfs.socksLaundering;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*https://app.codility.com/programmers/trainings/3/socks_laundering/start/*/
class Solution{
    public static void main (String args[]){
        System.out.println(new Solution().solution(2,new int[] {1, 2, 1, 1},new int[] {1, 4, 3, 2, 4}));
        System.out.println(new Solution().solution(2,new int[] {1},new int[] { 3, 2, 5, 5}));
        System.out.println(new Solution().solution(3, new int[] {1, 2}, new int[] {8, 8, 8, 8, 9}));
    }
    public int solution(int K, int[] C, int[] D) {
        Map<Integer, Integer> cleanSocks = processInput(C);
        Map<Integer, Integer> dirtySocks = processInput(D);
        for (int k=0; k < K; k++) {
            boolean aSockWasCleaned = false;
            aSockWasCleaned = washADirtySock(cleanSocks, dirtySocks, true, false);
            if(!aSockWasCleaned){
                washADirtySock(cleanSocks, dirtySocks, false, true);
            }
        }
        return processCleanPairs(cleanSocks);
    }

    private boolean washADirtySock(Map<Integer, Integer> cleanSocks, Map<Integer, Integer> dirtySocks, boolean iterateOnClean, boolean findPaired){
        boolean aSockWasCleaned = false;
        Iterator it;
        Map<Integer, Integer> candidateSocksToMatch;

        if (iterateOnClean) {
            it = cleanSocks.keySet().iterator();
            candidateSocksToMatch = cleanSocks;
        } else {
            it = dirtySocks.keySet().iterator();
            candidateSocksToMatch = dirtySocks;
        }

        while (it.hasNext() && !aSockWasCleaned) {
            int key = ((Integer) it.next()).intValue();
            if (!findPaired && !areSocksPaired(candidateSocksToMatch.get(key).intValue())
            || findPaired && areSocksPaired(candidateSocksToMatch.get(key).intValue())) {
                aSockWasCleaned = cleanADirtyOne(key, cleanSocks, dirtySocks);
            }
        }
        return aSockWasCleaned;
    }

    private Map<Integer, Integer> processInput(int[] C){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Arrays.stream(C).forEach(x -> map.put(x , map.computeIfAbsent(x, s -> 0) + 1));
        return map;
    }

    private boolean areSocksPaired(int socksAmount){
        if (socksAmount % 2 > 0) {
            return false;
        } else {
            return true;
        }
    }

    private int countPairs(int socksAmount){
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

    private int processCleanPairs(Map<Integer, Integer> cleanSocks){
        int pairs = 0;
        Iterator it = cleanSocks.keySet().iterator();
        while (it.hasNext()) {
            int key = ((Integer) it.next()).intValue();
            pairs= pairs + countPairs(cleanSocks.get(key).intValue()) ;
        }
        return pairs;
    }
}