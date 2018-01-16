package com.joyveb.rpc.service;

public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String echo) {
        return echo != null ? echo + "--> I am ok." : "I am ok.";
    }
}
