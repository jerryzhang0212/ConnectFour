# Connect Four (Java)

A grid-based two-player Connect Four game implemented in Java, designed to strengthen algorithmic thinking and structured program design.

## Overview

This project models the classic Connect Four game using a 2D array (row-major representation) to manage board state and game logic. The implementation focuses on clean win-condition detection, input validation, and modular game flow control.

## How It Works

The board is represented as a 2D integer array.  
Each move updates the lowest available row in a selected column.  
After every move, the program scans the board in four directions to check for a win condition.
