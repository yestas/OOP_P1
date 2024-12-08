package Business;

import Persistence.TeamDAO;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * TeamManager class
 */
public class TeamManager {
    private TeamDAO teamDAO;

    /**
     * Constructor
     * @param dao: Team dao
     */
    public TeamManager(TeamDAO dao) {
        this.teamDAO = dao;
    }

    /**
     * Checks if file exists
     * @param team_name: The name of the team.
     * @param teamMembers: The members of the team.
     * @throws FileNotFoundException
     */
    public void createTeam(String team_name, TeamMember[] teamMembers) throws FileNotFoundException {
        try {
            Team newTeam = new Team(team_name, teamMembers);
            // System.out.println("Team object created: " + newTeam.getName() + "Sending to dao");
            teamDAO.addTeamToFile(newTeam);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get all teams using teamDAO
     * @return List<Team>
     * @throws FileNotFoundException
     */
    public List<Team> getAllTeams() throws FileNotFoundException {
        return teamDAO.getAll();
    }

    /**
     * Get all team by using id
     * @param id: The id of the team.
     * @return List<String>
     * @throws FileNotFoundException
     */
    public Team getTeamByListId(int id) throws FileNotFoundException {
        return getAllTeams().get(id - 1);
    }

    /**
     * Checks if the name of the team already exists
     * @param name: The name of the team.
     * @return List<String>
     * @throws FileNotFoundException
     */
    public boolean checkNameUnique(String name) throws FileNotFoundException {
        return teamDAO.checkNameUnique(name);
    }

    // TODO: Implement deleteTeam
    //public boolean deleteTeam(Team team) {
    //    return teamDAO.deleteTeam(team);
    //}
}
