# A Piece’s Tour 

## Solution:
There are several ways to find a piece's tour on a given board. I chose Warnsdorff's rule.

## Warnsdorff’s Rule:
Warnsdorff's rule is a heuristic for finding a single piece's tour.
The piece is moved so that it always proceeds to the square from which the piece will have the fewest onward moves.
When calculating the number of onward moves for each candidate square, we do not count moves that revisit any square already visited.
It is possible to have two or more choices for which the number of onward moves is equal; there are various methods for breaking such ties, including one devised by Pohl and another by Squirrel and Cull.

Backtracking is an algorithmic paradigm that tries different solutions until finds a solution that “works”.
Problems which are typically solved using backtracking technique have following property in common. 
These problems can only be solved by trying every possible configuration and each configuration is tried only once. 
A Naive solution for these problems is to try all configurations and output a configuration that follows given problem constraints. 
Backtracking works in incremental way and is an optimization over the Naive solution where all possible configurations are generated and tried.
Based on this definition basically, I used Backtracking and Recursion as the main part of my solution.

## Some definitions:

A position Q is accessible from a position P if P can move to Q by a single piece’s move, and Q has not yet been visited.
The accessibility of a position P is the number of positions accessible from P.

## Algorithm:

    Set P to be a random initial position on the board
    Mark the board at P with the move number “1”
    Do following for each move number from 2 to the number of squares on the board:
    let S be the set of positions accessible from P.
    Set P to be the position in S with minimum accessibility
    Mark the board at P with the current move number
    Return the marked board — each square will be marked with the move number on which it is visited.

## Prerequisites:
For test and run this project you just need to have `mvn` command in your path.

## Run all tests:
There are several integration and unit tests for project, you can run them by this command:

    mvn test

## Run project:
In order to run this project you need to run this command:

    mvn clean compile exec:java -Dexec.mainClass="com.demo.Application"