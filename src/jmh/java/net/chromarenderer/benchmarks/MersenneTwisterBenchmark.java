package net.chromarenderer.benchmarks;

import net.chromarenderer.math.random.MersenneTwisterFast;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;

/**
 * @author bensteinert
 */
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.SingleShotTime)
@Fork(value = 1)
@Measurement(batchSize = 1000000, iterations = 100)
@State(Scope.Thread)
public class MersenneTwisterBenchmark {

    private MersenneTwisterFast mt;

    @Setup
    public void setup(){
        mt = new MersenneTwisterFast(13499);
    }

    @Benchmark
    public double MTnextDouble () {
        return mt.nextDouble();
    }


}
