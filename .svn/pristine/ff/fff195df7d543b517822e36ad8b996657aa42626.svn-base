#!/bin/bash
java_pid=`ps -aux|grep java|grep jatgo-backup|grep -v "grep"|awk '{print $2}'`
if [ "$java_pid" = "" ];then
echo "no jatgo-backup pid alive!"
else
kill -9 $java_pid
echo stop jatgo-backup $java_pid success
fi
