package Business;
import Persistence.*;

public class StatisticManager {
    private StatisticDAO statisticDAO;

    public StatisticManager(StatisticDAO dao) {
        this.statisticDAO = dao;
    }

    public Statistic getStatistics(String team) {
        return null;
    }

    public void saveStatistic(Statistic statistic) {
    }
}
