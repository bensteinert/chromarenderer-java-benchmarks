package net.chromarenderer.benchmarks;

import net.chromarenderer.math.random.MersenneTwisterFast;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

/**
 * @author bensteinert
 */
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.SingleShotTime)
@Fork(value = 1)
@Measurement(batchSize = 1000000, iterations = 100)
public class MersenneTwisterBenchmark {

    private static MersenneTwisterFast mt = new MersenneTwisterFast(13499);

    @Benchmark
    public double MTnextDouble () {
        return mt.nextDouble();
    }


}
