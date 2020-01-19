# Production build

`mvn clean package -Pproduction`

# Deploy

`scp target/jamote-*.jar nemo@10.0.0.88:`

`ssh nemo@10.0.0.88 "/home/nemo/jdk/bin/java -jar jamote-*.jar"`
