package Business;
import Persistence.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StatisticManager {
    private StatisticDAO statisticDAO;

    public StatisticManager(StatisticDAO dao) {
        this.statisticDAO = dao;
    }

    public void checkFileExists() throws PersonalizedException {
        statisticDAO.checkFile();
    }

    public List<Statistic> getAllStatistics() throws FileNotFoundException {
        return statisticDAO.getAll();
    }

    public List<String> getAllStatisticNames() throws FileNotFoundException {
        List<String> names = new ArrayList<>();
        List<Statistic> statistics = getAllStatistics();

        for (Statistic stat : statistics) {
            names.add(stat.getName());
        }

        return names;
    }

    public int getAllStatisticsLength() throws FileNotFoundException {
        List<Statistic> statistics = statisticDAO.getAll();
        return statistics.size();
    }

    public Statistic getStatistics(String team) throws FileNotFoundException, PersonalizedException {
        return statisticDAO.getByTeamName(team);
    }

    public void saveStatistic(Statistic statistic) {
        statisticDAO.save(statistic);
    }
}
