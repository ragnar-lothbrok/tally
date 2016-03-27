#! /bin/sh
total=1
awk -F"|" '{print "Name="$2, "Score = "$4;};' $1
awk -F"|" '{ tot += $4; n += 1; }  END { print "Average Score : " tot/n; }' $1
