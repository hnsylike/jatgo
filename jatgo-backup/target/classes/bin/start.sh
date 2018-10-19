#!/bin/bash

source ~/AtgoSysEnv.sh

installDirectory=$(cd "$(dirname "$0")";cd ..; pwd)

JAVA_OPT="-server -d64 -Xms500M -Xmx500M -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:gc.log -DATGO_ENV=provided"

pushd "${installDirectory}"

nohup java $JAVA_OPT -Dserver_name=jatgo-backup -cp ./conf:lib/* org.springframework.boot.loader.JarLauncher &> /dev/null 2>&1 &

java_pid=`ps -aux|grep java|grep jatgo-backup|grep -v "grep"|awk '{print $2}'`
if [ "$java_pid" = "" ];then
echo "start jatgo-backup fail,see log for detail"
else
echo "start jatgo-backup success!"
fi

popd
