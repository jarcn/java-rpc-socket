package com.joyveb.rpc.main;

import com.joyveb.rpc.exporter.RpcExporter;
import com.joyveb.rpc.importer.RpcImporter;
import com.joyveb.rpc.service.EchoService;
import com.joyveb.rpc.service.EchoServiceImpl;

import java.net.InetSocketAddress;

public class TestMain {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.exporter("127.0.0.1", 8080);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        ).start();

        RpcImporter<EchoService> importer = new RpcImporter<>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("127.0.0.1", 8080));
        System.out.println(echo.echo("Are you ok ?"));
    }
}

