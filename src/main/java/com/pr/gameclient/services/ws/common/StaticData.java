package com.pr.gameclient.services.ws.common;

public class StaticData {
    public static final int SERVER_PORT = 8888;
    public static final String SERVER_CONTEXT_PATH = "/ws";
    public static final String REGION_PATH = "/tes";


    public static final int MAX_WAIT_SEC = 5 * 1000;
    public static final int SCORE_FOR_WIN = 20; //100

    public static String getServerAdress(String hostname) {
        return "ws://" + hostname + ":" + SERVER_PORT + SERVER_CONTEXT_PATH + REGION_PATH;
    }
}
