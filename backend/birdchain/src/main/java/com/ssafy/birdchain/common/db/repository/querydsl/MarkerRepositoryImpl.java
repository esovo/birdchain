package com.ssafy.birdchain.common.db.repository.querydsl;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.birdchain.common.db.dto.response.marker.MarkerAllResDTO;
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
                            , marker.lng
                            , marker.lat
                            , marker.image
                    ))
                    .from(marker)
                    .where(marker.status.eq(true))
                    .fetchResults();
        } else {
            results = jpaQueryFactory
                    .select(Projections.constructor(MarkerAllResDTO.class
                            , marker.id
                            , marker.type
                            , marker.lng
                            , marker.lat
                            , marker.image
                    ))
                    .from(marker)
                    .where(marker.status.eq(true), marker.type.eq(type))
                    .fetchResults();

        }

        return results.getResults();
    }

}