package upg4;

import java.util.*;
import java.util.concurrent.*;

public class AirPortSim {

    public static boolean landingRequest() {
        //return ThreadLocalRandom.current().nextInt(1, 100) <= 5;
        return Math.random() * 100 < 5;
    }

    public static boolean startingRequest() {
        return ThreadLocalRandom.current().nextInt(1, 100) <= 5;
        //return Math.random() * 100 < 5;
    }

    public static void main(String[] args) {

        // These are the the number of minutes that we expect a plane to take to use the runway
        final int TAKEOFFTIME = 20;
        final int LANDINGTIME = 20;
        final int TENYEARS = 10 * 365 * 24 * 60;


        Queue<Request> handledLandingRequest = new LinkedList<Request>();
        Queue<Request> handledStartingRequest = new LinkedList<Request>();

        // These two queues represent the Planes that have asked permission to take off or land
        Queue<Request> unHandledStartingRequest = new LinkedList<Request>();
        Queue<Request> unHandledLandingRequest = new LinkedList<Request>();

        RequestType requestType = RequestType.NONE;

        Request currentRequest = null;

        //Time after every loop is finished
        int currentTime = 0;
        int requestTimer = 0;

        while (currentTime != TENYEARS) {

            if (requestType == RequestType.NONE) {
                if (!unHandledLandingRequest.isEmpty()) {
                    requestType = requestType.LANDING;
                    currentRequest = unHandledLandingRequest.poll();
                } else if (!unHandledStartingRequest.isEmpty()) {
                    requestType = RequestType.TAKEOFF;
                    currentRequest = unHandledStartingRequest.poll();
                }
            }

            if (requestType != RequestType.NONE) { // if the requesttype is set at the moment
                requestTimer += 5;  // add to the counter which holds the current time a request has been in action
            }

            if (requestTimer == 20) {
                if (requestType == RequestType.LANDING) {
                    handledLandingRequest.add(currentRequest);
                } else if (requestType == requestType.TAKEOFF) {
                    handledStartingRequest.add(currentRequest);
                }
                requestType = requestType.NONE;
                requestTimer = 0;
            }


            for (Request r : unHandledLandingRequest) {
                r.waitingTime += 5;
            }
            for (Request r : unHandledStartingRequest) {
                r.waitingTime += 5;
            }

//            if (currentTime == 0)
//                unHandledLandingRequest.add(new Request());
//            if (currentTime == 5)
//                unHandledStartingRequest.add(new Request());

            currentTime += 5;

            if (landingRequest()) {
                unHandledLandingRequest.add(new Request());
            }

            if (startingRequest()) { // if we get a starting request and we dont have a request type
                unHandledStartingRequest.add(new Request()); // add a request to the unhandledStarting queue
            }

        }

        float totalLandWait = 0;
        float maxLandWait = 0;
        for (var r : handledLandingRequest) {
            totalLandWait += r.waitingTime;
            if (maxLandWait < r.waitingTime)
                maxLandWait = r.waitingTime;
        }
        float avgLandWait = totalLandWait / (handledLandingRequest.size());
        System.out.println("Wait for landing: avg " + avgLandWait + ", max " + maxLandWait);


        float totalTakeoffWait = 0;
        float maxTakeoffWait = 0;
        for (var r : handledStartingRequest) {
            totalTakeoffWait += r.waitingTime;
            if (maxTakeoffWait < r.waitingTime)
                maxTakeoffWait = r.waitingTime;
        }
        float avgLiftoffWait = totalTakeoffWait / handledStartingRequest.size();
        System.out.println("Wait for liftoff: avg " + avgLiftoffWait + ", max " + maxTakeoffWait);

    }

    enum RequestType {
        LANDING, TAKEOFF, NONE;
    }

    private static class Request {
        private int waitingTime = 0;
    }
}
