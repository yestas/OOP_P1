package Business;
import java.util.List;

public class Team {
    private int id;
    private String name;
    private List<TeamMember> members;

    public Team(int id, String name, List<TeamMember> members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }
}
