package IPL;

import java.util.*;

public class myscenario {
    public void whoIsWinner(String  [] list,Integer year){
        System.out.println("The winner in the year "+year+" is "+list[year%2008]);
    }
}
