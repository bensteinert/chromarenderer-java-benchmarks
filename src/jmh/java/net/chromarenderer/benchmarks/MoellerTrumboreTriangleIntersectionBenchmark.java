package net.chromarenderer.benchmarks;

import net.chromarenderer.math.ImmutableVector3;
import net.chromarenderer.math.geometry.Triangle;
import net.chromarenderer.math.raytracing.Ray;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Warmup;

public class MoellerTrumboreTriangleIntersectionBenchmark {


    private static Triangle TRIANGLE = new Triangle(
            new ImmutableVector3(0.f, 0.f, 1.f),    //x
            new ImmutableVector3(.0f, 1.f, 1.f),    //y
            new ImmutableVector3(1.f, 0.f, 1.f),    //z
            new ImmutableVector3(0.f, 0.f, -1.f));
    private static Ray RAY = new Ray(new ImmutableVector3(0.2f, 0.2f, 0.f), new ImmutableVector3(0.f, 0.f, 1.f));


    @Benchmark
    @Warmup(iterations = 5) // warmups per fork
    @Fork(warmups = 2, value = 5)
    public float benchmarkIntersect() {
        return TRIANGLE.intersect(RAY);
    }

}
