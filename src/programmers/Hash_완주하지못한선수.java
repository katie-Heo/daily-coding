package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Hash_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            String nameKey = participant[i];
            List<String> nameValues = map.get(nameKey);
            if (nameValues == null) {
                nameValues = new ArrayList<>();
             }

            nameValues.add(nameKey);
            map.put(participant[i], nameValues);
        }


        for (int i = 0; i < completion.length; i++) {
            String nameKey = completion[i];
            List<String> nameValues = map.get(nameKey);

            nameValues.remove(0);
            if (nameValues.isEmpty()) {
                map.remove(nameKey);
            }
        }
        Iterator<String> key = map.keySet().iterator();
        return key.next();
    }

    /**
     * 갯수만 가지고 있음
     * @param participant
     * @param completion
     * @return
     */
    public String solution2(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hm = new HashMap<>();

        for (String player : participant) {
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        }
        for (String player : completion) {
            hm.put(player, hm.get(player) - 1);
        }

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }

        return answer;
    }

    public String solution3(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for ( i=0; i<completion.length; i++){

            if (!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];
    }
}
