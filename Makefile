.PHONY: build

setup:
	gradlew wrapper --gradle-version 7.3

clean:
	gradlew clean

build:
	gradlew clean build

start:
	gradlew bootRun --args='--spring.profiles.active=dev'

check-updates:
	gradlew dependencyUpdates

generate-migrations:
	gradlew diffChangeLog

db-migrate:
	gradlew update

api-doc:
	gradlew clean generateOpenApiDocs