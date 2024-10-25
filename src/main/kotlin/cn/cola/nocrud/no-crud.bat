@echo off

REM 检查Java是否在PATH环境变量中
java -version >nul 2>&1

if errorlevel 1 (
    echo Java未安装或未在PATH环境变量中，请安装Java后再运行此脚本。
    exit /b 1
)

REM 运行Java程序
echo 正在启动No-CRUD...
java -jar nocrud-all.jar %*
