package upg4;

import java.util.*;

public class AirPortSim {



    private static class Request{
        private int waitingTime;
    }

    enum RequestType{
        LANDING,TAKEOFF,NONE;
    }

    public static void main(String[] args) {
        // These are the the number of minutes that we expect a plane to take to use the runway
        final int TAKEOFFTIME = 20;
        final int LANDINGTIME = 20;

        // These two queues represent the Planes that have asked permission to take off or land
        Queue<Request> planesInTheAir = new LinkedList<Request>();
        Queue<Request> planesOnTheRunway = new LinkedList<Request>();

        RequestType requestType = RequestType.NONE;

        //Probabillity of landing or take off
        Random rand = new Random();

        // Random value between 100-1
        int val = 0;

        //Time after every loop is finished
        int currentTime = 0;

        while (currentTime != 10 * 365 * 24 * 60) {
            val = rand.nextInt(100) + 1;

            if(val >= 1 || val <= 5){
                planesInTheAir.add();
            }else

            currentTime+= 5;
        }

    }
}
