import java.util.*;
public class Taxi {
    private static int taxiNo = 0;
    private int id;
    private boolean booked;
    private int earning;
    private String currLocation;
    private int time;
    private List<String> trips;

    public Taxi(){
        setBooked(false);
        setCurrLocation("A");
        setEarning(0);
        setTime(6);
        setTaxiNo(getTaxiNo()+1);
        setId(getTaxiNo());
        setTrips(new ArrayList<String>());
    }

    public void setDetails(boolean booked, String currLocation, int time, int earning, String tripInfo){
        setBooked(booked);
        setCurrLocation(currLocation);
        setTime(time);
        setEarning(earning);
        addTrips(tripInfo);
    }
    @Override
    public String toString() {
        return "Taxi - "+id+"\t\tEarning - "+earning+"\t\t\tCurrentLocation - "+currLocation+"\t\t\tNextAvailTime - "+time;
    }
    public void printDetails(){
        System.out.println("Taxi "+this.id + "\t\tEarning - "+this.earning);
        System.out.println("taxiID\tBookID\tCustID\tFrom\tTo\tPickupTime\tDropTime\tPayment");
        for(String trip: trips){
            System.out.println(id + "\t\t"+trip);
        }
        System.out.println("xxxxx-----xxxxx");
    }
    public void addTrips(String trip){
        List<String> newTrip = getTrips();
        newTrip.add(trip);
        setTrips(newTrip);
    }
    public String getCurrLocation() {
        return currLocation;
    }

    public void setCurrLocation(String currLocation) {
        this.currLocation = currLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEarning() {
        return earning;
    }

    public void setEarning(int earning) {
        this.earning = earning;
    }

    public static int getTaxiNo() {
        return taxiNo;
    }

    public static void setTaxiNo(int taxiNo) {
        Taxi.taxiNo = taxiNo;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<String> getTrips() {
        return trips;
    }

    public void setTrips(List<String> trips) {
        this.trips = trips;
    }

}
