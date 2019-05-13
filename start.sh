sudo sbt clean compile
sudo sbt clean stage
sudo -E target/universal/stage/bin/chattheme -Dconfig.file=/git/chattheme/conf/application.conf \
-Dhttp.port=80 \
-Dplay.crypto.secret=${APPLICATION_SECRET}