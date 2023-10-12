package com.petru.consumer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    // abcdba
    // aabbddcccb  abdcccccdba
    public static  int palindrom(String input){
        char[] chars = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int dimensiune = 0;
        for(int i = 0; i<chars.length; i++){
            if(map.containsKey(chars[i])){
               int value =  map.get(chars[i]);
               value++;
               map.put(chars[i], value);
            }else{
                map.put(chars[i], 1);
            }
        }

        for(Map.Entry<Character, Integer>ent:map.entrySet()){
            if(ent.getValue()>1){
                dimensiune+=ent.getValue();
            }
        }
            return dimensiune;
    }



    public static void main(String[] args) {

    }
}

/*

You are given two string arrays positiveFeedback and negativeFeedback, containing the words denoting positive and negative feedback, respectively. Note that no word is both positive and negative.


You are given a studentId array that contains the ids of the students, and a report array that contains the feedback for a specific student (studentId[i] represents the ID of the student who has received the feedback report report[i]). The ID of each student is unique.

Initially every student has 0 points. Each positive word in a feedback report increases the points of a student by 3, whereas each negative word decreases the points by 1.

Given an integer k, return the top k students after ranking them in descending order by their points. In case more than one student has the same points, the one with the lower ID ranks higher.


Example 1:

Input: positiveFeedback = ["smart","brilliant","studious"], negativeFeedback = ["not"], report = ["this student is studious","the student is smart"], studentId = [1,2], k = 2
Output: [1,2]
Explanation:
Both the students have 1 positive feedback and 3 points but since student 1 has a lower ID he ranks higher.
Example 2:

Input: positiveFeedback = ["smart","brilliant","studious"], negativeFeedback = ["not"], report = ["this student is not studious","the student is smart"], studentId = [1,2], k = 2
Output: [2,1]
Explanation:
- The student with ID 1 has 1 positive feedback and 1 negative feedback, so he has 3-1=2 points.
- The student with ID 2 has 1 positive feedback, so he has 3 points.
Since student 2 has more points, [2,1] is returned.

Constraints:

- 1 <= positiveFeedback.length, negativeFeedback.length <= 10^4
- 1 <= positiveFeedback[i].length, negativeFeedback[j].length <= 100
- Both positiveFeedback[i] and negativeFeedback[j] consists of lowercase English letters.
- No word is present in both positiveFeedback and negativeFeedback.
- n == report.length == studentId.length
- 1 <= n <= 10^4
- report[i] consists of lowercase English letters and spaces ' '.
- There is a single space between consecutive words of report[i].
- 1 <= report[i].length <= 100
- 1 <= studentId[i] <= 10^9
- All the values of studentId[i] are unique.
1 <= k <= n

*/




class Solution {
    public List<Integer> topStudents(String[] positiveFeedback, String[] negativeFeedback, String[] report, int[] studentId, int k) {
        int[] grades = new int[studentId.length];
        Map<Integer, Integer> gradeStud = new HashMap<>();

        for(int i =0; i<report.length; i++){
            grades[i] = 0;
            for(int j = 0; j < positiveFeedback.length; j++){
                if(report[i].contains(positiveFeedback[j]))
                    grades[i]+=3;
            }

            for(int m = 0; m < negativeFeedback.length; m++){
                if(report[i].contains(negativeFeedback[m]))
                    grades[i]-=1;
            }

        }

        for(int i = 0; i< studentId.length; i++){
            gradeStud.put(studentId[i], grades[i]);
        }

        SortedSet<Integer> keys = new TreeSet<>(gradeStud.keySet());
        for (int i = 0; i<keys.size() && i<=k; i++) {
            if()

            Integer value = gradeStud.get(i);

        }
    }
}
