# Simple Content Negotiation Example using Spring MVC

To run the example first install it in your local maven repository
executing following command from the project root direcgtory:

  $ mvn install

Next go to the ``webapp`` directory and run either on Jetty 6 or
Tomcat 6 container:

  $ mvn jetty:run

  $ mvn tomcat:run

To get content in JSON run:

  $ curl http://localhost:8080/channels -H "Accept: application/json"

To get content in XML run:

  $ curl http://localhost:8080/channels -H "Accept: application/xml"

The content negotiation works only with ``Accept`` HTTP header. If you
want more advanced features consider using ``ContentNegotiatingViewResolver``.
