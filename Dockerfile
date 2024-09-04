# Usa l'immagine Maven ufficiale come immagine base
FROM maven:3.8.4-openjdk-11

# Imposta la directory di lavoro nel container
WORKDIR /app

# Copia il file pom.xml e la cartella src nel container
COPY pom.xml .
COPY src ./src

# Esegui il comando mvn test
CMD ["mvn", "test"]