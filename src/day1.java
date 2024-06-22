import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day1
    {
        /**
         * Advent of Code 2023, day 1: find the first and last integer in a given string
         * add the two integers together to determine the calibration values needed
         * add all the calibration values together to determine the final sum
         * @param args
         */
        public static void main(String[] args)
            {
                
                // Read input from file stored on local disk
                String source = "C:\\scripts\\aoc2023\\day1.txt";
                
                //initial list of data
                List<String> lines = list(source);
                
                List<Integer> tempStored =  new java.util.ArrayList<>(Collections.emptyList());
                
                List<Integer> initialResults = new java.util.ArrayList<>(Collections.emptyList());
                
                for (String stored : lines)
                    {
                        tempStored.clear();
                        
                        for (int i = 0; i<stored.length(); i++)
                            {
                                char[] tempChars = stored.toCharArray();
                                char s = tempChars[i];
                                
                                if (Character.isDigit(s))
                                    {
                                        tempStored.add(Integer.parseInt(String.valueOf(s)));
                                    }
                                
                            }
                        Integer firstValue = tempStored.getFirst();
                        Integer lastValue = tempStored.getLast();
                        
                        String tempResult = firstValue.toString() + lastValue.toString();
                        
                        initialResults.add(Integer.valueOf(tempResult));

                        continue;
                    }

                int finalSum = initialResults.stream().mapToInt(i -> i).sum();
                
                System.out.println(finalSum);
            }
        public static List<String> list(String fileName)
            {
                
                // add lines from file into collection
                List<String> listed = Collections.emptyList();
                try
                    {
                        listed = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
                    }
                catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                return listed;
                
            }
    }
