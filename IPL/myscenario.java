package IPL;

import java.util.*;

public class myscenario {
    public void whoIsWinner(String  [] list,Integer year){
        System.out.println("The winner in the year "+year+" is "+list[year%2008]);
    }
    public void tiematches(Integer [] list_for_tie_matches,Integer year){
        System.out.println("The tie Matches in year "+year+" is "+list_for_tie_matches[year%2008]);
    }
}
