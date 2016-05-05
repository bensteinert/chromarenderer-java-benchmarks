package net.chromarenderer.benchmarks;

/**
 * @author bensteinert
 */

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.SingleShotTime)
@Fork(value = 1)
@Measurement(batchSize = 1000000, iterations = 100)
public class ReferenceBenchmark {

    @Benchmark
    public void emptyBenchmark(){
        int i = 1;
    }
}
