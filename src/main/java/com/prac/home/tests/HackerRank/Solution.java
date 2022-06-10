package com.prac.home.tests.HackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'cardPackets' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY cardTypes as parameter.
     */

    public static int cardPackets(List<Integer> cardTypes) {
        System.out.println(cardTypes);
        int[] arr= new int[cardTypes.size()];
        int y=0;
        for (Integer i: cardTypes
             ) {
            if(i%2!=0){
                arr[y]=1;
                y++;
            }
        }
        int sum=0;
        for (Integer i: arr
        ){
            sum=sum+i;
        }
        return sum;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int cardTypesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> cardTypes = IntStream.range(0, cardTypesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cardPackets(cardTypes);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

