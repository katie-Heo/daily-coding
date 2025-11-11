package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _0347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // 빈도수는 HashMap에 담고
        // 빈도수 기준으로 정렬을 해야하는데
        // 우선순위 큐를 사용하면 될듯?
        // 우선순위 큐가 java에서 어떤 클래스가 있지?
        // PriorityQueue

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 빈도수를 기준으로 우선순위 큐에 담기
        // k갯수만큼만 담기

        // 뒤로 갈수록 큰값 (minHeap) 빈도수가 큰 값 num = key 값이 들어가야한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return frequencyMap.get(o1) - frequencyMap.get(o2);
            }
        });

        for (Integer key : frequencyMap.keySet()) {
            Integer value = frequencyMap.get(key);
            pq.add(key);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for (int i=0 ; i<k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}
