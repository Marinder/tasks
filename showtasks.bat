call runcrud
if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo cannot run runcrud - breaking work
goto fail

:runbrowser
start chrome http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo cannot run browser - breaking work
goto fail


:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.