package net.chromarenderer.benchmarks;

import net.chromarenderer.math.ImmutableVector3;
import net.chromarenderer.math.Vector3;
import net.chromarenderer.math.raytracing.Ray;
import net.chromarenderer.renderer.scene.acc.AxisAlignedBoundingBox;
import net.chromarenderer.renderer.scene.acc.IntersectionContext;
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
@State(Scope.Benchmark)
public class BenchmarkAxisAlignedBoundingBoxIntersection {

    private AxisAlignedBoundingBox bBox;
    private IntersectionContext ctx;

    @Setup
    public void setup(){
        bBox = new AxisAlignedBoundingBox(Vector3.ORIGIN, Vector3.ONE);
        Ray ray = new Ray(new ImmutableVector3(0.5f, 0.5f, 2.f), new ImmutableVector3(0.f, 0.f, -1.f));
        ctx = new IntersectionContext();
        ctx.reinit(ray);
    }

    @Benchmark
    public int benchmarkAABBIntersect() {
        return bBox.intersects(ctx);
    }

}
