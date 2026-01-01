package com.all.core.java.misc;

import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class GSMConnectModern {
	
	public static void main(String[] args) throws Exception {
		
		SerialPort port = SerialPort.getCommPort("COM6");
		port.setBaudRate(115200);
		if (port.openPort()) {
			System.out.println("Failed to open port");
			return;
		}
		OutputStream out = port.getOutputStream();
		out.write("AT\r\n".getBytes());
		Thread.sleep(1000);
		out.write("AT+CMGF=1\r\n".getBytes()); // text mode
		Thread.sleep(1000);
		out.write("AT+CMGS=\"+91XXXXXXXX\"\r\n".getBytes());
		Thread.sleep(2000);
		out.write("Hello from Java GSM\u001A".getBytes());
		out.flush();
		System.out.println("SMS Sent");
		out.close();
		port.closePort();
	}
}
