import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProcessing {
    //filters adventurers by skill, a method that takes a skill as input and returns a
    //flat list of all adventurers across guilds who possess that skill
    public List<Adventurer> filterSkills(List<Guild> guilds, Skill skill){
        return guilds.stream()
                .flatMap(g -> g.getAdventurers().stream())
                .filter(a -> a.getSkills().contains(skill))
                .collect(Collectors.toList());
    }

    //groups adventurers by their roles
    public void adventurersRole(List<Guild> guilds){
        guilds.stream()
                .flatMap(g -> g.getAdventurers().stream())
                .sorted(Comparator.comparing(Adventurer::getRole))
                .forEach(a -> System.out.println(a + a.getRole()));
    }

    //finds adventurers with the most skills
    public void mostSkills(List<Guild> guilds){
        Optional<Adventurer> skilled = guilds.stream()
                .flatMap(c -> c.getAdventurers().stream())
                .max(Comparator.comparingInt(b -> b.getSkills().size()));

        skilled.ifPresent(a -> System.out.println(a.getName() + ": " + a.getSkills()));
    }

    //ranks guilds by average adventurer age, ranks guilds in ascending order
    public void guildAdventurerAge(List<Guild> guilds){
        guilds.stream()
                .sorted((g1, g2) -> {
                    double avg1 = g1.getAdventurers().stream()
                            .mapToInt(Adventurer::getAge)
                            .average()
                            .orElse(0);

                    double avg2 = g2.getAdventurers().stream()
                            .mapToInt(Adventurer::getAge)
                                    .average()
                                    .orElse(0);

                    return Double.compare(avg1, avg2);
                })
                .forEach(g ->{
                    double avg = g.getAdventurers().stream()
                            .mapToInt(Adventurer::getAge)
                            .average()
                            .orElse(0);

                    System.out.println(g.getName() + "'s average age is " + avg);
                });

    }

    //prints a map where the keys are the names of the skills
    //and the values are the number of adventurers proficient in that skill
    public void skillWiseAdventurerMap(List<Guild> guilds){
        Map<Skill, Long> skillCount = guilds.stream()
                .flatMap(g -> g.getAdventurers().stream())
                .flatMap(a -> a.getSkills().stream())
                .collect(Collectors.groupingBy(skill -> skill,
                        Collectors.counting()));

        skillCount.forEach((skill, count) ->
                System.out.println(skill + ": " + count));

    }

    //method that grants 20 percent bonus gold to all adventurers who have earned less than 1000
    //gold and prints updated adventurer list
    public void bonusGoldEvent(List<Guild> guilds){
        Map<String, Double> goldByGuild = guilds.stream()
                .collect(Collectors.toMap(
                        Guild::getName,
                        g -> g.getAdventurers().stream()
                                .mapToDouble(Adventurer::getGoldEarned)
                                .sum()
                ));
    }
}
