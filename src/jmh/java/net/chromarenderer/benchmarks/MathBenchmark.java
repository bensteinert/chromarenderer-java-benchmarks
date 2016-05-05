package net.chromarenderer.benchmarks;

import org.apache.commons.math3.util.FastMath;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
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
public class MathBenchmark {

    private double randomInput = Math.random();
    private int i1 = (int) (14 * Math.random());
    private int i2 = (int) (15 * Math.random());
    private int i3 = (int) (16 * Math.random());
    private int i4 = (int) (17 * Math.random());
    private int i5 = (int) (18 * Math.random());
    private int i6 = (int) (19 * Math.random());
    private int i7 = (int) (20 * Math.random());
    private int i8 = (int) (21 * Math.random());

    private int j1 = (int) (140 * Math.random());
    private int j2 = (int) (150 * Math.random());
    private int j3 = (int) (160 * Math.random());
    private int j4 = (int) (170 * Math.random());
    private int j5 = (int) (180 * Math.random());
    private int j6 = (int) (190 * Math.random());
    private int j7 = (int) (200 * Math.random());
    private int j8 = (int) (210 * Math.random());

    private int[] result = new int[8];

    @Benchmark
    public double mathSin(){
        // jdk Math.sin has no chance at all ;)
        return FastMath.sin(randomInput);
    }

    @Benchmark
    public double mathSqrt(){
        return Math.sqrt(randomInput);
    }

    @Benchmark
    public int[] mathSimdWithInts(){
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
