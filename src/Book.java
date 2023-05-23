import java.util.*;

public class Book {

    private List<String> positions = new ArrayList<String>(){{
        add("A"); add("B"); add("C"); add("D"); add("E"); add("F");
    }};

    public int TimeTaken(String pickup, String drop){ //time taken to travel from A to Z in hours
        return Math.abs(positions.indexOf(pickup) - positions.indexOf(drop));
    }

    public int distance(String pickup, String drop){ //distance between A and Z in km
        return TimeTaken(pickup, drop) * 15;
    }

    public int getFare(String pickup, String drop){ //fare to travel from A to Z
        return (distance(pickup, drop)-5)*10 + 100;
    }

    public List<Taxi> FreeTaxis(List<Taxi> taxis, int pickupTime, String pickup){ //function to find all taxis free for booking
        List<Taxi> freeTaxi = new ArrayList<>();
        for(Taxi t: taxis){
            if((TimeTaken(t.getCurrLocation(), pickup) + t.getTime()) <= pickupTime){ //if sum of time taken to travel from taxi location to pickup and time the taxi is available next is less than pickup time, taxi is assigned as free
                freeTaxi.add(t);
            }
        }
        return freeTaxi;
    }

    public boolean validity(String pickup, String drop){ //function to check whether Pickup & Drop points are valid
        return positions.contains(pickup) && positions.contains(drop);
    }
    public void bookTaxi(int id, String A, String Z, int time, List<Taxi> taxis){ //function to book taxi
        List<Taxi> freeTaxi = FreeTaxis(taxis, time, A);
        Collections.sort(freeTaxi, Comparator.comparingInt((Taxi cab) -> distance(A, cab.getCurrLocation())).thenComparingInt(Taxi::getEarning));
        Taxi taxi = freeTaxi.get(0);
        String tripInfo = id + "\t\t" + id + "\t\t" + A + "\t\t" + Z + "\t\t" + time + "\t\t" + (time+TimeTaken(A, Z)) + "\t\t\t" + getFare(A, Z);
        taxi.setDetails(true, Z, time+TimeTaken(A, Z), getFare(A, Z), tripInfo);
        System.out.println("Taxi "+taxi.getId()+" Booked!!!");
    }
    public List<Taxi> createTaxis(int n){ //function to create Taxis based on user input
        List<Taxi> taxis = new ArrayList<Taxi>();
        for(int i=1 ;i <=n;i++){
            Taxi t = new Taxi();
            taxis.add(t);
        }
        return taxis;
    }
}
