package com.pr.gameclient.helpers;

public class StaticData {
    public static final int SERVER_PORT = 8888;
    public static final String SERVER_CONTEXT_PATH = "/ws";
    public static final String REGION_PATH = "/tes";

    public static String getServerAdress(String hostname) {
        return "ws://" + hostname + ":" + SERVER_PORT + SERVER_CONTEXT_PATH + REGION_PATH;
    }
}
