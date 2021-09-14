package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Hash_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> maxPlayGenre = new HashMap<>();
        for(int i = 0; i< genres.length; i++) {
            maxPlayGenre.put(genres[i], maxPlayGenre.getOrDefault(genres[i], 0)+ plays[i]);

        }

        // 장르, 총 곡수
        List<String> keySetList = new ArrayList<>(maxPlayGenre.keySet());
        Collections.sort(keySetList, (o1, o2) -> (
            maxPlayGenre.get(o2).compareTo(maxPlayGenre.get(o1))));

        for (String key : keySetList) {
            //System.out.println("max genre: " + key+ " max count:" +  maxPlayGenre.get(key));

            // 장르별 곡수를 정렬한 index
            // <index, plays>
            HashMap<Integer, Integer> genresPlays = new HashMap<>();
            for(int i = 0; i< genres.length; i++) {
                if (key.equals(genres[i])) {
                    genresPlays.put(i, plays[i]);
                }
            }

            List<Integer> keySetList2 = new ArrayList<>(genresPlays.keySet());
            Collections.sort(keySetList2, (o1, o2) -> (genresPlays.get(o2).compareTo(genresPlays.get(o1))));
            if (keySetList2.size() > 2) {
                keySetList2 = keySetList2.subList(0, 2);
            }

            for(Integer index : keySetList2) {
                //System.out.println("index: " + index+ " count :" +  genresPlays.get(index));
                answer.add(index);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
