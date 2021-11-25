package com.ofw.ofw.entity.collection;

import com.ofw.ofw.payload.collection.response.CollectionResponse;
import com.ofw.ofw.payload.collection.response.QCollectionResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.ofw.ofw.entity.collection.QCollection.collection;
import static com.ofw.ofw.entity.collection_designer.QCollectionDesigner.collectionDesigner;
import static com.ofw.ofw.entity.designer.QDesigner.designer;

@RequiredArgsConstructor
@Repository
public class QuerydslRepositoryImpl implements QuerydslRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public CollectionResponse getCollection(Long collectionId) {
        Collection collections = queryFactory
                .select(QCollection.collection)
                .from(QCollection.collection)
                .where(QCollection.collection.id.eq(collectionId))
                .fetchOne();

        return queryFactory
                .select(new QCollectionResponse(
                        collection.title,
                        collection.description,
                        designer.name.as("designer_name"),
                        designer.description.as("designer_description"),
                        designer.profile_path.as("designer_profile"))
                )
                .from(collection)
                .join(collectionDesigner.collection, collection)
                .join(collectionDesigner.designer, designer)
                .where(collectionDesigner.collection.eq(collections))
                .fetchOne();
    }

}