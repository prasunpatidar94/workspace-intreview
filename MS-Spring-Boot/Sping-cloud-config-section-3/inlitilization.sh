#!/bin/bash

set -e  # Exit on error

echo "🧹 Cleaning up Docker containers and images..."
docker-compose down --remove-orphans
docker system prune -f --volumes

echo "🔧===================================Accounts================================🔧"
echo "🔧 Building Accounts application image..."
(cd /d/workspace-intreview/MS-Spring-Boot/Section-2/accounts && \
 mvn clean)
sleep 2
(cd /d/workspace-intreview/MS-Spring-Boot/Section-2/accounts && \
 mvn clean compile install jib:dockerBuild -Dspring.profiles.active=docker -DskipTests)

echo "🔧===================================Loans===================================🔧"
echo "🔧 Building Loans application image..."
(cd /d/workspace-intreview/MS-Spring-Boot/Section-2/loans && \
 ./gradlew clean)
sleep 2
(cd /d/workspace-intreview/MS-Spring-Boot/Section-2/loans && \
 ./gradlew clean build jibDockerBuild -x test)

echo "🔧===================================Cards===================================🔧"
echo "🔧 Building Cards application image..."
(cd /d/workspace-intreview/MS-Spring-Boot/Section-2/cards && \
 ./gradlew clean)
sleep 2
(cd /d/workspace-intreview/MS-Spring-Boot/Section-2/cards && \
 ./gradlew clean build jibDockerBuild -x test)

echo "🔧=============Docker Compose Container Deployment===========================🔧"
echo "🐳 Starting Docker Compose for Container Deployment...!"
docker-compose up -d
sleep 10