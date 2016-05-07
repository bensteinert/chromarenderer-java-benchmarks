//package net.chromarenderer.benchmarks;
//
//import net.chromarenderer.main.ChromaSettings;
//import net.chromarenderer.math.COLORS;
//import net.chromarenderer.math.ImmutableVector3;
//import net.chromarenderer.math.geometry.SimpleTriangle;
//import net.chromarenderer.math.raytracing.Hitpoint;
//import net.chromarenderer.math.raytracing.Ray;
//import net.chromarenderer.renderer.ChromaRenderMode;
//import net.chromarenderer.renderer.scene.GeometryScene;
//import net.chromarenderer.renderer.scene.acc.AccStructType;
//import net.chromarenderer.renderer.shader.Material;
//import net.chromarenderer.renderer.shader.MaterialType;
//import net.chromarenderer.renderer.shader.ShaderEngine;
//import org.junit.Before;
//import org.openjdk.jmh.annotations.Benchmark;
//import org.openjdk.jmh.annotations.BenchmarkMode;
//import org.openjdk.jmh.annotations.Fork;
//import org.openjdk.jmh.annotations.Measurement;
//import org.openjdk.jmh.annotations.Mode;
//import org.openjdk.jmh.annotations.OutputTimeUnit;
//import org.openjdk.jmh.annotations.Scope;
//import org.openjdk.jmh.annotations.Setup;
//import org.openjdk.jmh.annotations.State;
//
//import java.util.Arrays;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author bensteinert
// */
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@BenchmarkMode(Mode.SingleShotTime)
//@Fork(value = 1)
//@Measurement(batchSize = 1000000, iterations = 100)
//@State(Scope.Benchmark)
//public class DiffuseShaderBenchmark {
//
//    private Ray ray;
//    private SimpleTriangle simpleTriangle;
//    private Material material;
//    private Hitpoint hitpoint;
//    private ChromaSettings settings;
//
//
//    @Setup
//    @Before
//    public void setup() {
//        settings = new ChromaSettings(false, 512, 512, ChromaRenderMode.PTDL, true, AccStructType.AABB_BVH);
//        material = new Material(MaterialType.DIFFUSE, COLORS.BLUE);
//        simpleTriangle = new SimpleTriangle(
//                new ImmutableVector3(0.f, 0.f, 1.f),    //p0
//                new ImmutableVector3(1.f, 0.f, 1.f),    //p1
//                new ImmutableVector3(.0f, 1.f, 1.f),    //p2
//                new ImmutableVector3(0.f, 0.f, 1.f),    //n
//                material
//        );
//        GeometryScene scene = new GeometryScene(Arrays.asList(
//                simpleTriangle
//        ));
//        ShaderEngine.setScene(
//                scene);
//        ray = new Ray(new ImmutableVector3(0.2f, 0.2f, 1.5f), new ImmutableVector3(0.2f, -0.1f, -1.f).normalize());
//        hitpoint = scene.intersect(ray);
//    }
//
//
//    @Benchmark
//    public ImmutableVector3 benchmarkDiffuseDirectLight() {
//        ShaderEngine.getDirectRadianceSample(ray, hitpoint, 1.0f, settings);
//        )
//    }
//
//
//    @Benchmark
//    public ImmutableVector3 benchmarkDiffuseIndirectLight() {
//        ShaderEngine.getIndirectRadianceSample()
//    }
//
//
//}
