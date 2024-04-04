package com.example.news_app.data.base

import com.example.news_app.domain.base.BaseEntity

interface NetworkMapper<DOMAIN : BaseEntity, DATA : BaseModelDTO> {
    fun map(domainModel: DOMAIN): DATA
    fun map(dataModel: DATA): DOMAIN
}