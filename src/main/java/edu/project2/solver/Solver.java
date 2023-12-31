package edu.project2.solver;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;
import java.util.List;

public interface Solver {
    List<Cell> solve(Maze maze, Cell start, Cell end);
}
