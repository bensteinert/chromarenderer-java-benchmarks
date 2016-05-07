package net.chromarenderer.benchmarks;

import org.apache.commons.math3.util.FastMath;
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
public class MathBenchmark {

    private double randomInput;
    private int i1;
    private int i2;
    private int i3;
    private int i4;
    private int i5;
    private int i6;
    private int i7;
    private int i8;

    private int j1;
    private int j2;
    private int j3;
    private int j4;
    private int j5;
    private int j6;
    private int j7;
    private int j8;

    private int[] result;

    @Setup
    public void setup() {
        randomInput = Math.random();
        i1 = (int) (14 * Math.random());
        i2 = (int) (15 * Math.random());
        i3 = (int) (16 * Math.random());
        i4 = (int) (17 * Math.random());
        i5 = (int) (18 * Math.random());
        i6 = (int) (19 * Math.random());
        i7 = (int) (20 * Math.random());
        i8 = (int) (21 * Math.random());

        j1 = (int) (140 * Math.random());
        j2 = (int) (150 * Math.random());
        j3 = (int) (160 * Math.random());
        j4 = (int) (170 * Math.random());
        j5 = (int) (180 * Math.random());
        j6 = (int) (190 * Math.random());
        j7 = (int) (200 * Math.random());
        j8 = (int) (210 * Math.random());
        result = new int[8];
    }


    @Benchmark
    public double mathSin() {
        // jdk Math.sin has no chance at all ;)
        return FastMath.sin(randomInput);
    }


    @Benchmark
    public double mathSqrt() {
        return Math.sqrt(randomInput);
    }


    @Benchmark
    public int[] mathSimdWithInts() {
        result[0] = i1 + j1;
        result[1] = i2 + j2;
        result[2] = i3 + j3;
        result[3] = i4 + j4;
        result[4] = i5 + j5;
        result[5] = i6 + j6;
        result[6] = i7 + j7;
        result[7] = i8 + j8;
        return result;
    }
}
