package com.Vaccini.Vaccini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


@SpringBootApplication
public class VacciniApplication {

	public static void main(String[] args) throws IOException {
		URL website = new URL("https://raw.githubusercontent.com/italia/covid19-opendata-vaccini/master/dati/somministrazioni-vaccini-summary-latest.csv");
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream("C:\\Users\\sdicostanzo\\Desktop\\Vaccini\\src\\main\\resources\\dati.csv");
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		SpringApplication.run(VacciniApplication.class, args);
	}

}
