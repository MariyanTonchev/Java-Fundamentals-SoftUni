import java.util.*;
import java.util.stream.Collectors;

public class TeamworkProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Team> teams = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] data = input.split("-");
            String member = data[0];
            String teamName = data[1];
            List<String> members = new ArrayList<>();
            Team team = new Team(member, teamName, members);
            if (teams.stream().anyMatch(t -> t.teamName.equals(teamName))) {
                System.out.printf("Team %s was already created!%n", teamName);
            } else if (teams.stream().anyMatch(t -> t.creatorName.equals(member))) {
                System.out.printf("%s cannot create another team!%n", member);
            } else {
                System.out.printf("Team %s has been created by %s!%n", teamName, member);
                teams.add(team);
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("end of assignment")) {
            String[] data = input.split("->");
            String member = data[0];
            String teamName = data[1];
            if (teams.stream().noneMatch(t -> t.teamName.equals(teamName))) {
                System.out.printf("Team %s does not exist!%n", teamName);
                ;
            } else if (teams.stream().anyMatch(m -> m.creatorName.equals(member)) || teams.stream().anyMatch(m -> m.members.contains(member))) {
                System.out.printf("Member %s cannot join team %s!%n", member, teamName);
            } else {
                Team existing;
                for (Team team : teams) {
                    if (team.teamName.equals(teamName)) {
                        existing = team;
                        existing.members.add(member);
                    }
                }
            }
            input = scanner.nextLine();
        }
        List<Team> teamsToDisband = teams.stream().filter(team -> team.members.size() == 0).sorted(Comparator.comparing(team -> team.teamName)).collect(Collectors.toList());
        List<Team> fullTeams = teams.stream().filter(team -> team.members.size() > 0).sorted(Comparator.comparingInt(Team::count).reversed().thenComparing(t -> t.teamName)).collect(Collectors.toList());
        for (Team team : fullTeams) {
            System.out.printf("%s%n", team.teamName);
            System.out.printf("- %s%n", team.creatorName);
            List<String> members = team.members;
            Collections.sort(members);
            for (String member : members) {
                System.out.printf("-- %s%n", member);
            }
        }
        System.out.println("Teams to disband:");
        for (Team team : teamsToDisband) {
            System.out.println(team.teamName);
        }
    }

    private static class Team {
        String creatorName;
        String teamName;
        List<String> members;

        public int count() {
            return members.size();
        }

        public Team(String creatorName, String teamName, List<String> members) {
            this.creatorName = creatorName;
            this.teamName = teamName;
            this.members = members;
        }
    }
}
