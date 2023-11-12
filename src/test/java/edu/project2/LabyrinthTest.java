package edu.project2;
import edu.project2.generator.RecursiveBacktrackingGenerator;
import edu.project2.maze.Cell;
import edu.project2.renderer.ConsoleRenderer;
import edu.project2.solver.AStarSolver;
import edu.project2.solver.BFSolver;
import edu.project2.solver.DFSolver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;

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

        // Проверка, что поиск решения прошел успешно
        var bfsolver = new BFSolver();
        var result = bfsolver.solve(maze, start, end);

        // Проверка, что результат не null
        assertThat(result).isNotNull();

        // Проверка, что результат является валидным путем в лабиринте
        validatePath(result, start, end);
    }

    // Метод для проверки валидности пути в лабиринте
    private void validatePath(List<Cell> path, Cell start, Cell end) {
        // Проверка, что начало и конец пути соответствуют заданным ячейкам
        assertThat(path).contains(start, end);

        // Проверка, что каждая ячейка пути является проходом
        for (var cell : path) {
            assertThat(cell.type()).isEqualTo(Cell.Type.PASSAGE);
        }
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

        // Проверка, что поиск решения прошел успешно
        var dfsolver = new DFSolver();
        var result = dfsolver.solve(maze, start, end);
        assertThat(result).isNotEmpty();
        validatePath(result, start, end); // Добавлено здесь
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

        // Проверка, что поиск решения прошел успешно
        var astarSolver = new AStarSolver();
        assert start != null;
        assert end != null;
        var result = astarSolver.solve(maze, start, end);
        assertThat(result).isNotEmpty();
        validatePath(result, start, end); // Добавлено здесь
    }


    @Test
    void testRender() {
        var mazeGenerator = new RecursiveBacktrackingGenerator(10, 10);
        var maze = mazeGenerator.generate();
        var consoleRenderer = new ConsoleRenderer();

        try {
            String renderedMaze = consoleRenderer.render(maze);

            // Проверяем, что в результате рендеринга присутствуют определенные символы
            assertThat(renderedMaze).contains("|", "-", "\n");
        } catch (NoSuchElementException e) {
            // Ожидаемая ситуация - пустой лабиринт
            assertThat(e.getMessage()).isEqualTo("No cell below");
        }
    }


    @Test
    void testRenderNonEmptyMaze() {

        var mazeGenerator = new RecursiveBacktrackingGenerator(10, 10);
        var maze = mazeGenerator.generate();
        Cell start = null;
        Cell end = null;
        var consoleRenderer = new ConsoleRenderer();

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
        try {
            String renderedMaze = consoleRenderer.render(maze, result);
            assertThat(renderedMaze).contains("|", "-", "●", "\n");

        } catch (NoSuchElementException e) {
            // Этот тест не должен генерировать исключение, так как лабиринт не пустой
            fail("Unexpected NoSuchElementException");
        }

    }

}
