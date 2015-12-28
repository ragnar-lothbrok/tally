package com.home.flume;

public class MyApp {
	public static void main(String[] args) {
		MyRpcClientFacade client = new MyRpcClientFacade();
		// Initialize client with the remote Flume agent's host and port
		client.init("0.0.0.0", 40415);

		// Send 10 events to the remote Flume agent. That agent should be
		// configured to listen with an AvroSource.
		String sampleData = "Hello Flume!";
		for (int i = 0; i < 10; i++) {
			client.sendDataToFlume(sampleData);
		}

		client.cleanUp();
	}
}
