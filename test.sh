#!/bin/bash
x=1
while true
do
x=`expr $x + 1`
if [ $x -le 12 ]
then
echo "x is $x";
fi

echo "x is $x";

if [ $x -ge 15 ]
then
echo "x is $x";
break;
echo "out at after x = $x";
fi

done
