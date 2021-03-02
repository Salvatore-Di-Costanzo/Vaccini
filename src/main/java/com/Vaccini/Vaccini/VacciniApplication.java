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
		URL somministrazione = new URL("https://raw.githubusercontent.com/italia/covid19-opendata-vaccini/master/dati/somministrazioni-vaccini-summary-latest.csv");
		ReadableByteChannel rbc1 = Channels.newChannel(somministrazione.openStream());
		FileOutputStream fos1 = new FileOutputStream("C:\\Users\\sdicostanzo\\Desktop\\Vaccini\\src\\main\\resources\\datiSomministrazioni.csv");
		URL summary = new URL("https://raw.githubusercontent.com/italia/covid19-opendata-vaccini/master/dati/vaccini-summary-latest.csv");
		ReadableByteChannel rbc2 = Channels.newChannel(summary.openStream());
		FileOutputStream fos2 = new FileOutputStream("C:\\Users\\sdicostanzo\\Desktop\\Vaccini\\src\\main\\resources\\datiResoconto.csv");
		URL contagi = new URL("https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-latest.csv");
		ReadableByteChannel rbc3 = Channels.newChannel(contagi.openStream());
		FileOutputStream fos3 = new FileOutputStream("C:\\Users\\sdicostanzo\\Desktop\\Vaccini\\src\\main\\resources\\datiContagi.csv");
		fos1.getChannel().transferFrom(rbc1, 0, Long.MAX_VALUE);
		fos2.getChannel().transferFrom(rbc2, 0, Long.MAX_VALUE);
		fos3.getChannel().transferFrom(rbc3, 0, Long.MAX_VALUE);
		SpringApplication.run(VacciniApplication.class, args);
	}

}
