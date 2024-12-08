package Business;

import Persistence.TeamDAO;

import java.io.FileNotFoundException;
import java.util.List;

public class TeamManager {
    private TeamDAO teamDAO;

    public TeamManager(TeamDAO dao) {
        this.teamDAO = dao;
    }

    public boolean teamsExists() {
        return teamDAO.teamsExists();
    }

    public void createTeam(String teamname, TeamMember[] teamMembers) throws FileNotFoundException {
        try {
            Team newTeam = new Team(teamname, teamMembers);
            // System.out.println("Team object created: " + newTeam.getName() + "Sending to dao");
            teamDAO.addTeamToFile(newTeam);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Team> getAllTeams() throws FileNotFoundException {
        return teamDAO.getAll();
    }

    public Team getTeamByListId(int id) throws FileNotFoundException {
        return getAllTeams().get(id - 1);
    }

    //public Team getTeam() {
    //    return teamDAO.getTeam();
    //}

    public boolean checkNameUnique(String name) throws FileNotFoundException {
        return teamDAO.checkNameUnique(name);
    }

    public boolean deleteTeam(Team team) {
        return teamDAO.deleteTeam(team);
    }
}
