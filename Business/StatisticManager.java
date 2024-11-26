package Business;

public class StatisticsManager {
    private StatisticsDAO statisticDAO;

    public StatisticsManager(StatisticsDAO dao) {
        this.statisticDAO = dao;
    }

    public Statistic getStatistics(String team) {
        return null;
    }

    public void saveStatistic(Statistic statistic) {
    }
}
