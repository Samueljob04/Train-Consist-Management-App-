# Train Consist Management App - UC1

This repository contains the UC1 (Use Case 1) implementation of the Train Consist Management App.

## Quick Start

### Build
```bash
mvn clean compile
```

### Run
```bash
mvn exec:java -Dexec.mainClass="uc.UC1InitializeTrainDisplayConsist"
```

Or compile and run with javac:
```bash
cd src
javac -d ../bin models/*.java uc/*.java
cd ../bin
java uc.UC1InitializeTrainDisplayConsist
```

## What is UC1?

UC1 demonstrates the initialization of a train with multiple bogies and displaying a comprehensive summary of the train's composition. It showcases fundamental OOP concepts including:

- **Classes and Objects**: Train and Bogie instances
- **Inheritance**: Bogie hierarchy with PassengerBogie and GoodsBogie
- **Polymorphism**: Different bogie types with overridden methods
- **Collections**: ArrayList management of train consist
- **Encapsulation**: Data hiding and controlled access

## Bogie Types

### Passenger Bogies
- **Sleeper**: Berth-style sleeping accommodation (72 berths)
- **AC Chair**: Air-conditioned chair cars (96 seats)
- **First Class**: Premium seating (48 seats)

### Goods Bogies
- **Rectangular Goods**: Box-shaped cargo containers
- **Cylindrical Goods**: Tank/barrel-shaped cargo containers

## Train Composition Example

The UC1 creates a mixed train with:
- 2 Sleeper bogies
- 1 AC Chair bogie
- 1 First Class bogie
- 1 Rectangular Goods bogie
- 1 Cylindrical Goods bogie

**Total: 6 bogies with 552 units total capacity**

## File Structure

```
├── src/
│   ├── models/          # Model classes
│   └── uc/              # Use case implementations
├── README.md            # Detailed documentation
├── pom.xml             # Maven configuration
└── QUICKSTART.md       # This file
```

## Requirements

- Java 8 or higher
- Maven 3.6+ (optional)

## License

MIT License
