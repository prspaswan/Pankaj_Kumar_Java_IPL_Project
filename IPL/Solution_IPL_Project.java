package IPL;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution_IPL_Project {
    public static void main(String[] args) {
             String [] list=new String[10];
             HashMap<Integer,Integer> Year_match=new HashMap<>();
             HashSet<String> allTeam= new HashSet<>();
            HashMap<HashMap<Integer,String>,Integer> nm=new HashMap<>();
            HashMap<Integer,String> y_t=new HashMap<>();
            Integer val;
            String iplFile = "/home/pankajkumar/Desktop/IPL_Project/IPL/matches.csv";
            String line = "";
            BufferedReader reader=null;
            Integer temp=0;

            try {

                //Reading the CsvIPLfile
                String[] row;
                reader = new BufferedReader(new FileReader(iplFile));
                while ((line = reader.readLine()) != null) {
                    row = line.split(",");

                    // creating Hashmap for first problem
                    if (!row[1].equals("season")) {
                        val = Integer.parseInt(row[1]);
                        if (row[8].equals("tie") || row[8].equals("normal")) {
                            if (Year_match.containsKey(val)) {
                                Year_match.put(val, Year_match.get(val) + 1);
                            } else {
                                Year_match.put(val, 1);
                            }
                        }

                        allTeam.add(row[4]);
                        y_t.clear();
                        y_t.put(val, row[10]);
                        if (nm.containsKey(y_t)) {
                            nm.put(y_t, nm.get(y_t) + 1);
                        } else {
                            nm.put(y_t, 1);
                        }

                        //creating list for own scenario
                        if (nm.get(y_t) > temp) {
                            list[val % 2008] = row[10];
                        }
                        else if (nm.get(y_t).equals(temp)) {
                            list[val % 2008] += row[10];
                        }

                    }
                }
            }
             catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            y_t.clear();
            Scanner sc=new Scanner(System.in);
            String team=sc.nextLine();
            Integer year =sc.nextInt();
           y_t.put(year,team);
        if(year<2008 || year>2017){
            try{
                throw new myexception();
            }
            catch (myexception d){
                d.printStackTrace();
            }
        }


        else {
            IPLMatchPlayedEveryaYear c1 = new IPLMatchPlayedEveryaYear();
            c1.totalMatchInYear(Year_match,year);
            NumberOfMatchesWon c2 = new NumberOfMatchesWon();
            c1.wonMatches(nm,year,team,y_t);
            myscenario c3=new myscenario();
            c3.whoIsWinner(list,year);

        }

    }
}
