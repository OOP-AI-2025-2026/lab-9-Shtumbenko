package ua.opnu;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = (list.size() / 2) * 2 - 2; i >= 0; i -= 2) {
            String s1 = list.get(i);
            String s2 = list.get(i + 1);

            if (s1.length() <= s2.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            list.add(i, list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        if (size == 0) {
            return true;
        }

        boolean isPalindrome = true;

        for (int i = 0; i < size; i++) {
            int val = queue.poll();
            stack.push(val);
            queue.add(val);
        }

        for (int i = 0; i < size; i++) {
            int fromQueue = queue.poll();
            int fromStack = stack.pop();

            if (fromQueue != fromStack) {
                isPalindrome = false;
            }
            queue.add(fromQueue);
        }

        return isPalindrome;
    }

    public void reorder(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        int positives = 0;

        for (int i = 0; i < size; i++) {
            int val = queue.poll();
            if (val < 0) {
                stack.push(val);
            } else {
                queue.add(val);
                positives++;
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < positives; i++) {
            queue.add(queue.poll());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        Queue<Integer> oddQueue = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int val = queue.poll();
            if (val % 2 == 0) {
                queue.add(val);
            } else {
                oddQueue.add(val);
            }
        }

        queue.addAll(oddQueue);
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);

        set1.retainAll(set2);

        return set1.size();
    }

    public boolean isUnique(Map<String, String> map) {
        if (map.isEmpty()) {
            return true;
        }
        Collection<String> values = map.values();
        Set<String> uniqueValues = new HashSet<>(values);

        return values.size() == uniqueValues.size();
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value1 = entry.getValue();

            if (map2.containsKey(key) && map2.get(key).equals(value1)) {
                result.put(key, value1);
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {

            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer value : map.values()) {
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }

        int minCount = Integer.MAX_VALUE;
        int rarestValue = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            if (count < minCount) {
                minCount = count;
                rarestValue = value;
            } else if (count == minCount) {
                rarestValue = Math.min(rarestValue, value);
            }
        }
        return rarestValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer num : list) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        for (Integer count : counts.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

}
