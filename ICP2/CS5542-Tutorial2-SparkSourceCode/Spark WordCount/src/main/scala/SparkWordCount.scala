import org.apache.spark.{SparkConf,SparkContext}

object SparkWordCount{
  def main(args: Array[String]): Unit ={
    System.setProperty("hadoop.home.dir","C:\\Users\\Pavankumar Manchala\\Downloads\\hadoop-2.7.7-src")
    val conf = new SparkConf().setAppName("group by example").setMaster("local").set("spark.driver.host","localhost")
    val sc = new SparkContext(conf)
    val f=sc.textFile("C:\\BigDataAnalyticsAppns\\ICP2\\CS5542-Tutorial2-SparkSourceCode\\Spark WordCount\\input")
    val wc=f.flatMap(line=>{line.split(" ")})
    val out=wc.groupBy(word=>word.charAt(0))
    out.foreach(println)
  }
}