package com.eslam.entity.response

import com.eslam.entity.Keyword
import com.eslam.entity.NetworkResponseModel

data class KeywordListResponse(
  val id: Int,
  val keywords: List<Keyword>
) : NetworkResponseModel
