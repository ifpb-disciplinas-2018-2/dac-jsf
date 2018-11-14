#FROM payara/server-full
#FROM payara/server-web
FROM payara/micro
COPY /target/dac-banco.war ${DEPLOY_DIR}