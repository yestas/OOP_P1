package Business;

import Persistence.TeamDAO;

public class TeamManager {
    private TeamDAO teamDAO;

    public TeamManager(TeamDAO dao) {
        this.teamDAO = dao;
    }

    public boolean teamsExists() {
        return teamDAO.teamsExists();
    }

    public boolean createTeam(Team team) {
        return teamDAO.createTeam(team);
    }

    //public Team getTeam() {
    //    return teamDAO.getTeam();
    //}

    public boolean checkNameUnique(String name) {
        return teamDAO.checkNameUnique(name);
    }

    public boolean deleteTeam(Team team) {
        return teamDAO.deleteTeam(team);
    }
}
