import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> contests = new LinkedHashMap<>();
        Map<String, List<String>> studentsContests = new LinkedHashMap<>();
        Map<String, LinkedHashMap<String,Integer>> studentsPoints = new LinkedHashMap<>();
        while (!input.equals("end of contests")){
            String[] data = input.split(":");
            String contest = data[0];
            String pwd = data[1];
            contests.put(contest, pwd);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("end of submissions")){
            String[] data = input.split("=>");
            String contest = data[0];
            String pwd = data[1];
            String user = data[2];
            String points = data[3];
            if(contests.containsKey(contest) && contests.get(contest).equals(pwd)){
                studentsContests.putIfAbsent(user, new ArrayList<>());
                if(!studentsContests.get(user).contains(contest)){
                    studentsContests.get(user).add(contest);
                }
                studentsPoints.putIfAbsent(user, new LinkedHashMap<>());
                studentsPoints.get(user).putIfAbsent(contest, Integer.valueOf(points));
                if(studentsPoints.get(user).containsKey(contest)){
                    if(studentsPoints.get(user).get(contest) < Integer.parseInt(points)){
                        studentsPoints.get(user).put(contest, Integer.valueOf(points));
                    }
                }
            }
            input = scanner.nextLine();
        }
        int bestPoints = 0;
        String bestCandidate = "";
        for(Map.Entry<String, LinkedHashMap<String,Integer>> entry : studentsPoints.entrySet()){
            int currentPoints = 0;
            for (Map.Entry<String,Integer> entry2 : entry.getValue().entrySet()){
                currentPoints += entry2.getValue();
                if(currentPoints > bestPoints){
                    bestPoints = currentPoints;
                    bestCandidate = entry.getKey();
                }
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, bestPoints);
        System.out.println("Ranking:");
        studentsPoints.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).forEach(s -> {
            System.out.println(s.getKey());
            s.getValue().entrySet().stream()
                    .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(a -> System.out.println("#  " + a.getKey() + " -> " + a.getValue()));
        });
    }
}
