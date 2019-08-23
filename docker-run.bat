mvn clean package -Dmaven.test.skip=true
mvn docker:build -Dmaven.test.skip=true
