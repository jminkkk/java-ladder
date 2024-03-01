package model.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Height;
import model.Path;

public class RandomLinesGenerator implements LinesGenerator {
    private final Random random = new Random();

    @Override
    public List<Line> generate(final Height height, final int pathCount) {
        final List<Line> lines = new ArrayList<>();
        int lineSize = lines.size();
        while (height.isBigger(lines.size())) { // height.isBigger(lines.size());
            final Line generatedLine = generateLine(pathCount);
            lines.add(generatedLine);
            lineSize++;
        }
        return lines;
    }

    private Line generateLine(final int pathCount) {
        final List<Path> paths = new ArrayList<>();
        while (paths.size() < pathCount) {
            Path randomPath = getNextPath(paths);
            paths.add(randomPath);
        }
        return new Line(paths);
    }

    private Path getNextPath(final List<Path> paths) {
        if (!paths.isEmpty() && getLastPath(paths) == Path.EXIST) {
            return Path.NOT_EXIST;
        }
        if (random.nextBoolean()) {
            return Path.EXIST;
        }
        return Path.NOT_EXIST;
    }

    private Path getLastPath(final List<Path> paths) {
        return paths.get(paths.size() - 1);
    }
}
