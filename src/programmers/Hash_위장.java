package programmers;

import java.util.HashMap;

public class Hash_위장 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i< clothes.length; i++) {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0)+1);
        }

        int sum = 0;
        int comp = map.size() > 1 ? 1 : 0;
        for (String key : map.keySet()) {
            int listCount = map.get(key);
            sum += listCount;
            comp = comp * listCount;
        }

        return sum + comp;
    }

    public int solution2(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i =0; i<clothes.length; i++){
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1],0)+1);
        }
        for(String key : hm.keySet()) {
            answer *=(hm.get(key)+1);
        }
        answer -=1;
        return answer;
    }


}
