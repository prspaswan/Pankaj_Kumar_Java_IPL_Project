package IPL;

import java.util.HashMap;
import java.util.Scanner;

public class NumberOfMatchesWon {
      public void wonMatches(HashMap<HashMap<Integer,String>,Integer> nm,Integer n,String team,HashMap<Integer,String> v) {

        System.out.println("Total won Matches by "+team+" in "+n+" is "+nm.get(v));

    }
}
