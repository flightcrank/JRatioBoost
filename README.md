
# 🚀 JRatioBoost

![Static Badge](https://img.shields.io/badge/Supports%20Java-%208%20and%20above-orange)

JRatioBoost is now at version 2.1. It is used to spoof uploads to private torrent trackers.
It will simply report to the torrent tracker that you are uploading, when you are really uploading nothing at all.
This will give you a good "ratio" on any private tracker that you use. It will work on any major operating system as long as
Java is installed on that system.

This program has been updated to version 2.1 and is considered complete. It does what it set out to do on every torrent tracker I have tested it on.
I will continue to maintain this program. If there are any issues contact me and ill see if i can solve them. This project started in 2014 as a C program and 2018
as a java program to fill the need of a spoofing program on linux as there were no other at the time.

it is designed to work on any Java version, from Java 8 or above.

features...

* 🆕 updated GUI (new progress bar)
* runs multiple torrents at a time
* can open multiple .torrent files as command line arguments or through the GUI file picker
* spoofs multiple torrent clients (kTorrent, Transmission, uTorrent and more) choose any version number for any of them !
* choose from any announce URL listed in the torrent file
* change port number reported to tracker
* runs on any operating system Yay for Linux users 🐧!
* free and open source software !

change log

21/11/2025
* improved error checking
* added custom progress bar
* fixed missing download label arrow icon

Compilation instructions are as follows... (browse to the src directory)

	$ javac JRatioBoost.java

that should compile all necessary .java files. to run the program type the command

	$ java JRatioBoost

If you just want to run the program, then go to "Releases" and download the latest version that it ready for use
and follow the instructions on how to run the program

NOTE: for users on openSuse or fedora based distros having trouble establishing a connection to **https** trackers. Changing
this line in the java.security file from true to **false** should solve connection issues you may have on java 8.

`security.useSystemPropertiesFile=true`

to

`security.useSystemPropertiesFile=false`

[Releases Page](https://github.com/flightcrank/JRatioBoost/releases)

## Images 
screenshot of version 2.1
![swing screenshot 2](https://i.imgur.com/fygr4h4.png)

screenshot of version 2.0
![swing screenshot 2](https://i.imgur.com/QJICBO5.png)

screenshot of previous version 1.0
![swing screenshot](https://i.imgur.com/8G9l9Ra.png)
