@echo off
cd\
%~d0
cd %~sdp0
call mvn mybatis-generator:generate
pause