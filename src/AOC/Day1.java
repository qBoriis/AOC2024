package AOC;

import java.util.*;

public class Day1 extends AOCHandler{
    public Day1() {
        super("1");
    }

    @Override
    void solve(List<String> input) {
        part1(input);
        part2(input);
    }

    public void part1(List<String> input){
        int op = 0;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (String s : input) {
            String[] split = s.split("   ");
            left.add(Integer.valueOf(split[0]));
            right.add(Integer.valueOf(split[1]));
        }

        Collections.sort(left);
        Collections.sort(right);

        for (int i = 0; i < left.size(); i++) {
            op += Math.abs(left.get(i)-right.get(i));
        }

        System.out.println("Part 1: " + op);
    }

    private void part2(List<String> input) {
        int op = 0;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (String s : input) {
            String[] split = s.split("   ");
            left.add(Integer.valueOf(split[0]));
            right.add(Integer.valueOf(split[1]));
        }

        for (Integer i : right) {
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }

        for (Integer i : left) {
            if (map.containsKey(i)) {
                op += map.get(i) * i;
            }
        }
        System.out.println("Part 2: " + op);
    }
}
