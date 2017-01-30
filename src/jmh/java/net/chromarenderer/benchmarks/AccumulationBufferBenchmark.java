package net.chromarenderer.benchmarks;

import net.chromarenderer.math.random.MersenneTwisterFast;
import net.chromarenderer.renderer.canvas.ChromaCanvas;
import net.chromarenderer.renderer.canvas.ParallelStreamAccumulationBuffer;
import net.chromarenderer.renderer.canvas.SingleThreadedAccumulationBuffer;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author bensteinert
 */
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.SingleShotTime)
@Fork(value = 1)
@Measurement(iterations = 100, batchSize = 1)
@State(Scope.Thread)
public class AccumulationBufferBenchmark {

    private MersenneTwisterFast mt;
    private SingleThreadedAccumulationBuffer sTAccBuff;
    private ParallelStreamAccumulationBuffer mTAccBuff;
    private ChromaCanvas image;


    @Setup
    public void setup() {
        mt = new MersenneTwisterFast(13499);
        image = new ChromaCanvas(1024, 1024);
        sTAccBuff = new SingleThreadedAccumulationBuffer(1024, 1024);
        mTAccBuff = new ParallelStreamAccumulationBuffer(1024, 1024);
        Arrays.stream(image.getPixels()).forEach(pixel -> {
            pixel.set(mt.nextFloat(), mt.nextFloat(), mt.nextFloat());
        });
    }


    @Benchmark
    public SingleThreadedAccumulationBuffer accumulateSingleThreaded() {
        return sTAccBuff.accumulate(image.getPixels());
    }

    @Benchmark
    public SingleThreadedAccumulationBuffer accumulateMultiThreaded() {
        return mTAccBuff.accumulate(image.getPixels());
    }

}
