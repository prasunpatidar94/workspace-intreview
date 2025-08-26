#!/bin/bash

set -e  # Exit on error
##
#echo "🧹 Cleaning up Docker containers and images..."
#docker-compose down --remove-orphans
#docker system prune -f --volumes
#


echo "🔧===================================Config server================================🔧"
echo "🔧 Building Config server application image..."
(cd /d/workspace-intreview/MS-Spring-Boot/Sping-cloud-config-section-3/configserver && \
 mvn clean)
sleep 2
(cd /d/workspace-intreview/MS-Spring-Boot/Sping-cloud-config-section-3/configserver && \
 mvn clean compile install jib:dockerBuild -Dspring.profiles.active=git,docker -DskipTests)
sleep 2

echo "🔧===================================Accounts================================🔧"
echo "🔧 Building Accounts application image..."
(cd /d/workspace-intreview/MS-Spring-Boot/Sping-cloud-config-section-3/accounts && \
 mvn clean)
sleep 2
(cd /d/workspace-intreview/MS-Spring-Boot/Sping-cloud-config-section-3/accounts && \
 mvn clean compile install jib:dockerBuild -Dspring.profiles.active=docker -DskipTests)
sleep 2
echo "🔧===================================Loans===================================🔧"
echo "🔧 Building Loans application image..."
(cd /d/workspace-intreview/MS-Spring-Boot/Sping-cloud-config-section-3/loans && \
 ./gradlew clean)
sleep 2
(cd /d/workspace-intreview/MS-Spring-Boot/Sping-cloud-config-section-3/loans && \
 ./gradlew clean build jibDockerBuild -x test)
sleep 2
echo "🔧===================================Cards===================================🔧"
echo "🔧 Building Cards application image..."
(cd /d/workspace-intreview/MS-Spring-Boot/Sping-cloud-config-section-3/cards && \
 ./gradlew clean)
sleep 2
(cd /d/workspace-intreview/MS-Spring-Boot/Sping-cloud-config-section-3/cards && \
 ./gradlew clean build jibDockerBuild -x test)
sleep 2
echo "🔧=============Docker Compose Container Deployment===========================🔧"
echo "🐳 Starting Docker Compose for Container Deployment...!"
#cd /d D:\workspace-intreview\MS-Spring-Boot\Sping-cloud-config-section-3\docker-compose-files\production && docker-compose up -d
sleep 10