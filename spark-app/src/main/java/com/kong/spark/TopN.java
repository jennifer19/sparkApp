package com.kong;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.function.Consumer;

/**
 * Created by kong on 2016/4/23.
 */
public class TopN {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("top5Java").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaPairRDD<Integer, Integer> pairRDD = sc.textFile("E:\\testData\\top5.txt").mapToPair(new PairFunction<String, Integer, Integer>() {
            @Override
            public Tuple2<Integer, Integer> call(String s) throws Exception {
                return new Tuple2<Integer, Integer>(Integer.parseInt(s), Integer.parseInt(s));
            }
        });

        pairRDD.sortByKey(false).map(new Function<Tuple2<Integer,Integer>, Integer>() {
            @Override
            public Integer call(Tuple2<Integer, Integer> result) throws Exception {
                return result._2();
            }
        }).take(5).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
