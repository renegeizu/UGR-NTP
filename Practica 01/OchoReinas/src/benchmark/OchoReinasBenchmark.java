package benchmark;

import classes.Type;
import heuristics.Searcher;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class OchoReinasBenchmark {

    static int dimension = 8;

    static Searcher heuristic = new Searcher(dimension);

    public static void main(final String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(OchoReinasBenchmark.class.getSimpleName())
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
        heuristic.solve(Type.FUNCTIONAL);
    }

    @Benchmark
    // @Fork(value = 1, warmups = 1)
    // @Warmup(iterations = 1)
    // @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void imperativeHeuristic() {
        heuristic.solve(Type.IMPERATIVE);
    }

}
