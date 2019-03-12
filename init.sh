set -e

cd `dirname $0`
r=`pwd`
echo $r


#run app
cd $r/transactions
chmod +x gradlew
./gradlew build

#command -v docker-compose >/dev/null 2>&1 || { echo >&2 "docker compose is required. Aborting."; exit 1; }

docker-compose up
