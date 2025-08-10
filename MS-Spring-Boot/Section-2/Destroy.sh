#!/bin/bash

set -e  # Exit on error

timestamp() {
  date +"[%Y-%m-%d %H:%M:%S]"
}

echo "$(timestamp) 🔧===================== Docker Compose Down Initiated ==========================🔧"
sleep 2

echo "$(timestamp) 🔧 Stopping Containers and Removing Orphans..."
(cd /d/workspace-intreview/MS-Spring-Boot/Section-2 && \
 docker-compose down --remove-orphans)
sleep 2

echo "$(timestamp) 🔧===================== Docker Compose Down Completed ==========================🔧"

echo "$(timestamp) 🔧===================== Removing Docker Images ==========================🔧"
for image in codebysun/accounts codebysun/loans codebysun/cards; do
  if docker image inspect "$image" > /dev/null 2>&1; then
    docker image rm "$image"
    echo "$(timestamp) ✅ Removed image: $image"
  else
    echo "$(timestamp) ⚠️ Image not found: $image"
  fi
done

echo "$(timestamp) 🔧===================== Docker Image Cleanup Complete ==========================🔧"