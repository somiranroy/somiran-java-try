package com.somiran.lall.everlaw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class MainFile {


    List<Score> scores = Lists.newArrayList();
    Map<String, List<Score>> winnerList = Maps.newHashMap();


    void prepareWinnerList () {
        scores.stream().forEach(each -> {
            List<Score> temp_scores = null;
            if(winnerList.containsKey(each.winner)) {
                temp_scores = winnerList.get(each.winner);                
            } else {
                temp_scores = Lists.newArrayList();
            }
            temp_scores.add(each);
            winnerList.put(each.winner, temp_scores);
        });
    }

    double getAverageWinningScore(String winner) throws Exception {

        List<Score> scores = winnerList.get(winner);

        if(null != scores) {

            return scores.stream().parallel().map(each -> each.diff).mapToInt(i-> i).average().getAsDouble();
            // int diffScrores = 0;
            // for(int i=0; i < scores.size(); i++) {
            //     diffScrores += scores.get(i).winnerScore - scores.get(i).looserScore;
            // }

            //return diffScrores/scores.size();
        } else {
            throw new Exception("Winner Not Found");
        }

    }
    

    void load(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/somiran/lall/everlaw/sports.txt"));
            String line = null;
            while((line = reader.readLine()) != null) {

                String[] tokens = line.split(" ");
                Score score = new Score(tokens[0], Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3]));
                scores.add(score);
            }
            reader.close();

        } catch(FileNotFoundException fnf) {
            System.err.println("Unable to Locate File. Error Message : " + fnf.getMessage());
        } catch (IOException io) {
            System.err.println("Something wrong happend reading the File. Error Message: " + io.getMessage());
        } catch (Exception e) {
            System.err.println("Something wrong happend parsing the File. Error message: " + e.getMessage() );
        }

        System.out.println("Loading Completed with size: " + scores.size());
    }


    // public static void main(String[] args) {
    //     MainFile mainfile = new MainFile();
    //     mainfile.load();
    //     mainfile.prepareWinnerList();
    //     try {
    //         System.out.println(mainfile.getAverageWinningScore("e"));
    //     } catch (Exception e) {
    //         System.err.println("Winner Not found");
    //     }
    // }

    public static void main(String[] args) {

        // List<String> list = Arrays.asList("Java", "Stream", null, "Filter", null);

        // List<String> null_list = null;
        // List<String> empty_list = Lists.newArrayList();
        
        // List<String> result =  Optional.ofNullable(empty_list)
        //         .orElseGet(Collections::emptyList)
        //         .stream()
        //         .parallel()
        //         .filter(Objects::nonNull)
        //         .collect(Collectors.toList());
        
        // result.forEach(System.out::println); 
        // System.out.println(result.size());  
        
        MainFile main = new MainFile();
        main.printPriramind(3);
        // List<String> result = list.stream()
        //         .filter(str -> str!=null)
        //         .collect(Collectors.toList());
        // result.forEach(System.out::println);      
    
       }


       void printPriramind(int n) {

        int max_star = 2*n-1;

        for (int i=1; i <= n; i++) {
            for (int j=0; j< (max_star-2*i-1)/2; j++) {
                System.out.print(" ");
            }
            for (int j=0; j< 2*i-1; j++) {
                System.out.print("*");
            }
            for (int j=0; j< (max_star-2*i-1)/2; j++) {
                System.out.print(" ");
            }
            System.out.println("");
        }
       }
    
}
