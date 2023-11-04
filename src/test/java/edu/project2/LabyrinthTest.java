package edu.project2;
import edu.project2.generator.RecursiveBacktrackingGenerator;
import edu.project2.maze.Cell;
import edu.project2.solver.AStarSolver;
import edu.project2.solver.BFSolver;
import edu.project2.solver.DFSolver;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class LabyrinthTest {

    @Test
    void TestSmallLabyrinthBFS() {
        var mazeGenerator = new RecursiveBacktrackingGenerator(10, 10);
        var maze = mazeGenerator.generate();
        Cell start = null;
        Cell end = null;
        for (var i = 0; i < maze.getWidth(); i++) {
            for (var j = 0; j < maze.getHeight(); j++) {
                var cell = maze.cellAt(i, j);
                if (cell.type() == Cell.Type.PASSAGE) {
                    start = cell;
                    break;
                }
            }
        }

        for (var i = maze.getWidth() - 1; i >= 0; i--) {
            for (var j = maze.getHeight() - 1; j >= 0; j--) {
                var cell = maze.cellAt(i, j);
                if (cell.type() == Cell.Type.PASSAGE) {
                    end = cell;
                    break;
                }
            }
        }

        var bfsolver = new BFSolver();
        var result = bfsolver.solve(maze, start, end);
        assertThat(result).isNotNull();
    }

    @Test
    void TestSmallLabyrinthDFS() {
        var mazeGenerator = new RecursiveBacktrackingGenerator(10, 10);
        var maze = mazeGenerator.generate();
        Cell start = null;
        Cell end = null;
        for (var i = 0; i < maze.getWidth(); i++) {
            for (var j = 0; j < maze.getHeight(); j++) {
                var cell = maze.cellAt(i, j);
                if (cell.type() == Cell.Type.PASSAGE) {
                    start = cell;
                    break;
                }
            }
        }

        for (var i = maze.getWidth() - 1; i >= 0; i--) {
            for (var j = maze.getHeight() - 1; j >= 0; j--) {
                var cell = maze.cellAt(i, j);
                if (cell.type() == Cell.Type.PASSAGE) {
                    end = cell;
                    break;
                }
            }
        }

        var dfsolver = new DFSolver();
        var result = dfsolver.solve(maze, start, end);
        assertThat(result).isNotNull();
    }

    @Test
    void TestSmallLabyrinthAstar() {
        var mazeGenerator = new RecursiveBacktrackingGenerator(10, 10);
        var maze = mazeGenerator.generate();
        Cell start = null;
        Cell end = null;
        for (var i = 0; i < maze.getWidth(); i++) {
            for (var j = 0; j < maze.getHeight(); j++) {
                var cell = maze.cellAt(i, j);
                if (cell.type() == Cell.Type.PASSAGE) {
                    start = cell;
                    break;
                }
            }
        }

        for (var i = maze.getWidth() - 1; i >= 0; i--) {
            for (var j = maze.getHeight() - 1; j >= 0; j--) {
                var cell = maze.cellAt(i, j);
                if (cell.type() == Cell.Type.PASSAGE) {
                    end = cell;
                    break;
                }
            }
        }

        var astarSolver = new AStarSolver();
        var result = astarSolver.solve(maze, start, end);
        assertThat(result).isNotNull();
    }
}
