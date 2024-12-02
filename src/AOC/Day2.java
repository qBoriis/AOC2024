package AOC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 extends AOCHandler {
    public Day2() {
        super("2");
    }

    @Override
    void solve(List<String> input) {
        part1(input);
        part2(input);
    }

    public void part1(List<String> input) {
        int sumSafe = 0;

        for (String s : input) {
            String[] temp = s.split(" ");

            ArrayList<Integer> lst = new ArrayList<>(Arrays.stream(temp)
                    .map(Integer::parseInt)
                    .toList());

            boolean safe = true;

            for (int j = 0; j < lst.size() - 1; j++) {
                int diff = Math.abs(lst.get(j) - lst.get(j + 1));
                if (!(lst.get(j) > lst.get(j + 1) && diff >= 1 && diff <= 3)) {
                    safe = false;
                    break;
                }
            }

            if (safe) {
                sumSafe++;
            }

            safe = true;

            for (int j = 0; j < lst.size() - 1; j++) {
                int diff = Math.abs(lst.get(j) - lst.get(j + 1));
                if (!(lst.get(j) < lst.get(j + 1) && diff >= 1 && diff <= 3)) {
                    safe = false;
                    break;
                }
            }

            if (safe) {
                sumSafe++;
            }
        }
        System.out.println("Part 1: " +sumSafe);
    }

    public void part2(List<String> input) {
        int sumSafe = 0;

        for (String s : input) {
            String[] temp = s.split(" ");

            for (int i = 0; i < temp.length; i++) {
                ArrayList<Integer> lst = new ArrayList<>(Arrays.stream(temp)
                        .map(Integer::parseInt)
                        .toList());

                boolean safe = true;

                lst.remove(i);

                for (int j = 0; j < lst.size() - 1; j++) {
                    int diff = Math.abs(lst.get(j) - lst.get(j + 1));
                    if (!(lst.get(j) > lst.get(j + 1) && diff >= 1 && diff <= 3)) {
                        safe = false;
                        break;
                    }
                }

                if (safe) {
                    sumSafe++;
                    break;
                }
            }

            for (int i = 0; i < temp.length; i++) {
                ArrayList<Integer> lst = new ArrayList<>(Arrays.stream(temp)
                        .map(Integer::parseInt)
                        .toList());

                boolean safe = true;

                lst.remove(i);

                for (int j = 0; j < lst.size() - 1; j++) {
                    int diff = Math.abs(lst.get(j) - lst.get(j + 1));
                    if (!(lst.get(j) < lst.get(j + 1) && diff >= 1 && diff <= 3)) {
                        safe = false;
                        break;
                    }
                }

                if (safe) {
                    sumSafe++;
                    break;
                }
            }
        }
        System.out.println("Part 2: " +sumSafe);
    }
}
