FROM tomcat
COPY /target/dac-banco.war ${CATALINA_HOME}/webapps
#VOLUME "/usr/local/tomcat/testes"