//package com.spring;
//
//import org.apache.solr.client.solrj.SolrQuery;
//import org.apache.solr.client.solrj.SolrServerException;
//import org.apache.solr.client.solrj.response.QueryResponse;
//import org.apache.solr.common.SolrDocument;
//import org.apache.solr.common.SolrDocumentList;
//import org.apache.solr.common.SolrInputDocument;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//@SpringBootTest
//class SpringBoot15SolrApplicationTests {
//
//    /**
//     * 添加对象
//     * @throws IOException
//     * @throws SolrServerException
//     */
//    @Test
//   public void testAddDocument() throws IOException, SolrServerException {
//       //创建solrj对象
//        HttpSolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr");
//        SolrInputDocument doc = new SolrInputDocument();
//
//        doc.addField("id","21");
//        doc.addField("product_name","IphoneXX");
//        doc.addField("product_catalog","3");
//        doc.addField("product_catalog_name","手机");
//        doc.addField("product_price","6000");
//
//        doc.addField("product_description","iPhone是由美国苹果公司研发的智能手机系列，搭载其研发的iOS操作系统。");
//        doc.addField("product_picture","fsdafs1521.jpg");
//
//        solrServer.add(doc);
//        solrServer.commit();
//
//    }
//
//    /**
//     * 删除solr对象
//     * @throws IOException
//     * @throws SolrServerException
//     */
//    @Test
//    public void testDeleteDocument() throws IOException, SolrServerException {
//        HttpSolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr");
//        solrServer.deleteById("55654");
//        solrServer.commit();
//
//    }
//
//
//    @Test
//    public void testQuery() throws SolrServerException {
//        HttpSolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr");
//        //创建查询对象
//        SolrQuery solrQuery = new SolrQuery();
//        //设置页面中的查询条件 有两个字段
//        solrQuery.set("q","*:*");
//        QueryResponse queryResponse = solrServer.query(solrQuery);
//
//        //获取response结果
//        SolrDocumentList results = queryResponse.getResults();
//        System.out.println("总共商品数"+results.getNumFound());
//        for (SolrDocument result: results) {
//            System.out.println(result.get("id"));
//            System.out.println(result.get("product_name"));
//            System.out.println(result.get("product_catalog_name"));
//            System.out.println(result.get("product_description"));
//            System.out.println("--------------------------------");
//        }
//    }
//
//
//    /**
//     * 使用默认域查询
//     * @throws SolrServerException
//     */
//    @Test
//    public void testQueryDefaultField() throws SolrServerException {
//        HttpSolrServer httpSolrServer = new HttpSolrServer("http://localhost:8080/solr/collection1");
//        SolrQuery solrQuery = new SolrQuery();
//        //指定默认域
//        solrQuery.set("df","product_keywords");
//
//        solrQuery.setQuery("三国");
//        QueryResponse queryResponse = httpSolrServer.query(solrQuery);
//        SolrDocumentList results = queryResponse.getResults();
//        System.out.println("总共商品数"+results.getNumFound());
//        for (SolrDocument result: results) {
//            System.out.println(result.get("id"));
//            System.out.println(result.get("product_name"));
//            System.out.println(result.get("product_catalog_name"));
//            System.out.println(result.get("product_description"));
//            System.out.println("--------------------------------");
//        }
//    }
//
//
//    /**
//     * 使用分页查询
//     * @throws SolrServerException
//     */
//    @Test
//    public void testQueryPage() throws SolrServerException {
//        HttpSolrServer httpSolrServer = new HttpSolrServer("http://localhost:8080/solr/collection1");
//        SolrQuery solrQuery = new SolrQuery();
//        //指定分页 pageNow pageSize
//        int pageNow=1,pageSize=5;
//        //指定起始
//        solrQuery.set("start",(pageNow-1)*pageSize);
//        //指定每页显示条数
//        solrQuery.set("rows",pageSize);
//
//        solrQuery.setQuery("三国");
//        QueryResponse queryResponse = httpSolrServer.query(solrQuery);
//        SolrDocumentList results = queryResponse.getResults();
//        System.out.println("总共商品数"+results.getNumFound());
//        for (SolrDocument result: results) {
//            System.out.println(result.get("id"));
//            System.out.println(result.get("product_name"));
//            System.out.println(result.get("product_catalog_name"));
//            System.out.println(result.get("product_description"));
//            System.out.println("--------------------------------");
//        }
//    }
//
//
//    /**
//     * 查询结果中指定的域
//     * @throws SolrServerException
//     */
//    @Test
//    public void testQueryFieldInResult() throws SolrServerException {
//        HttpSolrServer httpSolrServer = new HttpSolrServer("http://localhost:8080/solr/collection1");
//        SolrQuery solrQuery = new SolrQuery();
//        //指定分页 pageNow pageSize
//        int pageNow=1,pageSize=5;
//        //指定起始
//        solrQuery.set("start",(pageNow-1)*pageSize);
//        //指定每页显示条数
//        solrQuery.set("rows",pageSize);
//
//        //指定查询结果中只存在的域
//        solrQuery.set("fl","id,product_name");
//
//        solrQuery.setQuery("三国");
//        QueryResponse queryResponse = httpSolrServer.query(solrQuery);
//        SolrDocumentList results = queryResponse.getResults();
//        System.out.println("总共商品数"+results.getNumFound());
//        for (SolrDocument result: results) {
//            System.out.println(result.get("id"));
//            System.out.println(result.get("product_name"));
//            System.out.println(result.get("product_catalog_name"));
//            System.out.println(result.get("product_description"));
//            System.out.println("--------------------------------");
//        }
//    }
//
//
//    /**
//     * 过滤查询
//     * @throws SolrServerException
//     */
//    @Test
//    public void testFilterQuery() throws SolrServerException {
//        HttpSolrServer httpSolrServer = new HttpSolrServer("http://localhost:8080/solr/collection1");
//        SolrQuery solrQuery = new SolrQuery();
//        //指定分页 pageNow pageSize
//        int pageNow=1,pageSize=5;
//        //指定起始
//        solrQuery.set("start",(pageNow-1)*pageSize);
//        //指定每页显示条数
//        solrQuery.set("rows",pageSize);
//
//        //指定查询结果中只存在的域
//        solrQuery.set("fl","id,product_name");
//
//        //过滤 关系是OR
////        solrQuery.set("fq","product_catalog_name:手机");
////        solrQuery.set("fq","product_price:[* TO 10000]");
//
//        //过滤 关系AND
//        solrQuery.setFilterQueries("product_name:手机","product_price:[* TO 10000]");
//
//        solrQuery.setQuery("三国");
//        QueryResponse queryResponse = httpSolrServer.query(solrQuery);
//        SolrDocumentList results = queryResponse.getResults();
//        System.out.println("总共商品数"+results.getNumFound());
//        for (SolrDocument result: results) {
//            System.out.println(result.get("id"));
//            System.out.println(result.get("product_name"));
//            System.out.println(result.get("product_catalog_name"));
//            System.out.println(result.get("product_description"));
//            System.out.println("--------------------------------");
//        }
//    }
//
//
//    /**
//     * 指定排序字段
//     * @throws SolrServerException
//     */
//    @Test
//    public void testQuerySort() throws SolrServerException {
//        HttpSolrServer httpSolrServer = new HttpSolrServer("http://localhost:8080/solr/collection1");
//        SolrQuery solrQuery = new SolrQuery();
//        //指定分页 pageNow pageSize
//        int pageNow=1,pageSize=5;
//        //指定起始
//        solrQuery.set("start",(pageNow-1)*pageSize);
//        //指定每页显示条数
//        solrQuery.set("rows",pageSize);
//
//        //指定查询结果中只存在的域
//        solrQuery.set("fl","id,product_name");
//
//        //过滤 关系是OR
////        solrQuery.set("fq","product_catalog_name:手机");
////        solrQuery.set("fq","product_price:[* TO 10000]");
//
//        //过滤 关系AND
////        solrQuery.setFilterQueries("product_name:手机","product_price:[* TO 10000]");
//
//        //指定排序
//        solrQuery.setSort("product_price", SolrQuery.ORDER.desc);
//
//
//        solrQuery.setQuery("三国");
//        QueryResponse queryResponse = httpSolrServer.query(solrQuery);
//        SolrDocumentList results = queryResponse.getResults();
//        System.out.println("总共商品数"+results.getNumFound());
//        for (SolrDocument result: results) {
//            System.out.println(result.get("id"));
//            System.out.println(result.get("product_name"));
//            System.out.println(result.get("product_catalog_name"));
//            System.out.println(result.get("product_description"));
//            System.out.println("--------------------------------");
//        }
//    }
//
//
//    /**
//     * 高亮
//     * @throws SolrServerException
//     */
//    @Test
//    public void testHighlighter() throws SolrServerException {
//        HttpSolrServer httpSolrServer = new HttpSolrServer("http://localhost:8080/solr/collection1");
//        SolrQuery solrQuery = new SolrQuery();
//        //指定分页 pageNow pageSize
//        int pageNow=1,pageSize=5;
//        //指定起始
//        solrQuery.set("start",(pageNow-1)*pageSize);
//        //指定每页显示条数
//        solrQuery.set("rows",pageSize);
//
//        //指定查询结果中只存在的域
//        solrQuery.set("fl","id,product_name");
//
//        //过滤 关系是OR
////        solrQuery.set("fq","product_catalog_name:手机");
////        solrQuery.set("fq","product_price:[* TO 10000]");
//
//        //过滤 关系AND
////        solrQuery.setFilterQueries("product_name:手机","product_price:[* TO 10000]");
//
//        //指定排序
//        solrQuery.setSort("product_price", SolrQuery.ORDER.desc);
//
//        //开启高亮
//        solrQuery.setHighlight(true);
//        //指定高亮前缀
//        solrQuery.setHighlightSimplePre("<span sytle='color:red'>");
//        //指定高亮后缀
//        solrQuery.setHighlightSimplePost("</span>");
//        //指定高亮域
//        solrQuery.addHighlightField("product_name");
//
//        QueryResponse queryResponse = httpSolrServer.query(solrQuery);
//        //从response结果中获取高亮
//        Map<String, Map<String, List<String>>> responseHighlighting = queryResponse.getHighlighting();
//
//
//
//        SolrDocumentList results = queryResponse.getResults();
//        System.out.println("总共商品数"+results.getNumFound());
//        for (SolrDocument result: results) {
//            System.out.println(result.get("id"));
//            System.out.println(result.get("product_name"));
//            System.out.println(result.get("product_catalog_name"));
//            System.out.println(result.get("product_description"));
//            System.out.println("-------------高亮后的结果---------------");
//            Map<String, List<String>> idlist = responseHighlighting.get(result.get("id"));
//            if(idlist.containsKey("product_name")){
//                System.out.println(idlist.get("product_name").get(0));
//            }
//        }
//    }
//
//
//    /**
//     * 综合查询
//     * @throws SolrServerException
//     */
//    @Test
//    public void testAllQuery() throws SolrServerException {
//        HttpSolrServer httpSolrServer = new HttpSolrServer("http://localhost:8080/solr/collection1");
//        SolrQuery solrQuery = new SolrQuery();
//
//        //example 指定默认域，查询条件为三国，过滤条件为书籍价格大于1000， 排序条件为价格，开启分页，高亮展示，响应结果只有id name price
//        solrQuery.setQuery("三国")
//                .setFilterQueries("product_catalog_name:书籍","product_price:[1000 TO *]")
//                .setSort("product_price", SolrQuery.ORDER.asc)
//                .setHighlight(true)
//                .setHighlightSimplePre("<span style='color:red;'>")
//                .setHighlightSimplePost("</span>")
//                .addHighlightField("product_name")
//                .set("start",1)
//                .set("rows",1000)
//                .set("df","product_keywords")
//                .set("fl","*,score");
//
//        QueryResponse queryResponse = httpSolrServer.query(solrQuery);
//        //从response结果中获取高亮
//        Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
//        SolrDocumentList results = queryResponse.getResults();
//        System.out.println("总共商品数"+results.getNumFound());
//        for (SolrDocument result: results) {
//            System.out.println(result.get("id"));
//            Map<String, List<String>> listMap = highlighting.get(result.get("id"));
//            if(listMap.containsKey("product_name")) {
//                System.out.println(listMap.get("product_name").get(0));
//            }else{
//                System.out.println(result.get(result.get("product_name")));
//            }
//
//
//
//
//
//            System.out.println(result.get("product_name"));
//            System.out.println(result.get("product_catalog_name"));
//            System.out.println(result.get("product_description"));
//
//            }
//        }
//
//
//}
//
//
