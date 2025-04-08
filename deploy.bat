set "working_dir=."
set "webapps=C:\Program Files\Apache Software Foundation\Tomcat 10.1\webapps"
set "name=ETU003208"

REM 
if exist "%working_dir%\build" (
    rmdir /s /q "%working_dir%\build"
)

if exist "%working_dir%\out" (
    rmdir /s /q "%working_dir%\out"
)

mkdir "%working_dir%\out"

mkdir "%working_dir%\build"
mkdir "%working_dir%\build\WEB-INF"
mkdir "%working_dir%\build\WEB-INF\classes"
mkdir "%working_dir%\build\WEB-INF\lib"



copy "%working_dir%\lib\*" "%working_dir%\build\WEB-INF\lib"

xcopy /s /e /q "%working_dir%\src\main\webapp\*" "%working_dir%\build\"

for /r "%working_dir%\src\main\java" %%f in (*.java) do copy "%%f" "%working_dir%\out"

javac -cp "%working_dir%\build\WEB-INF\lib\*" -d "%working_dir%\build\WEB-INF\classes" %working_dir%\out\*.java

jar cvf "%working_dir%\%name%.war" -C "%working_dir%\build" .
move "%working_dir%\%name%.war" "%webapps%"