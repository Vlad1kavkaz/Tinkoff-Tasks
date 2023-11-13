package edu.project2.renderer;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;
import java.util.List;

public interface Renderer {
    default String render(Maze maze) {
        return List.of().toString();
    }

    default String render(Maze maze, List<Cell> path) {
        return List.of().toString();
    }
}
