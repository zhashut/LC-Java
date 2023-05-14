package backtracking_回溯.重新安排行程;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/14
 * Time: 15:38
 * Description: https://leetcode.cn/problems/reconstruct-itinerary/
 */
public class main {

    /******************************解题一**************************************/
    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    List<String> itinerary = new LinkedList<String>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    public void dfs(String curr) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        itinerary.add(curr);
    }

    /******************************解题二**************************************/
    private Deque<String> res;
    private Map<String, Map<String, Integer>> m;

    public List<String> findItinerary2(List<List<String>> tickets) {
        m = new HashMap<>();
        res = new LinkedList<>();
        for (List<String> t : tickets) {
            Map<String, Integer> temp;
            if (m.containsKey(t.get(0))) {
                temp = m.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            } else {
                temp = new TreeMap<>(); // 升序Map
                temp.put(t.get(1), 1);
            }
            m.put(t.get(0), temp);

        }
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }

    private boolean backTracking(int ticketNum) {
        if (res.size() == ticketNum + 1) {
            return true;
        }
        String last = res.getLast();
        if (m.containsKey(last)) { // 防止出现null
            for (Map.Entry<String, Integer> target : m.get(last).entrySet()) {
                int count = target.getValue();
                if (count > 0) {
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if (backTracking(ticketNum)) return true;
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }

}
