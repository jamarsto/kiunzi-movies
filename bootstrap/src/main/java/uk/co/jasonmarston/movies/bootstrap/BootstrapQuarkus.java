package uk.co.jasonmarston.movies.bootstrap;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class BootstrapQuarkus {
	public static void main(final String[] args) {
		Quarkus.run(args);
	}
}
