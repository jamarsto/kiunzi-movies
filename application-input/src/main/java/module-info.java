module application.input {
	requires transitive domain;
	requires application.output;
	requires static lombok;
	requires jakarta.cdi;
	requires transitive io.smallrye.mutiny;

	exports uk.co.jasonmarston.movies.usecase;
}