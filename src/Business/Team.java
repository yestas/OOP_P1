package Business;
import java.util.List;

public class Team {
    private String name;
    private TeamMember[] members;

    public Team(String name, TeamMember[] members) {
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamMember[] getMembers() {
        return members;
    }

    public void setMembers(TeamMember[] members) {
        this.members = members;
    }
}
