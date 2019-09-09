/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4_lehman_kevin;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;



/**
 *
 * @author user
 */
public class PA4_Lehman_Kevin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        
        //Take user input for name of file to be parsed
        System.out.print("Enter a filename: ");
        Scanner input = new Scanner(System.in);
        String filename = input.nextLine();
        input = new Scanner(new java.io.File(filename));
        //set line counter to 1 for the first line
        int lineCount = 1;
        //create treemap to hold a string and a treeset of integers
        TreeMap<String, TreeSet<Integer>> tm = new TreeMap<>();
        
        //while there is more file to read
        while(input.hasNext()){
            //read the next line
            String item = input.nextLine();
            //split the line into an array of words that are lowercase
            String[] words = item.toLowerCase().split("[^a-zA-Z0-9']+");
                for (String word: words){
                        // trim any leftover punctuation
                        word = word.trim();
                        //check the treemap for the word
                        if(tm.containsKey(word)){
                            //add the linecount to the treeset if the word is already present
                           tm.get(word).add(lineCount);
                        }      
                        else{
                            //if the word is not present create a new treeset, add the
                            //lineCount to it and create a new entry in the treemap
                            TreeSet<Integer> ts = new TreeSet<>();
                            ts.add(lineCount);
                            tm.put(word, ts);
                        }       
                    } 
                lineCount++;
                }
                   
        //print the treemap
        Set set = tm.entrySet();
        Iterator i = set.iterator();
        //couldnt figure out how to not print the completely blank lines
        //moved the iterator past so it would not display
        i.next();
        
        while(i.hasNext()){
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }    
    }   
}
