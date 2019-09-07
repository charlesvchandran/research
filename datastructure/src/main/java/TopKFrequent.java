import java.util.*;

class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {

        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++)
        {
            if(map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i], 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );

        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }

    public static void main(String... args) {
        String[] words = {"word1", "word2", "word1", "word3", "word2"};
        List<String> wordlist = new TopKFrequent().topKFrequent(words, 2);
        wordlist.forEach(System.out::println);
    }
}