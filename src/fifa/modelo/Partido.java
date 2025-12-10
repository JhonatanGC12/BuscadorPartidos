package fifa.modelo;

public class Partido {
    private String fecha;
    private String home;
    private String away;
    private int homeGoals;
    private int awayGoals;
    private String torneo;

    public Partido(String fecha, String home, String away, int homeGoals, int awayGoals, String torneo) {
        this.fecha = fecha;
        this.home = home;
        this.away = away;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.torneo = torneo;
    }

    public String getFecha() { return fecha; }
    public String getHome() { return home; }
    public String getAway() { return away; }
    public int getHomeGoals() { return homeGoals; }
    public int getAwayGoals() { return awayGoals; }
    public String getTorneo() { return torneo; }
}
