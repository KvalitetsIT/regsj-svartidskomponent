#!/bin/sh

echo "${GITHUB_REPOSITORY}"
echo "${DOCKER_SERVICE}"
if [ "${GITHUB_REPOSITORY}" != "KvalitetsIT/regsj-svartidskomponent" ] && [ "${DOCKER_SERVICE}" = "kvalitetsit/regsj-svartidskomponent" ]; then
  echo "Please run setup.sh REPOSITORY_NAME"
  exit 1
fi
