package net.chromarenderer.benchmarks;

import net.chromarenderer.math.ImmutableVector3;
import net.chromarenderer.math.geometry.SimpleTriangle;
import net.chromarenderer.math.raytracing.Ray;
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

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.SingleShotTime)
@Fork(value = 1)
@Measurement(batchSize = 1000000, iterations = 100)
@State(Scope.Benchmark)
public class TriangleBenchmark {

    private SimpleTriangle simpleTriangle;

//    private ObjectLayoutTriangle objectLayoutTriangle = ObjectLayoutTriangle.createTriangle(
//            new ImmutableVector3(0.f, 0.f, 1.f),    //x
//            new ImmutableVector3(.0f, 1.f, 1.f),    //y
//            new ImmutableVector3(1.f, 0.f, 1.f),    //z
//            new ImmutableVector3(0.f, 0.f, -1.f));

    private Ray ray;


    @Setup
    public void setup(){
        simpleTriangle = new SimpleTriangle(
                new ImmutableVector3(0.f, 0.f, 1.f),    //x
                new ImmutableVector3(.0f, 1.f, 1.f),    //y
                new ImmutableVector3(1.f, 0.f, 1.f),    //z
                new ImmutableVector3(0.f, 0.f, -1.f));

        ray = new Ray(new ImmutableVector3(0.2f, 0.2f, 0.f), new ImmutableVector3(0.f, 0.f, 1.f));
    }

    @Benchmark
    public float benchmarkMoellerTrumboreTriangleIntersect() {
        return simpleTriangle.intersect(ray);
    }


//    @Benchmark
//    public float benchmarkMoellerTrumboreObjectLayoutTriangleIntersect() {
//        return objectLayoutTriangle.intersect(ray);
//    }

    @Benchmark
    public ImmutableVector3 benchmarkGetUnifDistSampleOnTriangle(){
        return simpleTriangle.getUnifDistrSample();
    }
}
