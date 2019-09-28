package pages.pojo;

public class FlightSearchDetails {

    private String fromAirport;
    private String toAirport;
    private String departsOnDate;

    public void setFromAirport(String fromAirport)
    {
        this.fromAirport=fromAirport;
    }

    public void setToAirport(String toAirport)
    {
        this.toAirport=toAirport;
    }

    public void setDepartsOnDate(String departsOnDate)
    {
        this.departsOnDate=departsOnDate;
    }

    public String getFromAirport()
    {
        return this.fromAirport;
    }

    public String getToAirport()
    {
        return this.toAirport;
    }

    public String getDepartsOnDate()
    {
        return  this.departsOnDate;
    }
}
