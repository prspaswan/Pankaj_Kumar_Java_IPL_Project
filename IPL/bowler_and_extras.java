package IPL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class bowler_and_extras {
    public static void main(String[] args) throws IOException {

        String file = "/home/pankajkumar/Desktop/IPL_Project/IPL/deliveries.csv";
        BufferedReader reader = null;
        String line = "";
        String st;
        int c = 0;
        HashMap<String, Integer> extra_run= new HashMap<>();
        HashMap<String, Integer> calc = new HashMap<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                // System.out.println(row[]);
                if (!row[0].equals("match_id")) {
                    int val = Integer.parseInt(row[0]);
                    if (val >= 577) {
                        Integer ex_run = Integer.parseInt(row[16]);
                        if (extra_run.containsKey(row[2])) {
                            extra_run.put(row[2], extra_run.get(row[2]) + ex_run);
                        } else {
                            extra_run.put(row[2], ex_run);
                        }
                    }
                    if (val >= 518 && val <= 576) {
                        Integer t_r = Integer.parseInt(row[17]);
                        if (calc.containsKey(row[8])) {
                            calc.put(row[8], calc.get(row[8]) + t_r);
                        } else {
                            calc.put(row[8], t_r);
                        }

                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

        int i = 0;
        Integer[] array = new Integer[107];
        for (Map.Entry<String, Integer> it : calc.entrySet()) {
            array[i] = it.getValue();
            i++;
            c++;
        }
        String[] rank = new String[c];
        Scanner sc=new Scanner(System.in);
        String team=sc.nextLine();
        RankBowler c1= new RankBowler();
        c1.Extras_in_2016(extra_run,team);
        c1.Top_bowler(c,rank,array,calc);

    }
}
