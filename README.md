This is a Java conversion of my refactored version of my Create Task.

You can see the refactored version [here](https://github.com/awesomeshot5051/HyperspaceEmulatorPythonEdition)

You can see the original version [here](https://github.com/awesomeshot5051/HyperSpaceEmulator)

---

## Overview

Hyperspace Emulator is an interactive JavaFX desktop application that simulates space travel across our Solar System. Users can input planetary destinations and experience an animated journey through hyperspace with realistic travel time calculations.

## Features

- **Interactive Planetary Selection**: Type any planet name (Sun, Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune, or Pluto) to initiate travel
- **Realistic Travel Time Calculations**: Uses distance data to compute accurate travel times in seconds, minutes, hours, or days
- **Animated Hyperspace Journey**: Multi-stage animation sequence including:
  - Entering hyperspace transition
  - In-hyperspace tunnel visualization
  - Exiting hyperspace
  - Arrival at destination
- **Live Countdown Timer**: Displays real-time countdown during travel in T- HH:MM:SS format
- **Dynamic UI Updates**: Seamlessly transitions between travel sequence and normal UI states
- **Visual GIF Assets**: Displays animated backgrounds for each space sequence and planet destination

## Architecture

### Core Components

- **Main.java**: Entry point that sets up the JavaFX stage, scene, and primary UI with text input field
- **Launcher.java**: Application launcher that initializes the JavaFX application
- **Variables.java**: Centralized state management for stage, image, imageview, and UI components

### Utilities

- **Travel.java**: Orchestrates the entire travel sequence, managing animations and UI transitions
- **LoadGifs.java**: Handles dynamic loading and switching of GIF animations
- **TravelTimeCalculation.java**: Calculates travel duration based on planet distance and speed factor
- **PlanetInformation.java**: Defines planetary data including distance values from Earth
- **Strings.java**: Utility for converting input strings to sentence case

### Technologies

- **JavaFX 21**: GUI framework with scene management and animation timelines
- **Gradle**: Build automation and dependency management
- **ControlsFX**: Enhanced JavaFX controls library

## How It Works

1. User enters a planet name into the text field
2. Travel sequence initiates with countdown timer
3. GIF animations transition through hyperspace journey stages
4. Travel duration is calculated based on real astronomical distances (scaled)
5. UI displays arrival message upon reaching destination
6. Original UI is restored for next travel input

## Build & Run

```bash
./gradlew run
```

Built with **Java** (55.7%) and **CSS** (44.3%) for styling
