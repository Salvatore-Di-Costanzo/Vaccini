package com.Vaccini.Vaccini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


@SpringBootApplication
public class VacciniApplication {

	public static void main(String[] args) throws IOException {

		File resourcesDirectory = new File("src/main/resources");
		final String PATH = resourcesDirectory.getAbsolutePath();

		URL contagi = new URL("https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-latest.csv");
		ReadableByteChannel rbc = Channels.newChannel(contagi.openStream());
		FileOutputStream fos = new FileOutputStream(PATH + "\\datiContagi.csv");
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		rbc.close();
		fos.close();
		SpringApplication.run(VacciniApplication.class, args);
	}

}
