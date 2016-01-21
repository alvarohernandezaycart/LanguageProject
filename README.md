Pasos a seguir para clonar aura-base:

############################################################################################################################
AURABASE-ROOT
############################################################################################################################

1. En pom.xml: Cambiar groupId y artifactId
2. En pom.xml: Cambiar los nombres de los módulos: aurabase-common, aurabase-console, ...
3. En pom.xml: Revisar versión de la dependencia de aura-core por si existe una nueva.
4. En pom.xml: Para que Sonar revise el directorio de sources, cambiar el valor de project.build.sourceDirectory
5. Cambiar de nombre a los proyectos aurabase-common, aurabase-api, aurabase-console, aurabase-engine y aurabase-web


############################################################################################################################
AURABASE-COMMON
############################################################################################################################

1. En pom.xml: Cambiar groupId y artifactId del pom.xml
2. aura-base/aurabase-common/src/main/resources/common.conf cambiar nombre bbdd.
3. aura-base/aurabase-common/src/main/resources/logback.xml cambiar nombre y ruta ficheros logs.
4. Cambiar nombre de los paquetes java y en cada java la ruta del paquete al que pertenece la clase.


############################################################################################################################
AURABASE-CONSOLE
############################################################################################################################

1. En pom.xml: groupId, artifactId, ...
2. En pom.xml: Cambiar mainClass del plugin de assembly para indicar correctamente cuál es la clase ejecutable
3. En pom.xml: Cambiar las dependencias de common
4. Cambiar nombre de los paquetes java y en cada java la ruta del paquete al que pertenece la clase.


############################################################################################################################
AURABASE-WEB
############################################################################################################################

1. En pom.xml: groupId, artifactId, ...
2. En pom.xml: Cambiar mainClass del plugin de assembly para indicar correctamente cuál es la clase ejecutable
3. En pom.xml: Cambiar las dependencias de common
4. Adaptar web.conf en aura-base/aurabase-web/src/main/resources (default view y rest user/pwd)
5. Cambiar nombre del paquete bower.js en aura-base/aurabase-web/src/main/resources/webapp/js/src/bower.json
6. Adaptar gruntfile.js para traer los estáticos del proyecto en cuestión (en aurabase se traen los estáticos de auramaint). Ver línea 64.
7. Cambiar nombre del package.
8. Cambiar nombre del módulo angular de la aplicación en aura-base/aurabase-web/src/main/resources/webapp/js/src/modules/app.js
9. Adaptar iconos y textos propios de la aplicación en el header y footer de aura-base/aurabase-web/src/main/resources/webapp/WEB-INF/views/partials
10. Cambiar nombre de los paquetes java y en cada java la ruta del paquete al que pertenece la clase.
11. Cambiar los nombres de las clases del paquete src/main/java/com/nemsolutions/aurabase/config . Recordad de cambiar los import que hacen entre ellos.
12. Cambiar el rol necesario para logearse a la web en aura-base/aurabase-web/src/main/java/com/nemsolutions/aurabase/config/AuramaintSpringSecurityConfig.java

############################################################################################################################
AURABASE-API
############################################################################################################################

1. En pom.xml: grouptId, artifactId, ...


############################################################################################################################
AURABASE-ENGINE
############################################################################################################################

1. En pom.xml: grouptId, artifactId, ...

############################################################################################################################
VALIDACION
############################################################################################################################

1. Empaquetar el proyecto ejecutando "mvn package" en raíz
2. Validar la consola. "java -jar auraxxx-console/target/auraxxx-console-0.0.1-SNAPSHOT-jar-with-dependencies.jar -fm"  y "java -jar auraxxx-console/target/auraxxx-console-0.0.1-SNAPSHOT-jar-with-dependencies.jar -create_development_scenario"
3. Validar la web. "java -jar auraxxx-web/target/auraxxx-web-0.0.1-SNAPSHOT-jar-with-dependencies.jar"

############################################################################################################################
LIMPIEZA DE CODIGO
############################################################################################################################

1. Una vez validado que todo funciona correctamente se pueden quitar o modificar los datos y classes de ejemplo. Para ello se puede borrar:
   auraxxx-console/src/main/resources/db/migration/V1__init_structure.sql
   auraxxx-console/src/main/java/com/nemsolutions/aurabase/commands/developmentScenario/**
   auraxxx-console/src/main/java/com/nemsolutions/aurabase/commands/CommandFactory.java
   auraxxx-common/src/main/java/com/nemsolutions/aurabase/components/generic/**
   auraxxx-web/src/main/java/com/nemsolutions/aurabase/controller/html/**
   auraxxx-web/src/main/resources/webapp/js/src/modules/baseexample/**
   auraxxx-web/src/main/resources/webapp/js/src/modules/app.js
   auraxxx-web/src/main/resources/webapp/WEB-INF/views/baseexample/**
   
   
