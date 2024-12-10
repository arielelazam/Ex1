# Ex1

# Project: Base Conversion Calculator

## Introduction
This project is a Java-based calculator designed to convert numbers between various bases. The project includes multiple functions to validate, convert, and manipulate numbers in different base systems.

## Function Descriptions
The following functions are located in the Ex1.java class:

### number2Int
- **Input**: A string in the format `numberbbase` (e.g., `5b8`).
- **Output**: The decimal integer representation of the number.
- **Conditions**:
  - The base must be between 2 and 16.
  - For bases 10 and above, numbers are represented using letters A, B, etc., with A=10, B=11, up to G=16.
  - The input must not contain spaces and must include both a number and a base.
  - The input must not contain unrelated symbols or letters other than A to G (G is only allowed in base 16).

### isNumeric
- **Input**: A string representing a number.
- **Output**: A boolean indicating whether the string contains only numeric digits.
- **Usage**: A helper function for validating numeric strings.

### isNumber
- **Input**: A string representing a number.
- **Output**: A boolean indicating whether the string is a valid number according to the criteria defined in `number2Int`.
- **Usage**: Ensures the number is valid in the specified base.

### int2Number
- **Input**: Two integers, one representing a number and one representing a base.
- **Output**: A string representing the number in the specified base (e.g., `100` in base 2 becomes `100b2`).

### maxIndex
- **Input**: An array of strings representing numbers in various bases.
- **Output**: An integer representing the index of the string with the highest decimal value.
- **Usage**: Finds the maximum decimal value in an array of base-represented numbers.

## Features
- **number2Int**: Converts a string representation of a number in a given base (e.g., `5b8`) to its decimal (base 10) integer representation.
- **isNumeric**: A helper function that checks if a given string contains only numeric digits.
- **isNumber**: Validates a string to ensure it meets the criteria for being a valid number in the specified base.
- **int2Number**: Converts an integer from base 10 to a specified base and returns the result as a string (e.g., `100` in base 2 becomes `100b2`).
- **maxIndex**: Takes an array of strings representing numbers in various bases and returns the index of the string with the highest decimal value.

## Tests
The following class includes tests and analysis:
- **Ex1Test.java**: Includes test cases for each function to ensure their correctness.

## Usage
To use the calculator, input numbers and bases following the required format and receive the converted outputs.
- **Ex1Main.java**: Handles user input and output for converting numbers according to the specified format.

## Example
- Input: `5b8`, `A1b12`, `100b2`
- Output: `5`, `121`, `4`.
