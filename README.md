# Base Conversion Calculator

## Introduction
This Java Project helps convert numbers between different bases. A few functions created to validate, convert, and manage numbers in various base systems.

## Function Descriptions
These functions are in Ex1.java:

### number2Int
- **Input**: A string in the format `numberbbase` (e.g., `5b8`).
- **Output**: The number in decimal.
- **Conditions**:
  - The base must be between 2 and 16.
  - For bases 10 and above, use letters A to G (A=10, B=11, etc.).
  - No spaces or illegal characters (only A to G allowed).

### isNumeric
- **Input**: A numeric string.
- **Output**: Boolean indicating if the string contains only digits.

### isNumber
- **Input**: A numeric string.
- **Output**: Boolean indicating if the string is valid based on the criteria.

### int2Number
- **Input**: Two integers (number and base).
- **Output**: A string representing the number in the given base (e.g., `100` in base 2 is `100b2`).

### maxIndex
- **Input**: An array of numeric strings in various bases.
- **Output**: The index of the string with the highest decimal value.

## Features
- Convert a string with a number in a specific base to decimal.
- Helper functions for validating numbers.
- Convert a decimal number to a given base.
- Find the index with the highest decimal value.

## Tests
Tests are in Ex1Test.java and include cases for all functions.

## Usage
Using the calculator is easy! Just input numbers and bases in the correct format and get the results.
- Ex1Main.java: Handles user input and output.

## Example
- Input: `5b8`, `A1b12`, `100b2`
- Output: `5`, `121`, `4`

## Installation
Clone the repository from GitHub and run the Java classes.

## License
This project is licensed under the MIT License.
