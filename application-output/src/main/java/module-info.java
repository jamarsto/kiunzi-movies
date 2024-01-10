module application.output {
    requires transitive domain;
    requires static lombok;
    requires transitive io.smallrye.mutiny;

    exports uk.co.jasonmarston.movies.output.port;
}