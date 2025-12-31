#!/bin/bash
file="C:\Users\jatin\Downloads\sample-log.txt"
if [ -f "$file" ]; then
echo "File exist"
else
echo "File not exist"
fi

totalLines=0
TotalLines=$(wc -l "$file")
echo "$TotalLines"

infocount=0
countInfo=$(grep -ci "info" "$file")
echo "$countInfo"

warningCount=0
countWarning=$(grep -ci "warning" "$file")
echo "$countWarning"

errorCount=0
countError=$(grep -ci "error" "$file")
echo "$countError"

IP_LIST=$(grep -oE '[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}' "$file" | sort | uniq)
echo "$IP_LIST"