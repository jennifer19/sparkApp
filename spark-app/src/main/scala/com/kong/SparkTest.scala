package com.kong

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by 32 on 2016/4/22.
  */
object SparkTest {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("test").setMaster("local")
    val sc = new SparkContext(conf)
    sc.parallelize(1 to 100)
  }
}
