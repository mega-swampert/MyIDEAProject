package com.spring;


import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.IOException;

@SpringBootTest
public class TestSpringBootSolr {

    @Autowired
    private SolrClient solrClient;


    @Test
    public void test() throws SolrServerException, IOException {
        QueryResponse query = solrClient.query(new SolrQuery("*:*"));
        SolrDocumentList results = query.getResults();
        System.out.println("总条数："+results.getNumFound());
        for (SolrDocument result:
             results) {
            System.out.println(result.get("id"));
            System.out.println(result.get("product_name"));
            
        }
    }

}
