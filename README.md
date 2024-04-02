# The Treasure Map


This project implements a treasure map simulator in Java. It reads an input file specified by the user, simulates the movements of adventurers, and generates an output file indicating the final position of the adventurers and the collected treasures.
## Features

- Reading the input file describing the map, mountains, treasures, and adventurers.
- Simulating adventurers' movements while respecting the map's constraints.
- Managing treasure collection by adventurers during their movement.
- Generating an output file containing the final simulation result.

## Prerequisites

- Java JDK 17 or later
- Maven 3.9.6 or later
- (Optional) docker and docker-compose

## Input File Format

The input file must follow a specific format to describe the map, mountains, treasures, and adventurers. Here's an example format:
```
C - 3 - 4
M - 1 - 0
M - 2 - 1
T - 0 - 3 - 2
T - 1 - 3 - 3
A - Lara - 1 - 1 - S - AADADAGGA
```
- `C` defines the dimensions of the map.
- `M` indicates the presence of a mountain at a specific position.
- `T` represents a treasure with its position and the number of treasures.
- `A` represents an adventurer with their name, initial position, orientation, and movement sequence.
  - The orientation can be one of the following characters:
    - `N`: North
    - `S`: South
    - `E`: East
    - `W`: West
  - The movement sequence consists of the following characters:
    - `A`: Move forward
    - `D`: Turn right
    - `G`: Turn left

## Install the project

1. Clone this repository to your local machine:
```
git clone https://github.com/TonyoCallimoutou/treasure_map.git
```
2. Navigate to the project directory:

```
cd treasure-map
```

## Build project and run test without docker

1. Build the project using Maven:
```
mvn clean install
```

2. Run only the tests:
```
mvn test
```
## Run the project without docker

### Default Paths
By default, the program will use the following file paths:

- Input file: src/main/resources/input.txt
- Output file: src/main/resources/result.txt

To run the program with these default file paths, execute the following command:

```
java -jar .\target\treasure_map-1.0-SNAPSHOT.jar 
```

### Optional: Specifying Custom Input and Output Paths
Alternatively, you can specify custom input and/or output file paths:

```
java -jar .\target\treasure_map-1.0-SNAPSHOT.jar --input=src/main/resources/input.txt --output=src/main/resources/result.txt
```

## (Optional) Run the project using Docker

1. Build the Docker image:
```
docker-compose up --build -d
```

2. build the project using Maven:
```
docker exec treasure_map_builder mvn clean install
```

2. Run only the tests:
```
docker exec treasure_map_builder mvn test
```

3. Run the Docker container with or without default input and output file paths:
```
docker exec treasure_map java -jar /app/target/treasure_map-1.0-SNAPSHOT.jar --input=src/main/resources/input.txt --output=src/main/resources/result.txt
```

4. Stop and remove the Docker container:
```
docker-compose down
```