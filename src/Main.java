import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter total no of taxis:");
        int noTaxi = in.nextInt(); //total no of taxis
        List<Taxi> taxis = book.createTaxis(noTaxi); //taxis are created
        int id = 1;
        while(true){
            System.out.println("1. Book Taxi \t 2. Print Taxi Info \t 3. Exit");
            String choice = in.next();
            if(choice.startsWith("1")){
                System.out.println("Enter Pickup:");
                String pickup = in.next().charAt(0) + "";
                System.out.println("Enter Drop:");
                String drop = in.next().charAt(0) + "";
                System.out.println("Enter Pickup Time:");
                int pickupTime = in.nextInt();
                if(!book.validity(pickup, drop)) //validity of pickup and drop is checked
                {
                    System.out.println("Invalid inputs. Either your pickup or drop location doesn't exist.");
                    continue;
                }
                List<Taxi> freeTaxis = book.FreeTaxis(taxis, pickupTime, pickup); //free taxis are found out
                if(freeTaxis.size()<1){
                    System.out.println("No Taxis Available at the your location");
                    continue;
                }
                book.bookTaxi(id, pickup, drop, pickupTime, taxis); //taxi is booked
                id++;
            }
            else if(choice.startsWith("2")){
                for(Taxi t:taxis){
                    System.out.println(t.toString());
                }
                for(Taxi t:taxis){
                    t.printDetails();
                }
            }
            else{
                return;
            }
        }

    }
}