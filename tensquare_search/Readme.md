
# ElasticSearch 

    docker pull elasticsearch:5.6.8 
    docker run -di --name=elasticsearch -p 9200:9200 -p 9300:9300 elasticsearch:5.6.8
    
安装IK分词器 :

下载IK分词器包,直接放到 Elasticsearch/plugins 目录下. [容器也可以直接放]
    
    IK提供了两个分词算法ik_smart 和 ik_max_word
    其中 ik_smart 为最少切分，ik_max_word为最细粒度划分

9200端口 是 http进行管理的端口.

9300 是java专用端口


ElasticSearch 的POJO的注意事项:

    /**
     * 文章索引的实体类,其实也就是取Article实体类的部分字段,用于索引库中.
     */
    @Document(indexName = "tensquare",type = "article")
    public class Article implements Serializable {    
        @Id
        private String id; //文章ID  存储.
        // 是否索引,就是该域是否能被搜索
        // 是否分词,就是表示搜索的时候,是整体匹配和是分词匹配
        // 是否存储,就是是否在页面展示.
        @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
        private String title; // 文章的Title


    
    






