#!/bin/bash
java_pid=`ps -aux|grep java|grep jatgo-risk|grep -v "grep"|awk '{print $2}'`
if [ "$java_pid" = "" ];then
echo "no jatgo-risk pid alive!"
else
kill -9 $java_pid
echo stop jatgo-risk $java_pid success
fi
