module framework.input {
    requires application.input;
    requires static lombok;
    requires org.slf4j;
    requires jakarta.cdi;
    requires jakarta.ws.rs;
    requires io.smallrye.mutiny;
    requires modelmapper;
 }