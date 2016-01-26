package net.chromarenderer.benchmarks;

import net.chromarenderer.math.ImmutableVector3;
import net.chromarenderer.math.geometry.Triangle;
import net.chromarenderer.math.raytracing.Ray;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MoellerTrumboreTriangleIntersectionBenchmark {


    private static Triangle TRIANGLE = new Triangle(
            new ImmutableVector3(0.f, 0.f, 1.f),    //x
            new ImmutableVector3(.0f, 1.f, 1.f),    //y
            new ImmutableVector3(1.f, 0.f, 1.f),    //z
            new ImmutableVector3(0.f, 0.f, -1.f));
    private static Ray RAY = new Ray(new ImmutableVector3(0.2f, 0.2f, 0.f), new ImmutableVector3(0.f, 0.f, 1.f));


    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @Fork(value = 1)
    @Measurement(batchSize = 1000000, iterations = 100)
    public float benchmarkMoellerTrumboreTriangleIntersect() {
        return TRIANGLE.intersect(RAY);
    }

}
