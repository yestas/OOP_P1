package Business;
import Persistence.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * StatisticManager class
 */
public class StatisticManager {
    private StatisticDAO statisticDAO;

    public StatisticManager(StatisticDAO dao) {
        this.statisticDAO = dao;
    }

    /**
     * Checks if file exists
     * @throws PersonalizedException
     */
    public void checkFileExists() throws PersonalizedException {
        statisticDAO.checkFile();
    }

    /**
     * Get all statistics using statisticDAO
     * @return List<Statistic>
     * @throws FileNotFoundException
     */
    public List<Statistic> getAllStatistics() throws FileNotFoundException {
        return statisticDAO.getAll();
    }

    /**
     * Get all statistic names using statisticDAO
     * @return List<String>
     * @throws FileNotFoundException
     */
    public List<String> getAllStatisticNames() throws FileNotFoundException {
        List<String> names = new ArrayList<>();
        List<Statistic> statistics = getAllStatistics();

        for (Statistic stat : statistics) {
            names.add(stat.getName());
        }

        return names;
    }

    /**
     * Get all statistic lengths using statisticDAO
     * @return int
     * @throws FileNotFoundException
     */
    public int getAllStatisticsLength() throws FileNotFoundException {
        List<Statistic> statistics = statisticDAO.getAll();
        return statistics.size();
    }

    /**
     * Get statistic by team name
     * @param teamName: Team name
     * @return Statistic
     * @throws FileNotFoundException
     * @throws PersonalizedException
     */
    public Statistic getStatistics(String teamName) throws FileNotFoundException, PersonalizedException {
        return statisticDAO.getByTeamName(teamName);
    }

    /**
     * Save statistic
     * @param statistic: Statistic
     */
    public void saveStatistic(Statistic statistic) {
        statisticDAO.save(statistic);
    }
}
