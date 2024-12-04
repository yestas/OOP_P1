package Persistence;
import Business.Team;

import java.util.List;

public class TeamDAO extends BaseDAO<Team> {
    public boolean createFile() {
        return false;
    }

    public void addTeam(Team data) {
    }

    public List<Team> getTeamsByCharacter(Character data) {
        return null;
    }

    public void save(Team data) {
    }

    public Team getById(int id) {
        return null;
    }

    public List<Team> getAll() {
        return null;
    }

    public boolean deleteTeam(Team team) {
        return false;
    }

    public boolean checkNameUnique(String name) {
        return false; 
    }

    public Team getTeam() {
        return Team;
    }

    public boolean createTeam(Team team) {
    }
}
