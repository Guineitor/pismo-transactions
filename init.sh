set -e

cd `dirname $0`
r=`pwd`
echo $r


#run app
chmod +x gradlew
./gradlew build

