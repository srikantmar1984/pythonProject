  

import java.util.*;
import java.util.Scanner;
import java.lang.*;
import java.io.*;

public class Booking
{
    // instance variables - replace the example below with your own
    static String[]  TrainNo = {"12814" , "12809", "12261", "12138" ,"22222"};
    static String[]  TrainName = {"12814-STEEL EXP" , "12809-HOWRAH MAIL", "12261-HOWRAH DURONTO", "12138-PUNJAB MAIL" ,"22222-CSMT RAJDHANI"};
    static String[] StationBoard = {"TATA JN", "HOWRAH JN", "HOWRAH JN", "AMRITSAR JN","MUMBAI JN"};
    static String[] destination = {"HOWRAH JN", "MUMBAI JN", "PUNE JN", "TATA JN","NEW DELHI JN"};
    static String[] coach_No = {"S1", "S2", "S3", "S4","S5","S6", "S7", "S8", "S9","S10"};
    static String[] pnr_main = new String[0]; // 5 trains for 10 dates =50 and for initation of seats 0
    static String[] ticket_dtls = new String[0];
    //static int seat_count = 990;
    static String[][] dateAvlSeat_t1 = new String[10][0];
    static String[][] dateAvlSeat_t2 = new String[10][0];
    static String[][] dateAvlSeat_t3 = new String[10][0];
    static String[][] dateAvlSeat_t4 = new String[10][0];
    static String[][] dateAvlSeat_t5 = new String[10][0];
    //static String[][] seatDtls = new String[5][seat_count];
    // static String[][] passengerName = new String[5][seat_count];
    // static String[][] passengerAge = new String[5][seat_count];
    // static String[][] passengerGender = new String[5][seat_count];
    
	 static int t1_seatReserv = 0;
	 static int t2_seatReserv = 0;
	 static int t3_seatReserv = 0;
	 static int t4_seatReserv = 0;
	 static int t5_seatReserv = 0;
	 
