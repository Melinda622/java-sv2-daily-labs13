package day02;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Quiz {

    private List<String> results = new ArrayList<>();
    private String rightAnswers;
    private Map<String, List<String>> answers = new TreeMap<>();
    private List<String> ids = new ArrayList<>();


    public List<String> read(Path path) {
        try {
            results = Files.readAllLines(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public List<String> extractIDs(Path path) {
        String[] temp;

        rightAnswers = read(path).get(0).trim();

        for (int i = 1; i < read(path).size(); i++) {
            temp = read(path).get(i).split(" ");
            ids.add(temp[0]);
        }
        return ids;
    }

    public Map<String, List<String>> extractAnswers(Path path) {
        String[] temp;
        String key = "";

        List<String> temporary = new ArrayList<>();

        for (int i = 0; i < ids.size(); i++) {
            temporary = new ArrayList<>();
            for (int j = 1; j < results.size(); j++) {
                temp = results.get(j).split(" ");
                if (temp[0].equals(ids.get(i)) && !answers.containsKey(ids.get(i))) {
                    temporary.add(temp[1]);
                }
            }
            if (!answers.containsKey(ids.get(i))) {
                answers.put(ids.get(i), temporary);
            }
        }
        return answers;
    }

    public boolean answeredCorrectly(String id, int questionNumber) {
        for (Map.Entry<String, List<String>> actual : answers.entrySet()) {
            if (actual.getKey().equals(id)) {
                if (actual.getValue().get(questionNumber - 1).charAt(0) == rightAnswers.charAt(questionNumber - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Map<String, Integer> returnPointsAchieved() {
        int totalPoints = 0;
        Map<String, Integer> points = new TreeMap<>();

        for (Map.Entry<String, List<String>> actual : answers.entrySet()) {
            totalPoints = 0;
            for (int i = 1; i < 6; i++) {
                if (answeredCorrectly(actual.getKey(), i)) {
                    totalPoints += i;
                } else if (actual.getValue().get(i - 1).charAt(0) == 'X' && !answeredCorrectly(actual.getKey(), i)) {
                    totalPoints += 0;
                } else {
                    totalPoints -= 2;
                }
            }
            points.put(actual.getKey(), totalPoints);
        }
        return points;
    }

    public String returnBestContestant() {
        String best = "";
        Map<String, Integer> points = new TreeMap<>();
        int max = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> actual : returnPointsAchieved().entrySet()) {
            if (max < actual.getValue()) {
                max = actual.getValue();
                best = actual.getKey();
            }

        }
        return best;
    }


    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        Path path = Paths.get("src/test/resources/result.txt");
        quiz.read(path);
        quiz.extractIDs(path);
        quiz.extractAnswers(path);
        System.out.println(quiz.answers);
        System.out.println(quiz.answers.get("AB123"));
        System.out.println(quiz.returnPointsAchieved());
        System.out.println(quiz.returnBestContestant());
    }
}
