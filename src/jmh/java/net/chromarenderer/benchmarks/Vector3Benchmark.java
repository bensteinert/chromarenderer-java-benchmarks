package net.chromarenderer.benchmarks;

import net.chromarenderer.math.ImmutableVector3;
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
public class Vector3Benchmark {

    private static ImmutableVector3 V1 = new ImmutableVector3(1.f, 2.f, 3.f);
    private static ImmutableVector3 V2 = new ImmutableVector3(4.f, 5.f, 6.f);

    @Benchmark
    public ImmutableVector3 crossProduct() {
        return V1.crossProduct(V2);
    }

    @Benchmark
    public float scalarProduct() {
        return V1.dot(V2);
    }

    @Benchmark
    public ImmutableVector3 minus() {
        return V1.minus(V2);
    }


}
