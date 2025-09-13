package com.example.quoraapp.repositories;

import com.example.quoraapp.models.QuestionElasticDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDocumentRepository extends ElasticsearchRepository<QuestionElasticDocument, String> {

    List<QuestionElasticDocument> findByTitleContainingOrContentContaining(String title, String Content);


}
