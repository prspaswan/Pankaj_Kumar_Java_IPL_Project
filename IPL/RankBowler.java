package IPL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class RankBowler {
    public void Extras_in_2016(HashMap<String, Integer> extra_run,String team) {
        if(extra_run.containsKey(team)) {
            System.out.println("Total Extra in 2016 given by " + team + " is " + extra_run.get(team));
        }
        else{
            System.out.println(team+" did not played in 2016");
        }
    }

    public void Top_bowler(int c, String[] rank, Integer[] array, HashMap<String, Integer> calc) {
        int i = 0;
        Integer x;
        String key;
        for (Map.Entry<String, Integer> itr : calc.entrySet()) {
            key = itr.getKey();
            x = itr.getValue();
            for (i = 0; i < c; i++) {
                if (itr.getValue() == array[i]) {
                    rank[i] = key;
                }
            }
        }
        System.out.println("The Rank are as follows");
        for (i = 0; i < c; i++) {
            System.out.print(rank[i]+" ");
        }

    }
}

