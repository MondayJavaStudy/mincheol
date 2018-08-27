package com.monday.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mcpark on 8/20/18
 */
public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> cards = readLineForCards(new InputStreamReader(System.in));
        int expectNumber = readLineForNumber(new InputStreamReader(System.in));
        print(sort(collect(cards, expectNumber)));
    }

    private static List<Integer> readLineForCards(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        return Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private static int readLineForNumber(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        return Integer.parseInt(br.readLine());
    }

    public static Set<List<Integer>> collect(List<Integer> cards, int expectNumber) {
        Set<List<Integer>> combinationSet = new HashSet<>();

        List<Integer> sortedCards = cards.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < sortedCards.size(); i++) {
            for (int j = i + 1; j < sortedCards.size(); j++) {
                for (int k = j + 1; k < sortedCards.size(); k++) {
                    if (sortedCards.get(i) + sortedCards.get(j) + sortedCards.get(k) == expectNumber) {
                        List<Integer> combination = Arrays.asList(sortedCards.get(i), sortedCards.get(j), sortedCards.get(k));
                        combinationSet.add(combination);
                    }
                }
            }
        }

        return combinationSet;
    }

    public static List<List<Integer>> sort(Set<List<Integer>> combinationSet) {
        return new ArrayList<>(combinationSet).stream()
                .sorted((o1, o2) -> o1.get(0) < o2.get(0) ? -1 : o1.get(1) < o2.get(1) ? -1 : o1.get(2) < o2.get(2) ? -1 : 0)
                .collect(Collectors.toList());
    }

    private static void print(List<List<Integer>> combinations) {
        combinations.forEach(v -> {
            String answer = String.join(" ", v.stream().map(String::valueOf).collect(Collectors.toList()));
            System.out.println(answer);
        });

        if (combinations.size() < 1) {
            System.out.println("NO");
        }
    }
}
