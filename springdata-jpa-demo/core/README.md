# Core module

This module contains core classes.

## Annotation processing

The code is compilable fine using Maven. However your IDE requires the annotation processors to be configured.
You need to configure:

* org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor - for JPA criteria API, and
* com.mysema.query.apt.jpa.JPAAnnotationProcessor - for QueryDSL

In IDEA go to Settings -> Compiler -> Annotation Processors enable annotation processing, add processors providing
fully qualified names and define where processed files should be saved. You will need to add this directory to
the source folders in File -> Project Structure. After that you only need to compile the project.

For other IDE reffer to appropriate manuals how to configure Java 6 annotation processors.