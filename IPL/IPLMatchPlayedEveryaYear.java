package IPL;

import java.time.Year;
import java.util.HashMap;
import java.util.Scanner;

public class IPLMatchPlayedEveryaYear extends NumberOfMatchesWon {
    public void totalMatchInYear(HashMap<Integer, Integer> Year_Match, Integer n) {


        System.out.println("Total Played matches in "+n+" is "+ Year_Match.get(n));
    }
}
