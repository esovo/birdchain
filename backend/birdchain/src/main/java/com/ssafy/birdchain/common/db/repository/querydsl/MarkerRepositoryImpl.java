package com.ssafy.birdchain.common.db.repository.querydsl;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.birdchain.common.db.dto.response.MarkerAllResDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.ssafy.birdchain.common.db.entity.QMarker.marker;

@RequiredArgsConstructor
public class MarkerRepositoryImpl implements MarkerRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<MarkerAllResDTO> findAllByType(String type) {
        QueryResults<MarkerAllResDTO> results;
        if (type.isEmpty()) {
            results = jpaQueryFactory
                    .select(Projections.constructor(MarkerAllResDTO.class
                            , marker.id
                            , marker.type
                            , marker.lan
                            , marker.lat
                            , marker.image
                    ))
                    .from(marker)
                    .fetchResults();
        } else {
            results = jpaQueryFactory
                    .select(Projections.constructor(MarkerAllResDTO.class
                            , marker.id
                            , marker.type
                            , marker.lan
                            , marker.lat
                            , marker.image
                    ))
                    .from(marker)
                    .where(marker.type.eq(type))
                    .fetchResults();

        }

        return results.getResults();
    }

}