	//Fare value in Rupees per 10 Km
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
        //Booking bk = new Booking();
        menu();
        
    }
    public static void menu()
    {
        System.out.println("Enter your choice( serial number) from the list below");
        System.out.println("\n1. Train Details \t 2. Book Ticket \t 3. Booking Details ");
        
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
            
            System.out.println("\n\nDo you want to check availability? Enter YES Or NO");
            String chkTicket = myObj.next();
            
            if(chkTicket.equalsIgnoreCase("YES")) {
                checkAvailibility(indx);
            }
            
        }else{
            menu();
        }
        System.out.println("\nEnter train serial no(between 1 to 5) to find train details else enter 0 for back to main menu: ");
        int trnSelct = myObj.nextInt();
        int ind = trnSelct-1;
        Train_details(ind);
    }
    static int calculateTrainFare(String boardStation,String destStation,int indx){
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
        System.out.println("\n Fare : Rs "+ fare);
        return fare;
    }
   
    static void checkAvailibility (int indx){

        System.out.println("\n Please enter Journey Date Sl. No : ");
        int journeyDateSlno = myObj.nextInt();
        System.out.println("\n Please enter Boarding Station Sl No : ");
        int boardingStationSlno = myObj.nextInt();
        System.out.println("\n Please enter Destination Station Sl No:  ");
        int destStationSlno = myObj.nextInt();

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
        	int avlSeat =0;
            switch(indx){
                case 1: t1_seatReserv = dateAvlSeat_t1[journeyDateSlno].length;avlSeat =990-t1_seatReserv;break;
                case 2: t2_seatReserv = dateAvlSeat_t2[journeyDateSlno].length;avlSeat =990-t2_seatReserv;break;
                case 3: t3_seatReserv = dateAvlSeat_t3[journeyDateSlno].length;avlSeat =990-t3_seatReserv;break;
                case 4: t4_seatReserv = dateAvlSeat_t4[journeyDateSlno].length;avlSeat =990-t4_seatReserv;break;
                default: t5_seatReserv = dateAvlSeat_t5[journeyDateSlno].length;avlSeat =990-t5_seatReserv;break;
            }
            
            System.out.println("\n No of seats avalable:"+ avlSeat);
            int fare = calculateTrainFare(trainStopages[indx][boardingStationSlno],trainStopages[indx][destStationSlno],indx);
            
            System.out.println("\n Do you want to book a ticket? Enter YES Or NO");
            String bookTicket = myObj.next();
            
            if(bookTicket.equalsIgnoreCase("YES")) {
                reservation(indx,boardingStationSlno,destStationSlno,journeyDateSlno,avlSeat,fare);
            }
            
            if(bookTicket.equalsIgnoreCase("NO")) {
                return;
            }
            
        }
    }
    static void reservation(int trainSlNo,int bStationSlno,int dStationSlno,int jDateSlno,int avlSeat, int fare)
    {
        
        System.out.println("\n Please enter number of seat required : ");
        int noOfSeat = myObj.nextInt();
       
        if(noOfSeat>0){
            String[][] passnger = new String[noOfSeat][3];
            if(avlSeat>noOfSeat){
                for (int n=0; n < noOfSeat;n++)
                {
                	System.out.println("\n Enter Gender of passenger "+(n+1)+" [code M for Male & F for Female] : ");
                    passnger[n][2] = myObj.nextLine();
                    System.out.println("\n Enter Age of passenger "+(n+1)+": ");
                    passnger[n][1] = myObj.nextLine();
                    System.out.println("\n Enter Name of passenger "+(n+1)+": ");
                    passnger[n][0] = myObj.nextLine();
                       
                }
                String pnr=bookticket(trainSlNo,bStationSlno-1,dStationSlno-1,fare, jDateSlno-1,passnger);
                System.out.println("\nTicket Booked successfully with PNR No:"+pnr);
                
                
            }else{
                System.out.println("\n Warning....!Avaliable seat is lower than the required seats: ");
                
            }
        }
        
    }
    static String bookticket( int trainSlNo,int bStationSlno,int dStationSlno, int fare,int jDateSlno,String[][] passengerDtls){
        int p_cnt = passengerDtls.length;
        String new_pnr_no= String.valueOf(jDateSlno)+String.valueOf(trainSlNo)+String.valueOf(bStationSlno)
        +String.valueOf(dStationSlno)+String.valueOf(passengerDtls.length)+String.format("%03d", (pnr_main.length+1));
        pnr_main= increase_array_size(pnr_main.length, pnr_main,new_pnr_no );
        
        String ticket_print="************************* TRAIN TICKET *************************";
        ticket_print+="\n"+String.format("%-20s","PNR NO")+" : "+new_pnr_no;
        ticket_print+="\n****************************************************************";
        ticket_print+="\n"+String.format("%-20s","Train No")+" : "+TrainName[trainSlNo];
        ticket_print+="\n"+String.format("%-20s","Date of Journey")+" : "+trainDates[trainSlNo][jDateSlno];
        ticket_print+="\n"+String.format("%-20s","Bording Station")+" : "+trainStopages[jDateSlno][bStationSlno];
        ticket_print+="\n"+String.format("%-20s","Destination Station")+" : "+trainStopages[jDateSlno][dStationSlno];
        ticket_print+="\n\n---- Passenger Details -----------------------------------------";
        ticket_print+="\n|S.No|"+String.format("%-30s","Passenger Name")+" |"+String.format("%8s","Age")+"\t |"+String.format("%10s","Gender")+"|";
        for(int p=0; p<p_cnt; p++){
            ticket_print+="\n|"+String.format("%4s",(p+1))+"| "+String.format("%-30s",passengerDtls[p][0])+"|"+String.format("%8s",passengerDtls[p][1])+" \t |"+String.format("%10s",passengerDtls[p][2])+"|";  
            String singlePassDetails = passengerDtls[p][0]+":"+passengerDtls[p][1]+":"+passengerDtls[p][2];
            switch(trainSlNo){
                        case 1  :
                        	dateAvlSeat_t1[jDateSlno] = increase_array_size(dateAvlSeat_t1[jDateSlno].length,dateAvlSeat_t1[jDateSlno],singlePassDetails);
                        	t1_seatReserv = dateAvlSeat_t1[jDateSlno].length;
                        	break;
                        case 2  :
                        	dateAvlSeat_t2[jDateSlno] = increase_array_size(dateAvlSeat_t2[jDateSlno].length,dateAvlSeat_t2[jDateSlno],singlePassDetails);
                        	t2_seatReserv = dateAvlSeat_t2[jDateSlno].length;
                        	break;
                        case 3  :
                        	dateAvlSeat_t3[jDateSlno] = increase_array_size(dateAvlSeat_t3[jDateSlno].length,dateAvlSeat_t3[jDateSlno],singlePassDetails);
                        	t3_seatReserv = dateAvlSeat_t3[jDateSlno].length;
                        	break;
                        case 4  :
                        	dateAvlSeat_t4[jDateSlno] = increase_array_size(dateAvlSeat_t4[jDateSlno].length,dateAvlSeat_t4[jDateSlno],singlePassDetails);
                        	t4_seatReserv = dateAvlSeat_t4[jDateSlno].length;
                        	break;
                        default : 
                    		dateAvlSeat_t5[jDateSlno] = increase_array_size(dateAvlSeat_t5[jDateSlno].length,dateAvlSeat_t5[jDateSlno],singlePassDetails);
	                    	t5_seatReserv = dateAvlSeat_t5[jDateSlno].length;
	                    	break;
             } 
            
        }
        ticket_print+="\n----------------------------------------------------------------";
        ticket_print+="\n\n---- Fare Breakup ----------------------------------------------";
        ticket_print+="\n|"+String.format("%-20s","Fare")+" : "+fare+"\t"+String.format("%-19s","No of passenger(s)")+" : "+ String.format("%-5s",p_cnt)+" |";
        
        double tax = (fare*p_cnt)*0.1;
        double p_fare = fare*p_cnt+tax;
        ticket_print+="\n|"+String.format("%-20s","Passenger fare")+" : "+fare*p_cnt+"\t"+String.format("%-19s","Tax on Fare")+" : "+String.format("%-5s",tax) +" |";
        ticket_print+="\n|"+String.format("%-20s","Total fare")+" : "+String.format("%-35s",p_fare)+" |";
        ticket_print+="\n----------------------------------------------------------------";
        ticket_dtls= increase_array_size(ticket_dtls.length,ticket_dtls,ticket_print);
            
        System.out.println("\n"+ticket_print);       
        return new_pnr_no;
    }
    static void ticketBooking(){
        // Show Train Names and selections for train
    	int trnSlNo=0;
    	
    	System.out.print("Enter Train No for booking from the list.\n");
        for (int t=0; t<TrainName.length;t++)
        {
            System.out.print(TrainName[t]+"\t");
        }
        System.out.print("\n");
        String trnNoSel = myObj.next();
        for (int s=0; s< TrainNo.length;s++)
        {
        	
        	if(trnNoSel.equals(TrainNo[s])) {
        		trnSlNo = s;
        		break;
        	}
        }
        
        
        System.out.print("\nEnter boarding and destination station serial number from the list, \n ");
        for (int c=0; c<trainStopages[trnSlNo].length;c++)
            System.out.print((c+1)+">> "+trainStopages[trnSlNo][c]+"\t ");
        System.out.print("\n");
        int stationBSel = myObj.nextInt();System.out.print("\n");
        int stationDSel = myObj.nextInt();
        System.out.print("Enter journey date from the list \n");
        for (int d=0; d<trainDates[trnSlNo].length;d++)
            System.out.print("\n"+(d+1)+"] "+trainDates[trnSlNo][d]+"\t ");
        
        System.out.print("\n");
        int journeyDateSlno = myObj.nextInt();
        
        int avlSeat =0;
        switch(trnSlNo){
            case 1: t1_seatReserv = dateAvlSeat_t1[journeyDateSlno].length;avlSeat =990-t1_seatReserv;break;
            case 2: t2_seatReserv = dateAvlSeat_t2[journeyDateSlno].length;avlSeat =990-t2_seatReserv;break;
            case 3: t3_seatReserv = dateAvlSeat_t3[journeyDateSlno].length;avlSeat =990-t3_seatReserv;break;
            case 4: t4_seatReserv = dateAvlSeat_t4[journeyDateSlno].length;avlSeat =990-t4_seatReserv;break;
            default: t5_seatReserv = dateAvlSeat_t5[journeyDateSlno].length;avlSeat =990-t5_seatReserv;break;
        }
        
        System.out.println("vacant seats :"+ avlSeat);
        int fare = calculateTrainFare(trainStopages[trnSlNo][stationBSel],trainStopages[trnSlNo][stationDSel],trnSlNo);
        
        reservation(trnSlNo,stationBSel-1,stationDSel-1,journeyDateSlno-1,avlSeat,fare);
        System.out.println("\n Do you want to book more tickets? Enter YES Or NO");
        String reponse = myObj.next();
        
        if(reponse.equalsIgnoreCase("YES")) {
        	ticketBooking();
        }
        else {
        	menu();
        }
        
    }
    static void booking_details()
    {
        int slno=0;
        System.out.println("Enter PNR No For Booking Details:");
        String pnr_val = myObj.next();
        for(int p=0; p<pnr_main.length; p++){
        	if(pnr_val == pnr_main[p])
        		slno = p;
            
        }
        System.out.println(ticket_dtls[slno]);
        
    }
    public static String[] increase_array_size(int n, String[] curr_arr, String str)
    {
    	
    	String newArray[] = new String[n + 1];
    	for (int i = 0; i < n; i++)
    		newArray[i] = curr_arr[i];
    	newArray[n] = str;
    	return newArray;
   }

}
