package solutions.task_399;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 399. Evaluate Division
 * You are given an array of variable pairs equations and an array of real numbers values, where
 * equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi
 * is a string that represents a single variable.
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must
 * find the answer for Cj / Dj = ?.
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * Note: The input is always valid. You may assume that evaluating the queries will not result in
 * division by zero and that there is no contradiction.
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot
 * be determined for them.
 */
class Solution {
    static class Pair {
        String key;
        double value;

        public Pair(String key, double value) {
            this.key = key;
            this.value = value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, HashSet<Pair>> stringMapHashMap = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double value = values[i];

            HashSet<Pair> orDefault1 = stringMapHashMap.getOrDefault(from, new HashSet<>());
            orDefault1.add(new Pair(to, value));
            stringMapHashMap.put(from, orDefault1);

            HashSet<Pair> orDefault2 = stringMapHashMap.getOrDefault(to, new HashSet<>());
            orDefault2.add(new Pair(from, 1 / value));
            stringMapHashMap.put(to, orDefault2);
        }

        double[] answers = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);

            if (!stringMapHashMap.containsKey(from) && !stringMapHashMap.containsKey(to)) {
                answers[i] = -1;
            } else {
                double[] answ = {-1};

                HashSet<String> visited = new HashSet<>();

                deep(stringMapHashMap, answ, visited, from, to, 1.0);
                answers[i] = answ[0];
            }
        }
        return answers;
    }

    public void deep(Map<String, HashSet<Pair>> stringMapHashMap, double[] answ, HashSet<String> visited, String from, String to, double tempValue) {
        if (visited.contains(from)) return;

        visited.add(from);

        if (from.equals(to)) {
            answ[0] = tempValue;
            return;
        }

        HashSet<Pair> pairs = stringMapHashMap.get(from);

        pairs
            .forEach(pair -> {
                deep(stringMapHashMap, answ, visited, pair.key, to, tempValue * pair.value);
            });
    }
}