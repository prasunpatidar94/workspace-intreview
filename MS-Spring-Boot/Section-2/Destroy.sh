#!/bin/bash

set -e  # Exit on error
echo "🔧=====================Docker Composed down initiated ==========================🔧"
sleep 10
echo "🔧 Stoping Containers and Removing...!"
sleep 10
(cd /d/workspace-intreview/MS-Spring-Boot/Section-2 && \
 docker-compose down)
echo "🔧===================================Docker Composed Down=======================🔧"
