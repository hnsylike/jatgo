#!/bin/bash
java_pid=`ps -aux|grep java|grep jatgo-web|grep -v "grep"|awk '{print $2}'`
if [ "$java_pid" = "" ];then
echo "no jatgo-web pid alive!"
else
kill -9 $java_pid
echo stop jatgo-web $java_pid success
fi
