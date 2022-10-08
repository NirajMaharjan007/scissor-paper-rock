@echo off
timeout 2 > NUL
echo Hello user: %username%
echo Please wait a second
timeout 4 > NUL
java -jar --enable-preview "scissor-paper-rock.jar"
pause
