package IPL;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution_IPL_Project {
    public static void main(String[] args) {
            HashMap<Integer,Integer> Year_match=new HashMap<>();
            HashMap<HashMap<Integer,String>,Integer> nm=new HashMap<>();
            HashMap<Integer,String> y_t=new HashMap<>();
            Integer val;
            String iplFile = "/home/pankajkumar/Desktop/IPL_Project/IPL/matches.csv";
            String line = "";
            BufferedReader reader=null;

            try {
                String [] row;
                reader = new BufferedReader(new FileReader(iplFile));
                while ((line = reader.readLine()) != null) {
                    row = line.split(",");

                  if(!row[1].equals("season"))  {
                      val=Integer.parseInt(row[1]);
                      if(row[8].equals("tie") || row[8].equals("normal")){
                          if(Year_match.containsKey(val)){
                              Year_match.put(val,Year_match.get(val)+1);
                          }
                          else {
                              Year_match.put(val,1);
                          }
                      }
                      y_t.clear();

                      y_t.clear();
                      y_t.put(val,row[10]);
                      if(nm.containsKey(y_t)){
                          nm.put(y_t,nm.get(y_t)+1);
                      }
                      else{
                          nm.put(y_t,1);
                      }
                  }




                    /*
                    HashMap<Integer,String> kf=new HashMap<>();
            kf.put(88,"jfd");
            for (String[] row : csvData) {

                //System.out.println(Arrays.toString(row));
                String s=Arrays.toString(row);
                //System.out.println(s);
                ld=s.split(", ");
               if(!ld[1].equals("season")){
                 Integer val=Integer.parseInt(ld[1]);
                   //System.out.println(ld[8]);
                   if(ld[8].equals("tie") || ld[8].equals("normal")){
                       if(nf.containsKey(val)){
                           nf.put(val,nf.get(val)+1);
                       }
                       else {
                           nf.put(val, 1);
                       }
                       //HashMap<Integer,String> kf=new HashMap<>();
                       kf.clear();
                       kf.put(val,ld[10]);
                       if(nm.containsKey(kf)){
                           nm.put(kf,nm.get(kf)+1);
                       }
                       else{
                           nm.put(kf,1);
                       }
                     */


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
            Scanner sc=new Scanner(System.in);
            Integer year=sc.nextInt();
            String team=sc.nextLine();
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
            //NumberOfMatchesWon c2 = new NumberOfMatchesWon();

            c1.wonMatches(nm,year,team);
        }

    }
}
