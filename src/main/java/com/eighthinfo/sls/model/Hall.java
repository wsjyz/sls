package com.eighthinfo.sls.model;

/**
 * User: dam
 * Date: 13-11-22
 */
public class Hall {

    private String id;

    private String host;

    private int port;

    private int playerCounts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPlayerCounts() {
        return playerCounts;
    }

    public void setPlayerCounts(int playerCounts) {
        this.playerCounts = playerCounts;
    }
}
