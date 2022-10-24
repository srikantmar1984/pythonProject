  
/**
 * Write a description of class Booking here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.Scanner;
public class Booking extends Train
{
    // instance variables - replace the example below with your own
    static String[]  TrainNo = {"12814" , "12809", "12261", "12138" ,"22222"};
    static String[]  TrainName = {"12814-STEEL EXP" , "12809-HOWRAH MAIL", "12261-HOWRAH DURONTO", "12138-PUNJAB MAIL" ,"22222-CSMT RAJDHANI"};
    static String[] StationBoard = {"TATA JN", "HOWRAH JN", "HOWRAH JN", "AMRITSAR JN","MUMBAI JN"};
    static String[] destination = {"HOWRAH JN", "MUMBAI JN", "PUNE JN", "TATA JN","NEW DELHI JN"};
    static String[] coach_No = {"S1", "S2", "S3", "S4","S5","S6", "S7", "S8", "S9","S10"};
    static int[][] pnr = new int[50][]; // 5 trains for 10 dates =50 and 99 seats for 10 coaches = 990
    static String[][] passengerDtls = new int[50][];
    static int seat_count = 990;
    static String[][] dateAvlSeat_t1 = new String[10][seat_count];
    static String[][] dateAvlSeat_t2 = new String[10][seat_count];
    static String[][] dateAvlSeat_t3 = new String[10][seat_count];
    static String[][] dateAvlSeat_t4 = new String[10][seat_count];
    static String[][] dateAvlSeat_t5 = new String[10][seat_count];
    //static String[][] seatDtls = new String[5][seat_count];
    // static String[][] passengerName = new String[5][seat_count];
    // static String[][] passengerAge = new String[5][seat_count];
    // static String[][] passengerGender = new String[5][seat_count];
    //Fare value in Rupees per 10 Km
    // static int c = 10;
    // static int cc = 8;
    // static int b = 15;
    // static int a = 20;
    // static int d = 5;
    static int reserv_charge = 50;
    static int base_fare = 30;
    static int km10_fare = 10;
    static String[][] trainStopages = {{"TATA JN","Ghatshila","Chakuliya","Jhargram","Shordia","Kharagpur","Howrah"}
                        ,{ "HOWRAH JN","Kharagpur","Tata Nagar","Rourkella","Raigad","Bilaspur","Raipur","Nagpur","Nashik","Mumbai"}
                        ,{"HOWRAH JN","Kharagpur","Tata Nagar","Rourkella","Raigad","Bilaspur","Raipur","Nagpur","Ahemadnagar","Pune"}
                        ,{"AMRITSAR JN","New Delhi","Lucknow","Varanasi","Gaya","Bokaro","Puruliya","Tata"}
                        ,{"MUMBAI JN","Nashik","Nagpur","ujjain","Bhopal","JabalPur","Agra", "New Delhi"}};
    static int[][] trainDist = {{0,40,20,40,20,30,100}
        ,{0,100,150,200,120,100,200,180,250,240}
        ,{0,100,150,200,120,100,200,180,300,140}
        ,{0,300,350,200,250,150,100,90}
        ,{0,240,250,200,150,300,100,200}};
    static String[][] trainDates = {{"1-Nov-2022 (Tue)","2-Nov-2022 (Wed)","3-Nov-2022 (Thu)","4-Nov-2022 (Fri)","5-Nov-2022 (Sat)","6-Nov-2022 (Sun)","7-Nov-2022 (Mon)","8-Nov-2022 (Tus)","9-Nov-2022 (Wed)","10-Nov-2022 (Thu)"}
        ,{"3-Nov-2022 (Thu)","4-Nov-2022 (Fri)","10-Nov-2022 (Thu)","11-Nov-2022 (Fri)","17-Nov-2022 (Thu)","18-Nov-2022 (Fri)","24-Nov-2022 (Thu)","25-Nov-2022 (Fri)","1-Dec-2022 (Thu)","2-Dec-2022 (Fri)"}
        ,{"1-Nov-2022 (Tue)","5-Nov-2022 (Sat)","8-Nov-2022 (Tue)","12-Nov-2022 (Sat)","15-Nov-2022 (Tue)","19-Nov-2022 (Sat)","22-Nov-2022 (Tue)","26-Nov-2022 (Sat)","29-Nov-2022 (Tue)","03-Dec-2022 (Sat)"}
        ,{"1-Nov-2022 (Tue)","3-Nov-2022 (Thu)","5-Nov-2022 (Sat)","8-Nov-2022 (Tue)","10-Nov-2022 (Thu)","12-Nov-2022 (Sat)","15-Nov-2022 (Tue)","17-Nov-2022 (Thu)","19-Nov-2022 (Sat)","22-Nov-2022 (Tue)"}
        ,{"1-Nov-2022 (Tue)","8-Nov-2022 (Tue)","15-Nov-2022 (Tue)","22-Nov-2022","29-Nov-2022 (Tue)","6-Dec-2022 (Tue)","13-Dec-2022 (Tue)","20-Dec-2022 (Tue)","27-Dec-2022 (Tue)","3-Jan-2023 (Tue)"}};
    
    
    
    static Scanner myObj = new Scanner(System.in);

    

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

    public static void main(String[] args) {
        
        System.out.println("Railway Reservation System");
        Booking bk = new Booking();
        menu();
        
    }
    public static void menu()
    {
        System.out.println("Enter your choice( serial number) from the list below");
        System.out.println("1. Train Details, 2. Book Ticket  3. Booking Details ");
        
        int mychoice = myObj.nextInt(); 
        
        switch(mychoice) {
            case 1:findTrains();
            break;
            case 2:ticketBooking();
            break;
            case 3:booking_details();
            break;
            
            default: System.out.println("Wrong Choice, please choose again");
                menu();
            break;
        }
        
    }
    static  void findTrains(){
        System.out.println("Enter Train Serial No for get details from the list below. ");
        for (int t=0; t<5;t++)
        {
            System.out.println((t+1)+") "+ TrainName[t]);
        }
        int trnSelct = myObj.nextInt();
        int ind = trnSelct-1;
        Train_details(ind);
        
    }
    static  void Train_details(int indx)
    {
        if(indx < 5 && indx> -1) {
            //System.out.println("Train No : "+ TrainNo[indx]);
            System.out.println("Name : "+ TrainName[indx]);
            System.out.println("Boarding Station : "+ StationBoard[indx]);
            System.out.println("Destination Station : "+ destination[indx]);
                      
            System.out.println("Following Stations are in between : ");
            System.out.println("0) "+ StationBoard[indx]);
            for (int c=1; c<trainStopages[indx].length;c++)
                System.out.println(c+") "+trainStopages[indx][c]+"-"+trainDist[indx][c]+"Kms");
            System.out.println("\n\n Train will run on following dates : ");
            for (int d=0; d<trainDates[indx].length;d++)
                System.out.print("\n"+(d+1)+"] "+trainDates[indx][d]);
            
            System.out.println("\n Do you want to check availability? Enter YES Or NO");
            String chkTicket = myObj.next();
            
            if(chkTicket.equalsIgnoreCase("YES")) {
                checkAvailibility(indx);
            }
            
        }else{
            menu();
        }
        System.out.println("\n To find more train details press between 1 to 5 else press 0 to back to main menu: ");
        int trnSelct = myObj.nextInt();
        int ind = trnSelct-1;
        Train_details(ind);
    }
    static void calculateFare(String boardStation,String destStation,int indx,int noOfPassender){
        int fare = base_fare;
        int ticket_dist = 0;
        for (int c=1; c<trainStopages[indx].length;c++)
        {
            ticket_dist += trainDist[indx][c];
            if(trainStopages[indx][c] == destStation){
                break;
            }
        }
        System.out.println("\n Distance : "+ ticket_dist);
        fare =  (fare+(km10_fare*(ticket_dist/10))+reserv_charge);
        System.out.println("\n Fare : Rs "+ (noOfPassender* fare));
    }
   
    static void checkAvailibility (int indx){
        //System.out.println("\n\n Please enter Train Sl.No : ");
        //int selctedTrainSlno = myObj.nextInt();
        System.out.println("\n Please enter Journey Date Sl. No : ");
        int journeyDateSlno = myObj.nextInt();
        System.out.println("\n Please enter Boarding Station Sl No : ");
        int boardingStationSlno = myObj.nextInt();
        System.out.println("\n Please enter Destination Station Sl No:  ");
        int destStationSlno = myObj.nextInt();
        // System.out.println("\n\n Please enter seat/berth coach category from the list: \n a: First Class \n b:Two Tier AC \n c: Three Tier AC \n cc:Seating AC  \n d:2nd Seating  ");
        // String seatClass = myObj.next();
        if(journeyDateSlno>=trainDates[indx].length){
            System.out.println("\n\n Warning....!Please enter sl no of journey date.");
            checkAvailibility (indx);
        }
        else if(boardingStationSlno>=trainStopages[indx].length){
            System.out.println("\n\n Warning....!Please enter sl no of Boarding Station.");
            checkAvailibility (indx);
             
        }
        else if(destStationSlno>=trainStopages[indx].length){
            System.out.println("\n\n Warning....!Please enter sl no of Destination Station.");
            checkAvailibility (indx);
             
        }
        else if(boardingStationSlno ==destStationSlno){
            System.out.println("\n\n Warning....!Please enter seperate sl no for Boarding Station and Destination Station");
            checkAvailibility (indx);
             
        }else{
            
            int seat_booked = 0;
            String[][] arr = new String[10][990];
            switch(indx){
                case 1: arr =dateAvlSeat_t1;break;
                case 2: arr =dateAvlSeat_t2;break;
                case 3: arr =dateAvlSeat_t3;break;
                case 4: arr =dateAvlSeat_t4;break;
                default: arr =dateAvlSeat_t5;break;
            }
            
            for (int s=0; s < arr[journeyDateSlno].length;s++)
            {
                if(arr[indx][s] == null){
                    
                    break;
                }
                else{
                    seat_booked++;
                }
            }
            int avlSeat = 990-seat_booked;
            System.out.println("\n No of seats Avalable:"+ avlSeat);
            calculateFare(StationBoard[boardingStationSlno],destination[destStationSlno],indx,1);
            
            System.out.println("\n Do you want to book a ticket? Enter YES Or NO");
            String bookTicket = myObj.next();
            
            if(bookTicket.equalsIgnoreCase("YES")) {
                reservation(indx,boardingStationSlno,destStationSlno,journeyDateSlno,avlSeat);
            }
            
            if(bookTicket.equalsIgnoreCase("NO")) {
                return;
            }
            
        }
    }
    static void reservation(int trainSlNo,int bStationSlno,int dStationSlno,int jDateSlno,int avlSeat)
    {
        String passnger[];
        System.out.println("\n Please enter number of seat required : ");
        int noOfSeat = myObj.nextInt();
        if(noOfSeat>0){
            
            if(avlSeat>noOfSeat   ){
                for (int n=0; n < noOfSeat;n++)
                {
                    System.out.println("\n Please enter Passenger Name: ");
                    String passName = myObj.next();
                    System.out.println("\n Please enter Passenger Age: ");
                    int passAge = myObj.nextInt();
                    System.out.println("\n Please enter Passenger Gender code; M for Male & F for Female: ");
                    String passGend = myObj.next();
                    passengerDtls[n]={passName, passAge,passGend};
                    
                }
                 pnr=bookticket(trainSlNo,bStationSlno,dStationSlno, jDateSlno,passnger[][]);
                // switch(trainSlNo){
                        // case 1:break;
                        // case 2: bookticket(dateAvlSeat_t2,trainSlNo,bStationSlno,dStationSlno, jDateSlno, passName, passAge,passGend);break;
                        // case 3: bookticket(dateAvlSeat_t3,trainSlNo,bStationSlno,dStationSlno, jDateSlno, passName, passAge,passGend);break;
                        // case 4: bookticket(dateAvlSeat_t4,trainSlNo,bStationSlno,dStationSlno, jDateSlno, passName, passAge,passGend);break;
                        // default: bookticket(dateAvlSeat_t5,trainSlNo,bStationSlno,dStationSlno, jDateSlno, passName, passAge,passGend);break;
                    // }
            }else{
                System.out.println("\n Warning....!Avaliable seat is lower than the required seats: ");
                
            }
        }
        
    }
    static String bookticket( int trainSlNo,int bStationSlno,int dStationSlno,int jDateSlno,String passName,int passAge,String passGend){
        String ticketString
    }
    static void ticketBooking(){
        
    }
    static void booking_details()
    {
        // put your code here
        System.out.println("booking_details");
    }
    
}
