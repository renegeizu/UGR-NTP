package benchmark;

import classes.Problem;
import classes.Utilities;
import heuristics.Heuristic;
import heuristics.MonteCarlo;
import heuristics.NearestNeighbour;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MonteCarloBenchmark {

    static Problem problem;

    static {
        try {
            problem = new Problem("./data/berlin52.tsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Heuristic heuristic = new MonteCarlo();

    public static void main(final String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(MonteCarloBenchmark.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                // .measurementTime(TimeValue.milliseconds(1000))
                .forks(1)
                // .result("results.csv")
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    // @Fork(value = 1, warmups = 1)
    // @Warmup(iterations = 1)
    // @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void functionalHeuristic() {
        heuristic.calculateOptimalPath(problem, Utilities.Type.FUNCTIONAL);
    }

    @Benchmark
    // @Fork(value = 1, warmups = 1)
    // @Warmup(iterations = 1)
    // @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void imperativeHeuristic() {
        heuristic.calculateOptimalPath(problem, Utilities.Type.IMPERATIVE);
    }
}
