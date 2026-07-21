APP_NAME := StudentGradeService
BASE_URL := http://localhost:8080/$(APP_NAME)
MVN := mvn
ASADMIN ?= /Applications/payara7/glassfish/bin/asadmin

.PHONY: help build clean start deploy redeploy undeploy run urls

help:
	@echo "Available targets:"
	@echo "  make build   - Build the WAR with Maven"
	@echo "  make clean   - Remove Maven build output"
	@echo "  make start   - Start the Payara domain"
	@echo "  make deploy  - Build and deploy the WAR to Payara"
	@echo "  make redeploy - Build and redeploy the WAR to Payara"
	@echo "  make undeploy - Remove the app from Payara"
	@echo "  make run     - Start Payara, build, deploy, and show URLs"
	@echo "  make urls    - Show browser/Postman test URLs"

build:
	$(MVN) clean package

clean:
	$(MVN) clean

start:
	$(ASADMIN) start-domain

deploy: build
	$(ASADMIN) deploy --contextroot $(APP_NAME) target/$(APP_NAME).war

redeploy: build
	$(ASADMIN) redeploy --name $(APP_NAME) --contextroot $(APP_NAME) target/$(APP_NAME).war

undeploy:
	$(ASADMIN) undeploy $(APP_NAME)

run: start deploy urls
	@echo ""
	@echo "Open:"
	@echo "$(BASE_URL)/"

urls:
	@echo "Application:"
	@echo "$(BASE_URL)/"
	@echo ""
	@echo "GET query parameter endpoint:"
	@echo "$(BASE_URL)/api/gradeservice/getgrade?name=Kasun&mark=90"
	@echo ""
	@echo "GET path parameter endpoint:"
	@echo "$(BASE_URL)/api/gradeservice/Kasun/70"
