package Graph;


import java.util.*;

public class ReconstructItinerary {

    public static List<String> findItinerary(String[][] tickets) {
        HashMap<String,PriorityQueue<String>> graph = new HashMap<String,PriorityQueue<String>>();
        for (String[] ticket: tickets) {
            if (!graph.containsKey(ticket[0]))
                graph.put(ticket[0],new PriorityQueue<>());
            graph.get(ticket[0]).offer(ticket[1]);
        }
        List<String> route = new ArrayList<String>();
        dfs(route,graph,"JFK");
        return route;
    }

    public static void dfs (List<String> rst,HashMap<String,PriorityQueue<String>> graph, String airport) {
        while(graph.containsKey(airport) && !graph.get(airport).isEmpty())
            dfs(rst,graph,graph.get(airport).poll());
        rst.add(0, airport);
    }

    public static void main(String[] args) {
        String[][] tickets = {{"MUC", "LHR"},{"JFK", "MUC"},{"SFO", "SJC"},{"LHR", "SFO"}};
        String[][] tickets2 = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        System.out.println(findItinerary(tickets));
        System.out.println(findItinerary(tickets2));
    }
}
