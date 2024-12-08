package Persistence;
import Business.Statistic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StatisticDAO extends BaseDAO<Statistic> {
    public boolean createFile() {
        return false;
    }

    public void addStatistic(Statistic data) {
    }

    public void save(Statistic data) {
    }

    public Statistic getById(int id) {
        return null;
    }

    public Statistic getByTeamName(String name) {
        return null;
    }

    public List<Statistic> getAll() {
        return null;
    }

    @Override
    public void writeFile(String json) {
    }
}
