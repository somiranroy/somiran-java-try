package com.somiran.lall.elk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class TalkToElk {
    
    
    /**
     * 
     * @return
     */
    private RestHighLevelClient getClient() {
        
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("vpc-fe-transaction-api-elu3cfayllw2uyta5x4fi7k6au.us-east-1.es.amazonaws.com", 9200, "http")));
        
        return client;
    }
    
    
    
//    
//    public void testGet() throws IOException {
//        
//        RestHighLevelClient client = getClient();
//
//        GetRequest getRequest = new GetRequest(
//                "feobjecttransactionstatus",  // Index
//                "fePackageStore-1500486924486-1444-58257-0001");   
//        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
//        
//        String index = getResponse.getIndex();
//        String id = getResponse.getId();
//        
//        if (getResponse.isExists()) {
//            long version = getResponse.getVersion();
//            String sourceAsString = getResponse.getSourceAsString();        
//            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap(); 
//            
//            System.out.println("index: " + index);
//            System.out.println("id: " + id);
//            System.out.println("Version: " + version);
//            System.out.println("sourceAsString: " + sourceAsString);
//            System.out.println("sourceAsMap: " + sourceAsMap);
//            
//        } else {
//            System.out.println("Some Problem... ");
//        }
//        
//        
//        destroy(client);
//    }
    
    public void mustGet() throws IOException {
        
        RestHighLevelClient client = getClient();
        
        QueryBuilder builder = QueryBuilders
                .boolQuery()
                .must(QueryBuilders.matchPhraseQuery("transactionId", "fePackageStore-1622846849430-4578-7"));
                //.mustNot(QueryBuilders.matchQuery("component","feAccountStreamProcessor"));
        
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(builder);
        
        SearchRequest searchRequest = new SearchRequest("fetransactiondetail");
        
        searchRequest.source(sourceBuilder); 
        
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        if(response.getHits() != null) {
            
            SearchHit[] allHits = response.getHits().getHits();
            System.out.println(allHits.length);
            
            
            for(int i =0; i < allHits.length; i++) {
                System.out.println(allHits[i].getSourceAsString());
            }
        }
        
    }
    
    
    public List<FeTransactionDetail> getFeTransaction(String tranactionId) throws IOException {
        
        List<FeTransactionDetail> reponse = new ArrayList<FeTransactionDetail>();
        
        RestHighLevelClient client = getClient();
        
        QueryBuilder builder = QueryBuilders
                .boolQuery()
                .must(QueryBuilders.matchPhraseQuery("transactionId", tranactionId));
        
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.size(1000);
        sourceBuilder.query(builder);
        
        SearchRequest searchRequest = new SearchRequest("fetransactiondetail");
        
        searchRequest.source(sourceBuilder); 
       
        
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        if(response.getHits() != null) {
            
            SearchHit[] allHits = response.getHits().getHits();
            
            if(null != allHits) {
                System.out.println("Total Number of TransactionStatus Object is : " + allHits.length);
                
                for(int i =0; i < allHits.length; i++) {
                    System.out.println("FeTransactionObject: " + allHits[i].getSourceAsString());
                    
                    Map<String, Object> transactionObject = allHits[i].getSourceAsMap();
                    FeTransactionDetail feTransactionDetail = new FeTransactionDetail();
                    feTransactionDetail.setTransactionId(tranactionId);
                    feTransactionDetail.setCreateDate((String)transactionObject.get("createDate"));
                    feTransactionDetail.setAffectedAccountCount((Integer)transactionObject.get("affectedAccountCount"));
                    feTransactionDetail.setAffectedDeviceCount((Integer)transactionObject.get("affectedDeviceCount"));
                    feTransactionDetail.setData((String)transactionObject.get("data"));
                    feTransactionDetail.setId((String)transactionObject.get("objectId"));
                    feTransactionDetail.setIdType((String)transactionObject.get("idType"));
                    feTransactionDetail.setComponent((String)transactionObject.get("component"));
                    
                    reponse.add(feTransactionDetail);
                }
            }

        }
        return reponse;
    }
    
    
    public List<FeObjectTransactionStatus> getFeObjectTransactionStatus(String tranactionId) throws IOException {
        
        List<FeObjectTransactionStatus> reponse = new ArrayList<FeObjectTransactionStatus>();
        
        RestHighLevelClient client = getClient();
        
        QueryBuilder builder = QueryBuilders
                .boolQuery()
                .must(QueryBuilders.matchPhraseQuery("transactionId", tranactionId));
        
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.size(1000);
        sourceBuilder.query(builder);
        
        SearchRequest searchRequest = new SearchRequest("feobjecttransactionstatus");
        
        searchRequest.source(sourceBuilder); 
        
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        if(response.getHits() != null) {
            
            SearchHit[] allHits = response.getHits().getHits();
            
            if(null != allHits) {
                System.out.println("Total Number of feobjecttransactionstatus Object is : " + allHits.length);
                
                for(int i =0; i < allHits.length; i++) {
                    System.out.println("feobjecttransactionstatus: " + allHits[i].getSourceAsString());
                    
                    Map<String, Object> transactionObject = allHits[i].getSourceAsMap();
                    
                    FeObjectTransactionStatus feObjectTransactionStatus = new FeObjectTransactionStatus();
                    feObjectTransactionStatus.setTransactionId(tranactionId);
                    feObjectTransactionStatus.setCreateDate((String)transactionObject.get("createDate"));
                    feObjectTransactionStatus.setStatus((String)transactionObject.get("status"));
                    
                    feObjectTransactionStatus.setId((String)transactionObject.get("objectId"));
                    feObjectTransactionStatus.setIdType((String)transactionObject.get("idType"));
                    
                    reponse.add(feObjectTransactionStatus);
                }
            }
        }
        return reponse;
    }
    
    
    
    
    public FeTransactionStatus getTransactionStatus(String transactionId) throws IOException {
        
        FeTransactionStatus status = new FeTransactionStatus();
        status.setTransactionId(transactionId);
        status.setData("Components Updated: ");
        
        getFeTransaction(transactionId).stream().forEach(eachStatus -> {
            
            status.setAffectedDeviceCount(eachStatus.getAffectedDeviceCount() + status.getAffectedDeviceCount());
            status.setAffectedAccountCount(eachStatus.getAffectedAccountCount() + status.getAffectedAccountCount());
            
            status.setData((null == status.getData()) ? eachStatus.getData(): status.getData() + "," + eachStatus.getData());
            
            status.setCreateDate(eachStatus.getCreateDate());
            status.setId((null == status.getId())?eachStatus.getId(): status.getId() + "," + eachStatus.getId());
            status.setIdType((null == status.getIdType()) ? eachStatus.getIdType() : status.getIdType() + "," + eachStatus.getIdType());
        });
        
        
        getFeObjectTransactionStatus(transactionId).stream().forEach(so -> {
            if(so.getIdType().contains("FeAccount")) {
                if("success".equals(so.getStatus())) {
                    status.setSuccessAccountCount(status.getSuccessAccountCount() + 1);
                } else {
                    status.setFailedAccountCount(status.getFailedAccountCount() + 1);
                }
            } else if(so.getIdType().contains("FeDevice")) {
                if("success".equals(so.getStatus())) {
                    status.setSuccessDeviceCount(status.getSuccessDeviceCount() + 1);
                } else {
                    status.setFailedDeviceCount(status.getFailedDeviceCount() + 1);
                }
            }
        });

        System.out.println("\n\n" + status);
        return status;
        
    }
    

//    public static void main(String[] args) {
//        
//        TalkToElk application = new TalkToElk();
//        try {
//            //application.getFeTransaction("fePackageStore-1622846849430-4578-7").stream().forEach(s -> System.out.println(s));
//            //application.getFeObjectTransactionStatus("fePackageStore-1622847058560-4578-8");    
//            
//            application.getTransactionStatus("fePackageStore-1622847058560-4578-8");
//        } catch (IOException e) {
//            
//            e.printStackTrace();
//        }
//        
//        
//    }
    

}
