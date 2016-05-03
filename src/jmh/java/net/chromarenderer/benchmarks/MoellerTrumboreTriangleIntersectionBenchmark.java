package net.chromarenderer.benchmarks;

import net.chromarenderer.math.ImmutableVector3;
import net.chromarenderer.math.geometry.ObjectLayoutTriangle;
import net.chromarenderer.math.geometry.SimpleTriangle;
import net.chromarenderer.math.raytracing.Ray;
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
public class MoellerTrumboreTriangleIntersectionBenchmark {

    private static SimpleTriangle TRIANGLE = new SimpleTriangle(
            new ImmutableVector3(0.f, 0.f, 1.f),    //x
            new ImmutableVector3(.0f, 1.f, 1.f),    //y
            new ImmutableVector3(1.f, 0.f, 1.f),    //z
            new ImmutableVector3(0.f, 0.f, -1.f));

    private static ObjectLayoutTriangle OBJECT_TRIANGLE = ObjectLayoutTriangle.createTriangle(
            new ImmutableVector3(0.f, 0.f, 1.f),    //x
            new ImmutableVector3(.0f, 1.f, 1.f),    //y
            new ImmutableVector3(1.f, 0.f, 1.f),    //z
            new ImmutableVector3(0.f, 0.f, -1.f));

    private static Ray RAY = new Ray(new ImmutableVector3(0.2f, 0.2f, 0.f), new ImmutableVector3(0.f, 0.f, 1.f));


    @Benchmark
    public float benchmarkMoellerTrumboreTriangleIntersect() {
        return TRIANGLE.intersect(RAY);
    }


    @Benchmark
    public float benchmarkMoellerTrumboreObjectLayoutTriangleIntersect() {
        return OBJECT_TRIANGLE.intersect(RAY);
    }

}
