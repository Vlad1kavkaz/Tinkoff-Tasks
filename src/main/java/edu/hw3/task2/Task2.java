package edu.hw3.task2;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Task2 {

    private Task2() {
    }

    public static ArrayList<String> clusterize(String bracketSequence) {
        ArrayList<String> result = new ArrayList<>();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder currentCluster = new StringBuilder();

        for (char bracket : bracketSequence.toCharArray()) {
            switch (bracket) {
                case '(':
                    handleOpeningBracket(stack, currentCluster, result, bracket);
                    break;
                case ')':
                    handleClosingBracket(stack, currentCluster, result, bracket);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid bracket sequence");
            }
        }

        if (!stack.isEmpty()) {
            throw new IllegalArgumentException("Unmatched opening brackets");
        }

        return result;
    }

    private static void handleOpeningBracket(ArrayDeque<Character> stack,
        StringBuilder currentCluster,
        ArrayList<String> result,
        char bracket) {
        stack.addLast(bracket);
        currentCluster.append(bracket);
    }

    private static void handleClosingBracket(ArrayDeque<Character> stack,
        StringBuilder currentCluster,
        ArrayList<String> result,
        char bracket) {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Incorrect bracket sequence: no paired opening bracket");
        }
        Character lastBracket = stack.pollLast();

        if (lastBracket.equals('(')) {
            currentCluster.append(bracket);
        } else {
            throw new IllegalArgumentException("Incorrect bracket sequence: invalid opening bracket");
        }

        // If we completed the current cluster, then add it to the result and clear the string builder for the cluster
        if (stack.isEmpty()) {
            result.add(currentCluster.toString());
            currentCluster.setLength(0); // Clear the StringBuilder
        }
    }
}
