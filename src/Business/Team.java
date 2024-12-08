package Business;

public class Team {
    private String name;
    private TeamMember[] members;

    /**
     * Constructor for the Team class.
     * @param name The name of the team.
     * @param members The members of the team.
     */
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
