#!/bin/bash

if docker pull kvalitetsit/regsj-svartidskomponent-documentation:latest; then
    echo "Copy from old documentation image."
    docker cp $(docker create kvalitetsit/regsj-svartidskomponent-documentation:latest):/usr/share/nginx/html target/old
fi
